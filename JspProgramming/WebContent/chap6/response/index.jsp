<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h4>[리다이렉트]</h4>
		<a href="a.jsp">a.jsp</a>
		
		<h4>[포워드]P.182</h4>
		<a href="c.jsp">c.jsp</a>
		
		<h4>[데이터 전달]</h4>
		<a href="e.jsp?username=hongkildong">e.jsp(redirect)</a>
		<a href="g.jsp?username=hongkildong">g.jsp(forward)</a>
		
		<h4>[책 예제 실습]</h4>
		<a href="page_control.jsp">page_control.jsp</a>
		
		<h4>[개성 없애기]</h4>
		<a href="no_cache.jsp">no_caache.jsp</a>
	</body>
</html>