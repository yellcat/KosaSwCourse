package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController {

	public void handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberController-handle");
		//메소드를 요청하는 방법
		////1. 요청 파라미터 ex)member?action=메소드명
		String action = request.getParameter("action");
		
		switch(action){
		case "joinForm": joinForm(request, response); break;
		case "join": 	 join(request, response); break;
		case "loginForm":loginForm(request, response); break;
		case "login": 	 login(request, response); break;
		}
	}

	public void joinForm(HttpServletRequest request, HttpServletResponse response){
		System.out.println("joinForm");
	}
	public void join(HttpServletRequest request, HttpServletResponse response){
		System.out.println("join");
	}
	
	public void loginForm(HttpServletRequest request, HttpServletResponse response){
		System.out.println("loginForm");
	}
	public void login(HttpServletRequest request, HttpServletResponse response){
		System.out.println("login");
	}

}
