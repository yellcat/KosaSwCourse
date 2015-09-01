<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	String sex = request.getParameter("sex");
	String password = request.getParameter("password");
	String secret = request.getParameter("secret");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>게시물 보기</title>
	</head>
	<body>
		<div align="center">
			<h2>게시물 보기</h2>
			<hr>
			<table border=1>
				<tr>
					<td>게시글 제목	</td>
					<td><%=title %></td>
				<tr>
					<td>작성자</td>
					<td><%=writer %></td>
				</tr>
				<tr>
					<td>내용</td>
					<td width = "500"><%=content %></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><%=sex %></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><%=password %></td>
				</tr>
				<tr>
					<td>공개여부</td>
					<td><%=secret %></td>
				</tr>
			</table>
		</div>
		
	</body>
</html>