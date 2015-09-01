<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		save.jsp
		<hr/>
		<%
		session.setAttribute("name1", "홍홍홍");
		session.setAttribute("name2", "hong");
		session.setAttribute("age", 35);
		%>
		세션 저장 뿅
	</body>
</html>