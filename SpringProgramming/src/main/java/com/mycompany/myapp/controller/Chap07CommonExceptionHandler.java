package com.mycompany.myapp.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//의존성 객체(스프링이 관리하는 객체) 이게 없으면 Autowired를 사용할 수 없다
@Component
@ControllerAdvice("com.mycompany.myapp.controller")
public class Chap07CommonExceptionHandler {
	@ExceptionHandler(Exception.class)
	public String handleExecption(){
		//관리자에게 메일/SMS를 보냄
		//사용자에게 보여줄 Jsp 이동
		return "chap07/exception";
	}
}
