<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import = "dto.*"%>

<%
int productNo = Integer.parseInt(request.getParameter("product_no"));
%>

<jsp:useBean 
	id="productService"
	class="service.ProductService"
	scope="application">
</jsp:useBean>

<%
Product product = productService.getProduct(productNo);
%>
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
		<h4>상품 수정</h4>
		<form method="post" action="update.jsp">
			<span class="title">품번: </span>
			<span class="content"><%=product.getNo() %></span>
			<input type="hidden" name="no" value ="<%=product.getNo()%>"/><br/>
		
			<span class="title">품명: </span>
			<span class="content"><input type="text" name="name" value ="<%=product.getName()%>"/></span><br/>
			
			<span class="title">가격: </span>
			<span class="content"><input type="number" name="price" value ="<%=product.getPrice()%>"/></span><br/>
			
			<input type="submit" value="제품 수정">
			<input type="reset" value="다시 하기">
		</form>
	</body>
</html>