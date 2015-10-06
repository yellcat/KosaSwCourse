<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Apache Tomcat WebSocket Examples: Echo</title>
    <style type="text/css">
    	body {
			font-size: small;
			color:white;
		}
		#connect-container {
            float: left;
            width: 400px
        }

        #connect-container div {
            padding: 5px;
        }

        #console-container {
            float: left;
            margin-left: 15px;
            width: 400px;
        }

        #console {
            border: 1px solid #CCCCCC;
            border-right-color: #999999;
            border-bottom-color: #999999;
            height: 170px;
            overflow-y: scroll;
            padding: 5px;
            width: 100%;
        }

        #console p {
            padding: 0;
            margin: 0;
        }
	</style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js">
	</script>
    <script type="text/javascript">
	    var ws = null;
	    function connect() {
 			ws = new WebSocket("ws://"+window.location.host+"/SpringProgramming/chatcolor-ws");
 			
 			ws.onopen = function(){
 				log("접속O");
 				setConnected(true);
 			};
 			
 			ws.onclose = function(){
 				log("접속X");
 				setConnected(false);
 			};
 			
 			ws.onmessage = function(event){//메세지가 오면 실행
 				var strJson = event.data;
 				var json = JSON.parse(strJson);
 				var command = json.command;

 				if(command == "display"){
					display(data);
 				}
 			}
		}
	    
		function setConnected(connected){
			if(connected){
				$("#connect").attr("disabled",'disabled');
				$("#disconnect").removeAttr("disabled");
				$("#echo").removeAttr("disabled");
			}else{
				$("#connect").removeAttr("disabled");
				$("#disconnect").attr("disabled",'disabled');
				$("#echo").attr("disabled",'disabled');
			}
		}
		
		function echo(){
			var userName=$("#userName").val();
			var fontColor=$("#fontColor").val();
			var message = $("#message").val();
			
			if(userName==""){
				userName=="noName";
			}
			if(message==""){
				alert("no message");
				return;
			}
			var json={
					"command":"broadcast",
					"data":{
						"userName":userName,
						"fontColor":fontColor,
						"message":message
					}
			};
			
			var strJson = JSON.stringify(json);
			ws.send(strJson);
		}
		
		function display(data){
			var fontColor = json.fontColor;
			var data = json.data;
			log(fontColor, data);
		}
		
 			
		function log(color,message){
            $("#console").append("<span style='display:block; color:'"+color+";/>"+message+"</span><br/>");
            if($("#console span").length>20){
               $("#console span").first().remove();
            }
            $("#console").scrollTop($("#console").height());
        }
		
		function send(){
			
		}
 
	    function disconnect(){
			if(ws!=null){
				ws.close();
				ws=null;
			}
		}
	</script>
</head>
<body>
    <div id="connect-container">
        <div>
            <button id="connect" onclick="connect();">Connect</button>
            <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
        </div>
        <div>
        	userName: <input type="text" id="userName"/>
        	<input type="color" id="fontColor"/>
        </div>
        <div>
            <textarea id="message" style="width: 350px">Here is a message!</textarea>
        </div>
        <div>
            <button id="echo" onclick="echo();" disabled="disabled">Chat message</button>
        </div>
    </div>
    <div id="console-container">
        <div id="console"/>
    </div>
</body>
</html>