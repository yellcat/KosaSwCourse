<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%
List<String>titles=new ArrayList<String>();
List<String>images=new ArrayList<String>();
for(int i=1; i<=10;i++){
	titles.add("title"+i);
	images.add("miniroombg"+i+".gif");
}

int adNo = new Random().nextInt(10);
%>

<div style="width:100%; height:100%">
	<span style="display: block; height:30px"><%= titles.get(adNo) %></span>
	<img width="100%" height="110px" src="common/images/miniroombg/<%= images.get(adNo) %>"/>
</div>