<%@ page contentType="text/html; charset=UTF-8"%>
<%
String username = request.getParameter("username");
String tel = "000-0000-0000";
%>
<%
response.sendRedirect("page_control_end.jsp?username="+username+"&tel="+tel);
%>