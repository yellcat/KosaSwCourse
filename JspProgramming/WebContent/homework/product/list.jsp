<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import = "dto.*, java.util.*" %>

<jsp:useBean 
	id="productService"
	class="service.ProductService"
	scope="application">
</jsp:useBean>
<%
List<Product> list = productService.getPage(1, 10);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
		<style>
			table{
				border: 1px solid black;
				width : 100%;
				text-align:center;
			}
			th{
				background-color:white;
			}
			td{
				background-color:pink;
			}
			#buttonGroup{
				margin:10px;
				text-align:center;
			}

		</style>
	</head>
	<body>
		<h4>상품목록</h4>
		<table>
			<tr>
				<th>상품번호</th>
				<th>제품명</th>
				<th>제품 가격</th>
			</tr>
			
				<%for(Product product: list){%>
				<tr>
					<td><%=product.getNo()%></td>
					<td><a href="detail.jsp?product_no=<%=product.getNo()%>"><%=product.getName()%></a></td>
					<td><%=product.getPrice() %></td>
				</tr>	
				<%} %>
			</table>
			<div id="buttonGroup">
				<a href="insert_form.jsp">
				<img src="../../common/images/board/write.gif"/></a>
			</div>
	</body>
</html>