<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.sql.*"%>
<%@ page import = "java.util.*" %>
<!-- 기본적으로 import 되는 패키지
1) javax.servlet
2) javax.servlet.http
3) javax.servlet.jsp-->

<%
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection(
		"jdbc:mysql://blueskii.iptime.org:3306", "team5", "123456");
Calendar now = Calendar.getInstance();
int year = now.get(Calendar.YEAR);
int month = now.get(Calendar.MONTH)+1;
int day = now.get(Calendar.DAY_OF_MONTH);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		연결성공<br/>
		<%=year %>년 <%=month %>월 <%=day %>일
	</body>
</html>