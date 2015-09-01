<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	session.setAttribute("username", request.getParameter("username"));
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
</head>
	<body>
	<div align = center>
		<h2>상품선택</h2>
		<%=session.getAttribute("username") %>님이 로그인 한 상태입니다.
		<hr/>
		<form name="form1" method="POST" action="add.jsp">
			<select name = "product">
				<option>사과</option>
				<option>배</option>
				<option>귤</option>
				<option>파인애플</option>
				<option>자몽</option>
				<option>레몬</option>
			</select>
			<input type="submit" value="추가"/>
		</form>
		<a href="checkOut.jsp">계산</a>
	</div>
	</body>
</html>