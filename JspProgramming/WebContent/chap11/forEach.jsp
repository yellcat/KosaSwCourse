<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h4>forEach.jsp</h4>
		<hr/>
		
		<c:forEach var="i" begin="1" end="5">
			${i} <br/>
		</c:forEach>
		
		<hr/>
		
		<c:forEach var="i" begin="1" end="5" step="2">
			${i} <br/>
		</c:forEach>
		
		<hr/>
		<%
		List<String> names = new ArrayList<String>();
		names.add("hong gil dong");
		names.add("ahn se un");
		names.add("seo ga ram");
		request.setAttribute("names", names);
		%>
		<c:forEach var="i" items="${ names }" varStatus="status">
			status.fist: ${status.first },
			status.last: ${status.last },
			status.index: ${status.index},
			status.count: ${status.count},
			i:${i}<br/>
		</c:forEach>
		
		<hr/>
		
		<c:forEach var="name" items="${ names }" varStatus="status">
			<c:if test="${status.first }">
				<table>
					<tr>
						<th> 이름 </th>
					</tr>
			</c:if>
			
			<tr>
				<td>${name}</td>
			</tr>
			
			<c:if test="${status.last}">
				</table>
			</c:if>
		</c:forEach>
		
	</body>
</html>