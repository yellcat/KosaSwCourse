<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h4>GET 방식으로 요청</h4>
		<a href="../ServiceGetPostServlet">링크</a>
		<form method="get" action = "../ServiceGetPostServlet">
			<input type="submit" value="form-get"/>
		</form>
		<h4>POST 방식으로 요청</h4>
		<form method="post" action = "../ServiceGetPostServlet">
			<input type="submit" value="form-post"/>
		</form>
	</body>
</html>