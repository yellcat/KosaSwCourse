<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%--����: jsp�� Ŭ������ ��ȯ�� �� Ŭ������ �ʵ�� �޼ҵ带 ���� --%>
    <%!
    	//�ʵ�
    	int num1, num2 = 0;
    	int result =0;
    	String op ="";
    	
    	//�޼ҵ�
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
    <!-- ��ũ��Ʈ��(��û�� ���� ����Ǵ� �ڵ�) -->
    <%
    //�� ������ ��û�� POST�� ��쿡�� ����, �� ���� ���� ���޵� �͸� ����
    //�ʱ� �ε� �� ���� ����
    if(request.getMethod().equals("POST")){
    	//���ڿ� ���·� ���޵� ���ڵ��� int�� ��ȭ��
    	num1 = Integer.parseInt(request.getParameter("num1"));
    	num2 = Integer.parseInt(request.getParameter("num2"));
    	op = request.getParameter("operator");
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>����</title>
	</head>
	<body>
		<center>
		<h3>����</h3>
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
			<input type = "submit" value = "���" name = "B1" >
			<input type = "reset" value="�ٽ� �Է�" name = "B2" >
			</form>
			<!-- �ϳ��� ���� ����ϴ� �κ� -->
			<hr>�����: <%=calculator() %>
			</center>
		
	</body>
</html>