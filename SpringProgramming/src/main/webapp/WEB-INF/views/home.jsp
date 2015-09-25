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
						<li><h4>Chap07</h4></li>
						<li><a href="chap07/commandObject" target="iframe">커맨드 객체 사용</a></li>
					</ul>
					
					<ul>
						<li><h4>스프링 게시판</h4></li>
						<li><a href="board/list" target="iframe">일반 게시판</a></li>
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
