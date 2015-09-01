<%@ page contentType="text/html; charset=UTF-8"%>


<%
request.setCharacterEncoding("UTF-8");
%>

<jsp:forward page="forwardform.jsp">
	<jsp:param value="fall" name="id"/>
	<jsp:param value="삼겹살" name="name"/>
</jsp:forward>