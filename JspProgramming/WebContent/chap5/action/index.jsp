<%@ page contentType="text/html; charset=UTF-8"%>
<%
String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h4>&lt; %@ include %&gt;</h4>
			<a href="include.jsp">include.jsp</a>
			
		<h4>&lt; %@ forward %&gt;</h4>
			<a href="forward.jsp?email=hong@naver.com">forward.jsp</a>
	</body>
</html>