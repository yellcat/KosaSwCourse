<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body {
				font-size: small;
				color:white;
			}
		</style>
	</head>
	
	<body>
		<h4>회원가입</h4>
		<hr/>
		<form:form commandName="member">
			memberId:
			<form:input path="memberId" size="20"/>
			<form:errors path="memberId"/> <br/>
			memberName:
			<form:input path="memberName" size="20"/>
			<form:errors path="memberName"/> <br/>
			memberPassword:
			<form:password path="memberPw" size="20"/>
			<form:errors path="memberPw"/> <br/>
			memberBirthday:
			<input type="date" name="memberBirth"/>
			<form:errors path="memberBirth"/> <br/>
			<input type="submit" value="회원가입"/>
		</form:form>
	</body>
</html>