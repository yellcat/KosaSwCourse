<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<div align=center>
		<h2>계산</h2>
		선택한 상품 목록
		<hr />
		<%
			ArrayList list = (ArrayList) session.getAttribute("productlist");
			if (list == null) {
		%>
		선택한 상품이 없습니다
		<%
			} else {
				for (Object productname : list) {
		%>
		<%=productname%><br />
		<%
			}
			}
			session.removeAttribute("productlist");
		%>
	</div>
</body>
</html>