<%@ page contentType="text/html; charset=UTF-8"%>

<%-- 클라이언트가 보낸 데이터를 Board 객체에 저장 --%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="board" class="dto.Board">
	<jsp:setProperty name="board" property="*"/>
</jsp:useBean>

<!-- applicaiton 범위의 BoardService 객체 사용 -->
<jsp:useBean 
	id="boardService" 
	class="service.BoardService"
	scope="application"/>

<%-- BoardService의 add() 메소드를 호출 --%>	
<%boardService.add(board);%>

<%response.sendRedirect("list.jsp");%>