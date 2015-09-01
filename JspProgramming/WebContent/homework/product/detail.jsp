<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import = "dto.*" %>
<%
int productNo = Integer.parseInt(request.getParameter("product_no"));
%>
<jsp:useBean 
	id="productService"
	class="service.ProductService"
	scope="application"
/>
<%Product product = productService.getProduct(productNo); %>
	
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
				background:pink;
				width:70px;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<h4>상품 상세 정보 보기</h4>
		<span class="title">품번: </span>
		<span class="content"><%=product.getNo() %></span><br/>
		<span class="title">품명: </span>
		<span class="content"><%=product.getName() %></span><br/>
		<span class="title">가격: </span>
		<span class="content"><%=product.getPrice() %></span><br/>
		
		<div id="buttonGroup">
			<a href="list.jsp">
			<img src="../../common/images/board/list.gif"/>
			</a>
			<a href="update_form.jsp?product_no=<%=product.getNo()%>">
			<img src="../../common/images/board/modify.gif"/>
			</a>
			<a href="delete.jsp?product_no=<%=product.getNo()%>">
			<img src="../../common/images/board/delete.gif"/>
			</a>
		</div>
	</body>
</html>