<%@ page contentType="text/html; charset=UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
%>
<nav class="menu">
		<div class="menuitem <%=(no==1)? "selected":"" %>">menu1</div>
		<div class="menuitem <%=(no==2)? "selected":"" %>">menu2</div>
		<div class="menuitem <%=(no==3)? "selected":"" %>">menu3</div>

	
</nav>