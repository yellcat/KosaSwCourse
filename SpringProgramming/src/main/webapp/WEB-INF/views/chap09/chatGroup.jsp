<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Home</title>
		<style type="text/css">
			/*------------------------------------*/
			* { 
				margin: 0px; 
				padding: 0px; 
			}
			body { 
				width: 100%; 
				background-color: #292929; 
				color: #FFFFFF; 
				font-size: small;
			}
			button {
				padding: 3px;
			}
			/*------------------------------------*/				
			#page { 
				height: 100vh; 
				display: flex; 
				flex-direction: column; 
			}
			/*------------------------------------*/			
			#header { 
				margin: 20px 0px; 
				font-style: italic; 
			}
			#content {
				flex: 1;
				padding: 5px;
				border: 3px solid #464646;	
				border-radius: 10px;
				display: flex;
			}
			/*------------------------------------*/	
			#centerBox {
				flex:1;
				display: flex;
				flex-direction: column;
			}
			#asideBox {
				width: 150px;
				margin-left: 10px;
				padding: 10px;
				border: 2px solid #464646;	
				border-radius: 10px;
				display: flex;
				flex-direction: column;
			}	
			/*------------------------------------*/						
			#centerBox>*{ 
				margin-top: 10px; 
			}
			#connectionBox button {
				width: 100px;
			}
			#userBox { 
				display:flex; 
			}
			#userName { 
				flex: 1
			}			
			#groupBox { 
				display: flex; 
			}
			#groupName { 
				flex:1; 
			}
			#newGroupName { 
				flex:1; 
			}
			#console {
				flex:1;
	            border: 2px solid #464646;	
	            border-radius: 10px 0px 0px 10px;
	            overflow-y: scroll;
	            padding: 5px;
			}
			#sendBox { 
				display: flex; 
			}
			#message { 
				flex:1; 
			}
			/*------------------------------------*/	
			#asideBox ul {
				margin: 10px;
				padding: 5px;
				border: 2px solid #464646;	
	            border-radius: 10px 0px 0px 10px;
	            flex:1px;
			}
			#asideBox li { list-style-type: none; }
			/*------------------------------------*/
		</style>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript">
			//전역 변수 선언
			var ws = null;

			//연결 하기
			function connect() {
				ws = new WebSocket("ws://" + window.location.host + "/SpringProgramming/chatgroup-ws");
				ws.onopen = function () {
				    log("[info] WebSocket 연결 됨");					
					setConnected(true);
				};
				ws.onmessage = function (event) {
				    log('[info] 받은 메시지 :' + event.data);
				    handleTextMessage(event.data);
				};
				ws.onclose = function (event) {
				    log('[info] WebSocket 연결 닫힘');
				    setConnected(false);
				};
			}
            
            //연결 닫기
            function disconnect() {
                if (ws != null) {
                    ws.close();
                    ws = null;
                }
                setConnected(false);
            }
            
            //요소 활성화 정리
            function setConnected(connected) {  
            	if(connected) {
            		$("#btnConnect").attr("disabled","disabled");
					$("#btnDisConnect").removeAttr("disabled");
                    
                    $("#userName").removeAttr("disabled"); 
                    $("#btnAddUser").removeAttr("disabled");
                    
                    $("#groupName").removeAttr("disabled");
                    $("#btnChangeGroup").removeAttr("disabled");
                    $("#newGroupName").removeAttr("disabled");                   
                    $("#btnAddGroup").removeAttr("disabled");
                    
                    $("#message").removeAttr("disabled");
                    $("#btnSend").removeAttr("disabled");
            	} else {
                    $("#groupList li").remove();
                    $("#userList li").remove();
                    
                    $("#userName").val("");
                    $("#groupName").val("기본그룹");
                    
                    $("#btnConnect").removeAttr("disabled");
                    $("#btnDisConnect").attr("disabled","disabled");
                    
                    $("#userName").attr("disabled","disabled");  
                    $("#btnAddUser").attr("disabled","disabled");
                    
                    $("#groupName").attr("disabled","disabled");
                    $("#btnChangeGroup").attr("disabled","disabled");
                    $("#newGroupName").attr("disabled","disabled");                    
                    $("#btnAddGroup").attr("disabled","disabled");
                    
                    $("#message").attr("disabled","disabled");
                    $("#btnSend").attr("disabled","disabled");
            	}
            }
            
            //텍스트 메시지 처리
            function handleTextMessage(strJson) {
			    var json = JSON.parse(strJson);
			    var command = json.command;
			    var data = json.data;
			    if(command=="refreshGroupUserList") { 
			    	refreshGroupUserList(data); 
			    } else if(command=="appendChatText") {
			    	log(data.chatText);
			    }
            }
            
            //사용자 등록
            function addUser() {
				var userName = $("#userName").val();
				if(userName == "") {
					alert("사용자 이름을 입력하세요");
					return;
				}
				ws.send(JSON.stringify({
                	command: "addUser",
                	data: {
                		"groupName": "기본그룹",
                		"userName": userName
                	}
                }));
            }
            
            //그룹 등록
            function addGroup() {
            	var newGroupName = $("#newGroupName").val();
            	if(newGroupName == "") {
            		alert("새 그룹 이름을 입력하세요");
					return;
            	}
            	ws.send(JSON.stringify({
                	command: "addGroup",
                	data: {
                		"groupName": newGroupName
                	}
                }));
            	$("#newGroupName").val("");
            }
            
            //그룹 등록
            function changeGroup() {
            	var userName = $("#userName").val();
            	if(userName=="") { 
            		alert("사용자 이름을 입력하세요."); 
            		return;
            	}
            	var groupName = $("#groupName").val();
            	if(groupName=="") { 
            		alert("그룹 이름을 입력하세요."); 
            		return;
            	}
            	ws.send(JSON.stringify({
                	command: "changeGroup",
                	data: {
                		"groupName": groupName,
                		"userName": userName
                	}
                }));
            }            
            
            //그룹에 속하는 회원 이름 나타내기
            function refreshGroupUserList(data) {
            	$("#groupList li").remove();
            	$("#userList li").remove();
            	for(var i=0; i<data.length; i++) {
            		var group = data[i];
            		$("#groupList").append("<li>" + group.groupName + "</li>");
            		if(group.groupName == $("#groupName").val()) {
    	            	for(var j=0; j<group.userNames.length; j++) {
    	            		$("#userList").append("<li>" + group.userNames[j] + "</li>");
    	            	}
            		}
            	}
            }
			
			function sendMessage() {
				var groupName = $("#groupName").val();
				if(groupName == "") {
					alert("그룹 이름을 입력하세요");
					return;
				}
				
				var userName = $("#userName").val();
				if(userName == "") {
					alert("사용자 이름을 입력하세요");
					return;
				}
				
				var message = $("#message").val();	
				if(message == "") {
					alert("메시지를 입력하세요");
					return;
				}
				
                var jsonMessage = {
                	command: "broadcast",
                	data: {
	                	"groupName": groupName, 
	                	"chatText": "[" + userName + "] " + message
                	}
                };
                ws.send(JSON.stringify(jsonMessage));
                $("#message").val("");
	        }			
			
			function log(message) {
				//if(message.indexOf("[info]") != -1) return;
				var console = document.getElementById('console');
				var p = document.createElement('p');
				p.style.wordWrap = 'break-word';
				p.appendChild(document.createTextNode(message));
				console.appendChild(p);
				while (console.childNodes.length > 25) {
				    console.removeChild(console.firstChild);
				}
				console.scrollTop = console.scrollHeight;
			 }
		</script>
	</head>
	
	<body>
		<div id="page">
			<div id="header">
				<h3>WebSocket</h3>
			</div>
			
			<div id="content">
				<div id="centerBox">
					<div id="connectionBox">
						<button id="btnConnect" onclick="connect()">연결하기</button>
						<button id="btnDisConnect" onclick="disconnect()" disabled>연결끊기</button>
					</div>
					<div id="userBox">
						<label>사용자</label>
						<input id="userName" type="text" placeholder="사용자 이름 입력" disabled/>
						<button id="btnAddUser" onclick="addUser()" disabled>등록</button>
					</div>				
					<div id="groupBox">
						<label>그룹명</label>
						<input id="groupName" type="text" value="기본그룹" disabled/>
						<button id="btnChangeGroup" onclick="changeGroup()" disabled>변경</button>
						<label>새그룹</label>
						<input id="newGroupName" type="text" placeholder="새 그룹 이름 입력" disabled/>
						<button id="btnAddGroup" onclick="addGroup()" disabled>등록</button>
					</div>
					<div id="console"></div>
					<div id="sendBox">
						<input id="message" type="text" disabled/>
						<button id="btnSend" onclick="sendMessage()" disabled>보내기</button>
					</div>
				</div>			
				<div id="asideBox">
					<h4>그룹 목록</h4>
					<ul id="groupList">
					</ul>
					<h4>그룹 사용자</h4>
					<ul id="userList">
					</ul>
				</div>
			</div>
		</div>
	</body>
</html>