<%@ page contentType="text/html; charset=UTF-8"%>
	
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
				var updateForm = document.updateForm;
				console.log(updateForm);
				
				/* var title = document.querySelector("#title"); */
				var no = document.updateForm.no;
				console.log(no);
				var title = document.updateForm.title;
				console.log(title);
				var content = document.updateForm.content;
				console.log(content);
				
				if(title.value == "" || content.value == ""){
					alert("제목과 내용은 있어야 합니다.");
					return;
				}
				//서버로 전송
				updateForm.submit();
			}
		</script>
		
	</head>
	<body>
		<h4>게시물 보기</h4>
		<form id="updateForm" name="updateForm" method="post" action="update">
			<span class="title">번호: </span>
			<span class="content">${board.no}</span><br/>
			<input type="hidden" name="no" value="${board.no}"/>
			
			<span class="title">제목: </span>
			<input type="text" name="title" value="${board.title}"/><br/>
			
			<span class="title">글쓴이: </span>
			<span class="content">${board.writer}</span><br/>
			
			<span class="title">날짜: </span>
			<span class="content">${board.date}</span><br/>
			
			<span class="title">조회수: </span>
			<span class="content">${board.hitcount}</span><br/>
			
			<span class="title">내용:</span><br/>
			<textarea name="content" cols = "30" rows="5">${board.content}</textarea>
		</form>
		<div id="buttonGroup">
			<a href="javascript:sendData()">[수정]</a>
			<a href="detail?boardNo=${board.no}">[취소]</a>
		</div>
	</body>
</html>