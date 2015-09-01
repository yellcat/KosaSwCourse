<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>JspProgramming</title>
		<link rel="stylesheet" href="format.css">
	</head>
	<body>
		<div id="page-wrapper">
			<header>
				<a href="index.jsp"><h1>JspProgramming</h1></a>
			</header>
			<nav>
				<div class="menu">menu1</div>
				<div class="menu">menu2</div>
				<div class="menu">menu3</div>
				<div class="menu">menu4</div>
				<div class="menu">menu5</div>
			</nav>
			<div id="content">
				<aside>
					<div id = "category">
						<p class="chapter">[Ch04: Servlet]</p>
						<a href="HelloWorldServlet1" target="iframe">3.0 방식으로 등록</a>
						<a href="HelloWorldServlet2" target="iframe">이전 방식으로 등록</a>
						<a href="HelloWorldServlet3" target="iframe">load on startup</a>
						<a href="HelloWorldServlet4" target="iframe">외부 정보 받기</a>
						<a href="chap4/service_get_post.jsp" target="iframe">요청방식별 처리</a>
						<a href="LoginServlet" target="iframe">요청 처리 및 응답 보내기</a>
						
						<p class="chapter">[Ch05: JSP 기초문법]</p>
						<a href="chap5/comment.jsp" target="iframe">주석</a>
						<a href="chap5/directives/index.jsp" target="iframe">지시어</a>
						<a href="chap5/action/index.jsp" target="iframe">표준액션</a>
						<a href="chap5/dec_express/scriptlet1.jsp" target="iframe">스크립트릿1</a>
						<a href="chap5/dec_express/scriptlet2.jsp" target="iframe">스크립트릿2</a>
						<a href="chap5/dec_express/calc3.jsp" target="iframe">선언문</a>
						
						<p class="chapter">[Ch06: JSP 내장객체]</p>
						<a href="chap6/builtin_object.jsp" target="iframe">내장객체의 개요</a>
						<a href="chap6/request/index.jsp" target="iframe">request</a>
						<a href="chap6/response/index.jsp" target="iframe">response</a>
						<a href="chap6/cookie/index.jsp" target="iframe">cookie</a>
						<a href="chap6/session/index.jsp" target="iframe">session</a>
						<a href="chap6/application/index.jsp" target="iframe">application</a>
						
						<p class="chapter">[Ch07: JSP 자바빈즈]</p>
						<a href="chap7/dto.jsp" target="iframe">DTO 이용 방법</a>	
						<a href="chap7/dto_auto_setting.jsp" target="iframe">DTO 값 저장</a>
						<a href="chap7/bean_scope.jsp" target="iframe">빈의 사용 범위</a>
						<a href="chap7/database_form.jsp" target="iframe">데이타베이스 연동</a>
						
						<p class="chapter">[Ch10: 표현 언어]</p>
						
						<p class="chapter">[Ch11: JSTL]</p>
						<a href="chap11/forEach.jsp" target="iframe">&lt;c:forEach&gt;</a>
						
						<p class="chapter">[실습1: 게시판]</p>
						<a href="exam01/list.jsp" target="iframe">게시판 목록</a>
						
						<p class="chapter">[실습2: 상품 게시판]</p>
						<a href="homework/product/list.jsp" target="iframe">상품 목록</a>
						
						<p class="chapter">[실습3: MVC 게시판]</p>
						<a href="mvc/board?action=list" target="iframe">게시판 목록</a>
						
						<p class="chapter">[JSP 과제]</p>
						<a href="homework/cart/login.jsp" target="iframe">장바구니</a>
						<a href="homework/twitter/login.jsp" target="iframe">트위터</a>
					</div>
				</aside>
				<section>
					<iframe name="iframe"></iframe>
				</section>
			</div>
			<footer>Create By egg_kim</footer>
		</div>
	</body>
</html>