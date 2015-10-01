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
				width: 550px;
				height: 100px;
				font-size: 12px;
				overflow: scroll;
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
				<span class="title">첨부파일: </span>
				<span class="content">${board.originalFileName}</span><br/>
			</div>
			
			<div id="part1_2">
				<img src="${pageContext.request.contextPath}/resources/uploadfiles/${board.filesystemName}"/>
				<button>다운로드</button>
			</div>
		</div>
		<div id="part2">
			<span class="title">내용:</span><br/>
			<span class="content"><pre>${board.content}</pre></span><br/>
		</div>
		<div id="buttonGroup">
			<a href="list?pageNo=${pageNo}">목록</a>
			<a href="updateForm?boardNo=${board.no}">수정</a>
			<a href="delete?boardNo=${board.no}">삭제</a>
		</div>
	</body>
</html>