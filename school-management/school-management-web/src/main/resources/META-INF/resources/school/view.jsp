<%@ include file="../init.jsp" %>

<liferay-ui:error key="error-while-searching-school" message="Error while searching School" />
<liferay-ui:error key="error-adding-school" message="Error while adding school" />
<liferay-ui:error key="error-updating-school" message="Error while updating school" />
<liferay-ui:error key="error-deleting-school" message="Error while deleting school" />

<liferay-ui:success key="success-adding-school" message="School added successfully" />
<liferay-ui:success key="success-updating-school" message="School updated successfully" />
<liferay-ui:success key="success-deleted-school" message="School deleted successfully" />

<portlet:renderURL var="addSchoolRenderURL">
    <portlet:param name="mvcPath" value="/school/add_update_school.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="searchURL">
</portlet:renderURL>

<aui:form action="${searchURL}" name="fm">

	<div class="row">
		<div class="col-md-8">
			<aui:input inlineLabel="left" label="" name="keywords" placeholder="search-entries" size="256" />
		</div>

		<div class="col-md-4">
			<aui:button type="submit" value="search" />
		</div>
	</div>
</aui:form>

<c:if test="<%=SchoolPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), "CREATE_SCHOOL") %>">
	<div class="mb-5">
	    <a href="<%= addSchoolRenderURL %>" class="btn  btn-primary btn-default">
	        <i class="glyphicon glyphicon-plus"></i> Add School
	    </a>
	</div>
</c:if>

<c:if test="<%=SchoolPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), "VIEW") %>">
	<liferay-ui:search-container total="<%= GetterUtil.getInteger(renderRequest.getAttribute("totalSchools"))%>"
			emptyResultsMessage="No School were found" >

			<liferay-ui:search-container-results
				results="<%=ListUtil.subList((List) renderRequest.getAttribute("totalSchoolsList"), searchContainer.getStart(), searchContainer.getEnd()) %>" />

			<liferay-ui:search-container-row
				className="com.gsb.school.management.model.School" modelVar="school">

				<liferay-ui:search-container-column-text name="School Name"
					property="name"/>
					
				<liferay-ui:search-container-column-text name="School State"
					property="city"/>
					
				<liferay-ui:search-container-column-text name="School City"
					property="state"/>
					
				<liferay-ui:search-container-column-text name="School Rating"
					property="rating"/>
				
				<liferay-ui:search-container-column-text name="Total School Students"
					property="totalStudents"/>
					
				<liferay-ui:search-container-column-jsp  cssClass="entry-action-column"
					path="/school/action.jsp" />

			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator  paginate="true" markupView="lexicon"/>
	</liferay-ui:search-container>
</c:if>
