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
		</style>
	</head>
	<body>
		<form method="post" action="write" enctype="multipart/form-data"/>
			<table id="formtable">
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"/></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content" rows="5" cols="50"></textarea></td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td><input type="file" name="attach"/></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
					<br/>
						<input type="submit" value="글 올리기">
						<input type="reset" value="다시 작성">
					</td>
				</tr>
			</table>
			
		</form>
	</body>
</html>