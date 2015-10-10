package com.mycompany.myapp.controller;

import java.util.*;

import org.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.*;

@Component
public class Chap09ChatHandler extends TextWebSocketHandler {
	private static final Logger logger = LoggerFactory.getLogger(Chap09ChatHandler.class);
	private List<WebSocketSession> list = new ArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("afterConnectionEstablished");
		list.add(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("handleTextMessage");
		TextMessage textMessage = new TextMessage(message.getPayload());
		for(WebSocketSession wss:list) {
			synchronized(wss) {
				wss.sendMessage(textMessage);
			}
		}		
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.info("afterConnectionClosed");
		list.remove(session);
	}
}
