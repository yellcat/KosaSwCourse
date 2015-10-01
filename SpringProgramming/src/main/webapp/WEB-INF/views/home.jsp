<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Home</title>
		<link rel="stylesheet" href="resources/css/form.css"/>
	</head>
	
	<body>
	<div id="pagewrapper">
		<div id="page">
			<div id="header">
				<a href=""><h1>Spring Programming</h1></a>
			</div>
			
			<div id="content1">
				<div id="login"></div>
				<div id="frontImage">
					<img src="resources/image/header.jpg"/>
				</div>
			</div>
			
			<div id="content2">
				<div id="menu">
					<ul>
						<h4>스프링 기본</h4>
						<li><a href="chap07/index" target="iframe">Chap07: 스프링 MVC</a></li>
						<li><a href="chap08/index" target="iframe">Chap08: 스프링 MVC: 뷰구현</a></li>
						<li><a href="chap11/index" target="iframe">Chap11: JDBC 지원</a></li>
						<li><a href="chap12/index" target="iframe">Chap12: 트랜잭션 관리</a></li>
						<li><a href="#">Chap18: 스프링 단위 테스트</a></li>
					</ul>
					
					<ul>
						<h4>스프링 게시판</h4>
						<li><a href="board/list" target="iframe">일반 게시판</a></li>
						<li><a href="photo/list" target="iframe">사진 게시판</a></li>
						<li><a href="file/list" target="iframe">자료 게시판</a></li>
						<li><a href="product/list" target="iframe">상품 게시판</a></li>
					</ul>
				</div>
				<div id="content">
					<iframe name="iframe" height="100%" width="100%"></iframe>
				</div>
			</div>
			
			<div id="footer">
				<h5>Created by Egg_Kim</h5>
			</div>
		</div>
		</div>
	</body>
	
</html>
