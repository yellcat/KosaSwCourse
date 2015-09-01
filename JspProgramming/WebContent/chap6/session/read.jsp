<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		read.jsp
		<hr/>
		<%
		String name1 = (String)session.getAttribute("name1");
		String name2 = (String)session.getAttribute("name2");
		Integer age = (Integer)session.getAttribute("age");
		%>
		name1: <%=name1 %><br/>
		name2: <%=name2 %><br/>
		age: <%=age %> <br/>
		출력이완료되었다
	</body>
</html>