<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import = "dto.*" %>
<%
int boardNo = Integer.parseInt(request.getParameter("board_no"));
%>
<jsp:useBean 
	id="boardService"
	class="service.BoardService"
	scope="application"
/>

<%Board board = boardService.getBoard(boardNo); %>
	
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
		<style>
			span{
				display: inline-block;
				margin:10px;
			}
			span.title{
				border:1px solid darkgray;
				background:lightgray;
				width:70px;
				text-align: center;
			}
			pre{
				margin:10px;
				border: 1px solid darkgray;
				padding: 10px;
				width: 500px;
				height: 100px;
				font-size: 12px;
			}
		</style>
		
		<script type="text/javascript">
			function sendData(){
				//값의 유효성 검사 
				/*var modifyForm = document.querySelector("#moidfyForm"); */
				var modifyForm = document.modifyForm;
				console.log(modifyForm);
				
				/* var title = document.querySelector("#title"); */
				var no = document.modifyForm.no;
				console.log(no);
				var title = document.modifyForm.title;
				console.log(title);
				var content = document.modifyForm.content;
				console.log(content);
				
				if(title.value == "" || content.value == ""){
					alert("제목과 내용은 있어야 합니다.");
					return;
				}
				//서버로 전송
				modifyForm.submit();
			}
		</script>
	</head>
	<body>
		<h4>게시물 보기</h4>
		<form id="modifyForm" name="modifyForm" method="post" action="modify.jsp">
			<span class="title">번호: </span>
			<span class="content"><%=board.getNo() %></span><br/>
			<input type="hidden" name="no" value="<%=board.getNo()%>"/>
			
			<span class="title">제목: </span>
			<input type="text" name="title" value="<%=board.getTitle()%>"/><br/>
			
			<span class="title">글쓴이: </span>
			<span class="content"><%=board.getWriter() %></span><br/>
			
			<span class="title">날짜: </span>
			<span class="content"><%=board.getDate() %></span><br/>
			
			<span class="title">조회수: </span>
			<span class="content"><%=board.getHitcount() %></span><br/>
			
			<span class="title">내용:</span><br/>
			<textarea name="content" cols = "30" rows="5"><%=board.getContent() %></textarea>
		</form>
		<div id="buttonGroup">
			<a href="javascript:sendData()">[수정]</a>
			<a href="detail.jsp?board_no=<%=board.getNo()%>">[취소]</a>
		</div>
	</body>
</html>