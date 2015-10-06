package com.mycompany.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class Chap09ChatColorHandler extends TextWebSocketHandler{
	private static final Logger logger = LoggerFactory.getLogger(Chap09ChatColorHandler.class);
	private List<WebSocketSession> list = new ArrayList<WebSocketSession>();
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.info("ConnectionClosed");
		list.remove(session);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("ConnectionEstablished");
		list.add(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("handleTextMessage");
		/*logger.info(message.getPayload());*/
		
		String strJson = message.getPayload();
		
		JSONObject jsonObject = new JSONObject(strJson);
		String command = jsonObject.getString("command");
		if(command.equals("broadcast")){
			JSONObject data = jsonObject.getJSONObject("data");
			broadcast(data);
		}
	}
	
	private void broadcast(JSONObject data){
		String userName = data.getString("userName");
		String fontColor = data.getString("fontColor");
		String message = data.getString("message");
		/* 
			{
				"command":"display"
				"data":{
					"fontColor":"#ff0000",
					"message":"[홍길동] 안녕하세요"
				}
			}
		 */
		JSONObject root = new JSONObject();
		root.put("command", "display");
		JSONObject d = new JSONObject();
		d.put("fontColor", fontColor);
		d.putOnce("message", "[" + userName + "]" + message);
		root.put("data", d);
		
		/*TextMessage textMessage = new TextMessage(message.getPayload());
		for(WebSocketSession wss: list){
			synchronized(wss){ //동기화 블록
				wss.sendMessage(textMessage);
			}
		}*/
	}

}
