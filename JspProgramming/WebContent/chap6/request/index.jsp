<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		
	</head>
	<body>
		<h4>[요청 파라메타 값 받기]</h4>
		<a href="request_form.html">request_form.html</a>
		<h4>[요청 방식]</h4>
		<p>1. GET 방식</p>
		<ul>
			<li>URL 직접입력</li>	
			
			<li>&lt; a &gt; 방식: 
				<a href="getMethod.jsp?id=white&name=HongGilDong">getMethod.jsp</a></li>
				
			<li>&lt; form method="GET"&gt;:
			<form method="GET" action="getMethod.jsp"> 
				아이디: <input type="text" name="id"/><br/>
				이&nbsp&nbsp&nbsp름: <input type="text" name="name"/><br/>
				<input type="submit" value="getMethod.jsp"></li>
			</form>	
		</ul>
				<a>2. POST 방식</a>
		<ul>
			<li>1)&lt; form method="POST"&gt;: 
			<form method="POST" action="getMethod.jsp">
				아이디: <input type="text" name="id"/><br/>
				이&nbsp&nbsp&nbsp름: <input type="text" name="name"/><br/>
				<input type="submit" value="getMethod.jsp"></li>
			</form>
		</ul>
		
		<h4>[클라이언트IP]</h4>
		<%=request.getRemoteAddr()%>
		
		<h4>[클라이언트 OS 및 브라우저 정보]</h4>
		<% String browser = request.getHeader("user-Agent"); %>
		<%if(browser.indexOf("MSIE")!=-1){}; %>
		<%if(browser.indexOf("Chrome")!=-1){}; %>
	</body>
</html>