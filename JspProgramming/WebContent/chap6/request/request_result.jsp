<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("username");
	String job = request.getParameter("job");
	String[] favorites = request.getParameterValues("favorite");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
	<div align="center">
		<h2>request 테스트 결과-1</h2>
		<hr>
		<table border=1 cellspacing="1" cellpadding="5">
			<tr>
				<td>이름</td>
				<td><%=request.getParameter("username")%></td>
			<tr>
				<td>직업</td>
				<td><%=request.getParameter("job")%></td>
			<tr>
				<td>관심분야</td>
				<td>
					<%for (String favorite : favorites) {%> 
						<%=favorite%> <br> 
					<%	} %>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>