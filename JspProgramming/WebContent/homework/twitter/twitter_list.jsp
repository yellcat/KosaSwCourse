<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import = "java.util.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("username");

	if (username != null) {
		session.setAttribute("user", username);
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div align=center>
		<h3>My Simple Twitter</h3>
		<hr />
		<form action="tweet.jsp" method="post">
			@<%=session.getAttribute("user")%>
			<input type="text" name="msg" /> <input type="submit" name="tweet" />
		</form>
		<hr />
		<div align="left">
			<ul>
				<%
					ArrayList<String> msgs = (ArrayList<String>) application.getAttribute("msgs");
					if (msgs != null) {
						for (String msg : msgs) {%>
							<li><%=msg%></li>
						<%}
					}%>
			</ul>
		</div>
	</div>
		</body>
</html>