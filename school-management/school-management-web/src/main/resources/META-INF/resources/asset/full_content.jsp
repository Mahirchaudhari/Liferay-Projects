<%@include file="../init.jsp"%>

<%
School school = (School)request.getAttribute("school");
%>

<dl>
		<dt>Name</dt>
		<dd><%= school.getName() %></dd>
</dl>