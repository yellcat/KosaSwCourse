<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import = "java.net.*" %>
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
		/* 클라이언트가 보낸 모든 정보는 request에 저장된다 */
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies){
			String name = cookie.getName();
			String value = cookie.getValue();
			value = URLDecoder.decode(value, "UTF-8");%>
			
			<%=name %> : <%=value %> <br/>
		<%} %>
	</body>
</html>