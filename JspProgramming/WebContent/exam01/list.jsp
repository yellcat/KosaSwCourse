<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import = "dto.*" %>
<%@ page import = "java.util.*" %>

<jsp:useBean 
	id="boardService"
	class = "service.BoardService"
	scope="application"/>
<%
int pageNo=1;
String strPageNo = request.getParameter("pageNo");
if(strPageNo != null){
	pageNo = Integer.parseInt(strPageNo);
}
%>
<%
List <Board> list = boardService.getPage(pageNo,boardService.getRowsPerPage());
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table {
				border-collapse:collapse;
				width:100%;
				text-align: center;
			}
			table, th, td {
				border: 1px solid black;
			}
			th{
				background-color:white;
			}
			
			#buttonGroup{
				margin:10px;
				text-align:center;
			}
			#pager{
				font-size:small;
				text-align:center;
				margin: 10px;
			}
			#sel{
				color:red;
				font-weight : bold;
			}
		</style>
	</head>
	<body>
		<h4>게시물 목록</h4>
		<table>
			<tr>
				<th style="width:50px">번호</th>
				<th>제목</th>
				<th style="width:70px">글쓴이</th>
				<th style="width:100px">날짜</th>
				<th style="width:50px">조회수</th>
			</tr>
			
				<%for(Board board: list){%>
				<tr>
					<td><%=board.getNo()%></td>
					<td><a href="detail.jsp?board_no=<%=board.getNo()%>">
						<%=(board.getTitle().length()>20)?board.getTitle().substring(0,20)+"...":board.getTitle() %></a></td>
					<td><%=(board.getWriter().length()>3)?board.getWriter().substring(0,3)+"...":board.getWriter()%></td>
					<td><%=board.getDate() %></td>
					<td><%=board.getHitcount() %></td>
				</tr>	
				<%} %>
			</table>
			<div id="pager">
				<a href="list.jsp?pageNo=1">[처음]</a>
				<%int groupNo = boardService.getGroupNo(pageNo); %>
				<%if(groupNo!=1){ %>
					<a href="list.jsp?pageNo=<%=boardService.startPageNo(groupNo-1)%>">[이전]</a>
				<%} %>
				
				<%for(int i=boardService.startPageNo(groupNo); 
						i<=boardService.endPageNo(groupNo); 
						i++) {%>
						<a <%=(pageNo==i)?"id=sel":"" %> 
						href="list.jsp?pageNo=<%=i%>"><%=i %></a> &nbsp; &nbsp;
				<%} %>
				
				<%if(boardService.isEndGroupNo(groupNo)){ %>
					<a class="pageNo" href="list.jsp?pageNo=<%=boardService.startPageNo(groupNo+1)%>">[다음]</a>
				<%} %>
				
				<a href="list.jsp?pageNo=<%=boardService.getEndGroupStartNo(groupNo)%>">[맨끝]</a></div>
			<div id="buttonGroup">
				<a href="write_form.jsp">
				<img src="../common/images/board/write.gif"/></a>
			</div>
	</body>
</html>