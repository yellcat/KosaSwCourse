package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Chap09Controller {
	private static final Logger logger = LoggerFactory.getLogger(Chap09Controller.class);
	
	@RequestMapping("/chap09/index")
	public String index() {
		return "chap09/index";
	}
	
	@RequestMapping("/chap09/echo")
	public String echo() {
		return "chap09/echo";
	}
	
	@RequestMapping("/chap09/chat")
	public String chat() {
		return "chap09/chat";
	}
	
	@RequestMapping("/chap09/chatColor")
	public String chatColor() {
		return "chap09/chatColor";
	}
	
	@RequestMapping("/chap09/chatGroup")
	public String chatGroup() {
		return "chap09/chatGroup";
	}
}



