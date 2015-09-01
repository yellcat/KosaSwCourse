<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
				<c:forEach var="board" items="${list}">
					<tr>
						<td>${board.no}</td>
						<td><a href="detail.jsp?board_no=${board.no}">${board.title}
							</a></td>
						<%-- <td>${board.title}</td> --%>
						<td>${board.writer}</td>
						<td>${board.date}</td>
						<td>${board.hitcount}</td>
					</tr>	
				</c:forEach>	
			</table>

			<div id="buttonGroup">
				<a href="../mvc/board?action=writeForm">
				<img src="../common/images/board/write.gif"/></a>
			</div>
	</body>
</html>