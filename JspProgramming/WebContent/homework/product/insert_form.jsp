<%@ page contentType="text/html; charset=UTF-8"%>
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
		<h4>상품 입력</h4>
		<form method="post" action="insert.jsp">
			<span class="title">품명: </span>
			<span class="content"><input type="text" name="name"/></span><br/>
			
			<span class="title">가격: </span>
			<span class="content"><input type="text" name="price"/></span><br/>
			
			<div>
				<input type="submit" value="제품 저장">
				<input type="reset" value="다시 하기">
			</div>
		</form>
	</body>
</html>