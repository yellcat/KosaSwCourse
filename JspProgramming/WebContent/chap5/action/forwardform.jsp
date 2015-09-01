<%@ page contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String name = request.getParameter("name");
String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		forwardform.jsp
		<form>
			ID: <%=id %><br/>
			Name: <%=name %><br/>
			Email: <%=email %><br/>
		</form>
	</body>
</html>