<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import = "java.net.*" %>
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
		String name1 = URLEncoder.encode("홍홍홍", "UTF-8");
		Cookie cookie1 = new Cookie("name1", name1);
		Cookie cookie2 = new Cookie("name2", "hong");
		cookie2.setMaxAge(365*24*60*60);
		
		/* defualt라면 메모리에만 저장된다, 브라우저가 꺼지면 사라진다 */
		/* setMaxAge(a)는 a초간 데이터를 저장한다 */
		/* 쿠키를 보낸다(http헤더에 실려서 보내진다) */
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		%>
		쿠키가 잘 저장되었습니다.
	</body>
</html>