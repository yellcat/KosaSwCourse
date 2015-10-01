<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Insert title here</title>
		<!-- <link rel="stylesheet" href="resources/iframe_style.css"> -->
		<style>
			body{
				text-size:small;
			}
			input{
				font-size = 12px;
			}
			div{
				margin: 10px;
			}
			span{
				display: inline-block;
				margin: 5px;
			}
			.title {
				display: inline-block;
				width: 100px;
				height: 30px;
				text-size: small;
				background-color: rgb(89,94,113);
				color:white;
				text-align: center;
			}
			
		</style>
	</head>
	<body>
		<form method="post" action="write" enctype="multipart/form-data"/>
			<div>
				<span class="title">품명</span>
				<span class="content"><input type="text" name="name"/></span><br/>
				<span class="title">가격</span>
				<span class="content"><input type="number" name="price"/></span><br/>
				<span class="title">상품 이미지</span>
				<span class="content"><input type="file" name="attach"/></span><br/>
			</div>
			<div id="buttonGroup">
				<input type="submit" value="글 올리기"/>
				<input type="reset" value="다시 작성"/>
			</div>			
		</form>
	</body>
</html>