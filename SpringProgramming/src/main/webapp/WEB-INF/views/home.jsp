<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Home</title>
		<link rel="stylesheet" href="resources/form.css"/>
	</head>
	
	<body>
	<div id="pagewrapper">
		<div id="page">
			<div id="header">
				<h1>Spring Programming</h1>
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
						<h4>Chap07</h4>
						<li><a href="#">1절. XXXXXX</a></li>
						<li><a href="#">2절. XXXXXX</a></li>
						<li><a href="#">3절. XXXXXX</a></li>
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
