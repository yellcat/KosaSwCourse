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
		`	<span class="title">품번: </span>
			<span class="content">${product.no}</span><br/>
			<input type="hidden" name="no" value="${product.no}"/>
			
			<span class="title">품명: </span>
			<span class="content">${product.name}</span><br/>
			<input type="text" name="name" value="${product.name}"/><br/>
			
			<span class="title">가격: </span>
			<span class="content">${product.price}</span><br/>
			<input type="number" name="price" value="${product.price}"/><br/>
			
		</form>
		<div id="buttonGroup">
			<a href="javascript:sendData()">[수정]</a>
			<a href="detail?productNo=${product.no}">[취소]</a>
		</div>
	</body>
</html>