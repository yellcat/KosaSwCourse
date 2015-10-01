<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
		<style>
		*{
			color:white;
		}
			span{
				display: inline-block;
				margin:10px;
			}
			span.title{
				border:1px solid darkgray;
				background:rgb(89,94,113);
				width:70px;
				
				text-align: center;
			}
			#part1{
				display: flex;
				margin:20px;
				/* width:550px;  */
			}
			#part1_1{
				flex:1;
			}
			#part1_2{
				width:120px;
				text-align:center;
				margin-right:10px;
			}
			#part1_2 img{
				width:100%;
				display:block;
				padding:10px;
			}
			#part1_2 button{
				background-color:rgb(89,94,113);
			}
			#part2{
				margin:20px;
			}
			#buttonGroup {
				margin: 10px;
				text-align: center;
			}
			
			#buttonGroup a {
				display:inline-block;
				width: 70px;
				line-height: 30px;
				text-decoration: none;
				font-size: small;
				color: white;
				border: 1px solid darkgray;
				background-color: rgb(89,94,113);
				font-weight: bold;
			}
			
			#buttonGroup a:hover {
				color: black;
				background-color: lightgray;
			}
			
		</style>
	</head>
	
	<body>		
		<h4>게시물 보기</h4>
		<div id="part1">
			<div id="part1_1">
				<span class="title">품번: </span>
				<span class="content">${product.no}</span><br/>
				<span class="title">품명: </span>
				<span class="content">${product.name}</span><br/>
				<span class="title">가격: </span>
				<span class="content">${product.price}</span><br/>
				
				<span class="title">첨부파일: </span>
				<span class="content">${product.originalFilename}</span><br/>
			</div>
			<div id="part1_2">
				<img alt="No image" src="${pageContext.request.contextPath}/resources/uploadfiles/${product.filesystemName}"/>
				<button>다운로드</button>
			</div>
		</div>
		<div id="buttonGroup">
			<a href="#">수정하기</a>
		</div>
	</body>
</html>