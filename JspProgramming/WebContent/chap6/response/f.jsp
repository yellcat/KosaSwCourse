<%@ page contentType="text/html; charset=UTF-8"%>
<%
String username = request.getParameter("username");
String age= request.getParameter("age");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		f.jsp
		<hr/>
		username: <%=username %>
		age: <%=age %>
	</body>
</html>