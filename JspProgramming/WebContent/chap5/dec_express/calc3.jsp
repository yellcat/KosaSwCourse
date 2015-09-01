<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%--선언문: jsp가 클래스로 변환될 때 클래스의 필드와 메소드를 선언 --%>
    <%!
    	//필드
    	int num1, num2 = 0;
    	int result =0;
    	String op ="";
    	
    	//메소드
    	public int calculator(){
    		if(op.equals("+")){
    			result = num1 +num2;}
    		else if(op.equals("-")){
    			result = num1 -num2;}
    		else if(op.equals("*")){
    			result = num1 *num2;}
    		else if(op.equals("/")){
    			result = num1 /num2;}
    	return result;
    	}
    %>
    <!-- 스크립트릿(요청시 마다 실행되는 코드) -->
    <%
    //웹 페이지 요청이 POST인 경우에만 수행, 즉 폼을 통해 전달된 것만 수행
    //초기 로딩 시 오류 방지
    if(request.getMethod().equals("POST")){
    	//문자열 형태로 전달된 인자들을 int로 변화함
    	num1 = Integer.parseInt(request.getParameter("num1"));
    	num2 = Integer.parseInt(request.getParameter("num2"));
    	op = request.getParameter("operator");
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>계산기</title>
	</head>
	<body>
		<center>
		<h3>계산기</h3>
			<hr>
			<form name=form1 method=post>
			<input type = "text" name = "num1" width=200 size="5">
			<select name = "operator">
				<option selected>+</option>
				<option>-</option>
				<option>*</option>
				<option>/</option>
			</select>
			<input type = "text" name = "num2" width=200 size="5">
			<input type = "submit" value = "계산" name = "B1" >
			<input type = "reset" value="다시 입력" name = "B2" >
			</form>
			<!-- 하나의 값을 출력하는 부분 -->
			<hr>계산결과: <%=calculator() %>
			</center>
		
	</body>
</html>