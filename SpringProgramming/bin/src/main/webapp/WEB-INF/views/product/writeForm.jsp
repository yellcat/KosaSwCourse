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
				background-color: white;
			}

			td{
				text-align: center;
			}
			td.title {
				width: 100px;
				text-size: small;
				background-color: rgb(89,94,113);
				color:white;
			}
			
		</style>
	</head>
	<body>
		<form method="post" action="write">
			<table id="formtable">
				<tr>
					<td class="title">품명</td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td class="title">가격</td>
					<td><input type="number" name="price"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<br/>
						<input type="submit" value="글 올리기"/>
						<input type="reset" value="다시 작성"/>
					</td>
				</tr>
			</table>
			
		</form>
	</body>
</html>