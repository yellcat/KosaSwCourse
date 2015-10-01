package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home() {
		/*System.out.println("HomeController-Home()");//프로그램을 만든다면 지워주어야 함*/	
		logger.info("HomeController-Home()");
		/*logger.debug("HomeController-Home()");//log를 기록하지 않는다고 한다면 지워주지 않아도 된다*/	
		return "home";
	}
	
}
