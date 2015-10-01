<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				display:block;
				padding:10px;
			}
			#part2{
				margin:20px;
			}
			#buttonGroup{
				text-align : center;
			}
			
		</style>
	</head>
	
	<body>		
		<h4>게시물 보기</h4>
		<div id="part1">
			<div id="part1_1">
				<span class="title">번호: </span>
				<span class="content">${board.no}</span><br/>
				<span class="title">제목: </span>
				<span class="content">${board.title}</span><br/>
				<span class="title">글쓴이: </span>
				<span class="content">${board.writer}</span><br/>
				<span class="title">날짜: </span>
				<span class="content">${board.date}</span><br/>
				<span class="title">조회수: </span><span class="content">${board.hitcount}</span><br/>
				<!-- <span class="title">첨부파일: </span>
				<span class="content"><a target="_blank" href="../uploadfiles/$(board.getFilesystemName())")/>
				$(board.getOriginalFileName() )</a></span><br/> -->
			</div>
		</div>
		<div id="part2">
			<span class="title">내용:</span><br/>
			<span class="content"><pre>${board.content}</pre></span><br/>
		</div>
		<div id="buttonGroup">
			<a href="writeForm">글쓰기</a>
		</div>
	</body>
</html>