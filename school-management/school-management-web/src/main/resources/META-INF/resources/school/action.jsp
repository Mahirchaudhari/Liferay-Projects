<%@ include file="../init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	School school = (School) row.getObject();
%>

<portlet:renderURL var="updateSchoolRenderURL">
	<portlet:param name="schoolId" value = "<%=String.valueOf(school.getSchoolId()) %>" />
	<portlet:param name="mvcRenderCommandName" value="/school/updateSchool" />
    <portlet:param name="mvcPath" value="/school/add_update_school.jsp"/>
</portlet:renderURL>

<portlet:actionURL var="deleteSchoolRenderURL" name="/school/deleteSchool">
	<portlet:param name="schoolId" value = "<%=String.valueOf(school.getSchoolId()) %>" />
</portlet:actionURL>



<liferay-ui:icon-menu
    direction="left-side"
    markupView="lexicon"
    showWhenSingleIcon="<%= true %>"
>
	<c:if test="<%=SchoolModelResourcePermission.contains(permissionChecker, school, "UPDATE_SCHOOL") %>">
    	<liferay-ui:icon image="edit" message="Edit"
		url="<%=updateSchoolRenderURL.toString()%>" />
    </c:if>
	
	<c:if test="<%=SchoolModelResourcePermission.contains(permissionChecker, school, "DELETE_SCHOOL") %>">
		<liferay-ui:icon image="delete" message="Delete"
			url="<%=deleteSchoolRenderURL.toString()%>" />
	</c:if>

</liferay-ui:icon-menu>