<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h4>새로운 세션인지 조사</h4>
		<hr/>
		<%if(session.isNew()){%>
		처음접속
		<%}else { %>
		재접속
		<%} %>
		세션ID: <%=session.getId() %><br/>
		세션 비활성 주기: <%=session.getMaxInactiveInterval()%>
	</body>
</html>