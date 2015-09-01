<%@ page contentType="text/html; charset=UTF-8"%>
<%
int proudctNo = Integer.parseInt(request.getParameter("product_no"));
%>
<jsp:useBean id="product" class="dto.Product">
	<jsp:setProperty name="product" property="*"/>
</jsp:useBean>

<jsp:useBean 
	id="productService" 
	class="service.ProductService"
	scope="application"/>

<%productService.delete(proudctNo);%>

<%response.sendRedirect("list.jsp");%>