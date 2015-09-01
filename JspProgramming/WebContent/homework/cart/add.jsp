<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import = "java.util.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String productname = request.getParameter("product");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%	ArrayList list = (ArrayList) session.getAttribute("productlist");
		if (list == null) {
			list = new ArrayList();
			session.setAttribute("productlist", list);
		}
		list.add(productname);
	%>
	<script type="text/javascript">
	alert("<%=productname%>이(가) 추가되었습니다!");
		history.go(-1);
	</script>
</body>
</html>