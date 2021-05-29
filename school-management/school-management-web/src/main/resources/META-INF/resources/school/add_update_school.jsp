<%@ include file="../init.jsp" %>

<%
School school = (School)renderRequest.getAttribute("editSchool");
%>

<portlet:actionURL name="/school/addUpdateSchool" var="addUpdateSchoolActionURL"/>

<aui:form action="<%=addUpdateSchoolActionURL %>" name="schoolForm" method="POST">
	
	<aui:input type="hidden" name="schoolId" value="<%= Validator.isNotNull(school)?school.getSchoolId():0 %>"/>
	
	<aui:input label="Name of School" name="name" value="<%= Validator.isNotNull(school)?school.getName():"" %>">
 		<aui:validator name="required"/>
	</aui:input>

	<aui:input label="City" name="city" value="<%= Validator.isNotNull(school)?school.getCity():"" %>">
 		<aui:validator name="required"/>
	</aui:input> 

	<aui:input label="State" name="state" value="<%= Validator.isNotNull(school)?school.getState():"" %>" >
 		<aui:validator name="required"/>
	</aui:input>

	<aui:input label="Total Students" name="totalStudents" value="<%= Validator.isNotNull(school)?school.getTotalStudents():0 %>">
 		<aui:validator name="required"/>
 		<aui:validator name="number"/>
	</aui:input>  
	
	<aui:select label="Rating" id="rating" name="rating" value="<%= Validator.isNotNull(school)?school.getRating():1 %>">
	    <aui:option value="1">1</aui:option>                       
	    <aui:option value="2">2</aui:option>                            
	    <aui:option value="3">3</aui:option>                            
	    <aui:option value="4">4</aui:option>
	    <aui:option value="5">5</aui:option>    
	</aui:select>

	<aui:button type="submit" name="" value="Submit"></aui:button>
</aui:form>