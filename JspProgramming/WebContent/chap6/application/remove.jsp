<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		remove.jsp
		<hr/>
		<%
		application.removeAttribute("name1");
		application.removeAttribute("name2");
		application.removeAttribute("age");
		%>
		앱 삭제뿅
	</body>
</html>