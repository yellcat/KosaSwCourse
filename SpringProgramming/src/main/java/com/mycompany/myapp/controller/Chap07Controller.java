package com.mycompany.myapp.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.dto.Board;
import com.mycompany.myapp.dto.Login;
import com.mycompany.myapp.dto.LoginValidator;
import com.mycompany.myapp.dto.Member;
import com.mycompany.myapp.dto.MemberValidator;

@Controller
public class Chap07Controller {
	private static final Logger logger = LoggerFactory.getLogger(Chap07Controller.class);
	
	@RequestMapping("/chap07/index")
	public String index() {
		return "chap07/index";
	}
	
	@RequestMapping(value="/chap07/commandObject", method=RequestMethod.GET)
	public String commandObjectGet() {
		return "chap07/writeForm";
	}
	
	@RequestMapping(value="/chap07/commandObject", method=RequestMethod.POST)
	public String commandObjectPost(Board board) {
	//public String commandObjectPost(@ModelAttribute("board") Board board) {
		if(board.getTitle()==null || board.getTitle().equals("")) {
			return "chap07/writeForm";
		}
		if(board.getWriter()==null || board.getWriter().equals("")) {
			return "chap07/writeForm";
		}
		if(board.getContent()==null || board.getContent().equals("")) {
			return "chap07/writeForm";
		}
		
		return "redirect:/board/list";
	}
	
	@ModelAttribute("menuList")
	public List<String> getMenuList() {
		logger.info("getMenuList()");
		List<String> menuList = Arrays.asList("메뉴1","메뉴2","메뉴3","메뉴4","메뉴5");
		return menuList;
	}
	
	@RequestMapping("/chap07/modelAttribute1")
	public String modelAttribute1() {
		return "chap07/modelAttribute1";
	}
	
	@RequestMapping("/chap07/modelAttribute2")
	public String modelAttribute2() {
		return "chap07/modelAttribute2";
	}	
	
	@RequestMapping("/chap07/cookieValueSet")
	public String cookieValueSet(HttpServletResponse response) {
		Cookie cookie1 = new Cookie("memberId", "white");
		Cookie cookie2 = new Cookie("loginStatus", "ok");
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		return "chap07/cookieValueSet";
	}
	
	@RequestMapping("/chap07/cookieValueGet")
	public String cookieValueGet(
			@CookieValue String memberId, 
			@CookieValue("loginStatus") String status,
			Model model) {
		logger.info("memberId: " + memberId);
		logger.info("loginStatus: " + status);
		model.addAttribute("memberId", memberId);
		model.addAttribute("loginStatus", status);
		return "chap07/cookieValueGet";
	}	
	
	@RequestMapping("/chap07/requestHeader")
	public String requestHeader(@RequestHeader("User-Agent") String userAgent, Model model) {
		model.addAttribute("userAgent", userAgent);
		return "chap07/requestHeader";
	}

	@RequestMapping(value="/chap07/login", method=RequestMethod.GET)
	public String loginForm(Login login) {
		return "chap07/loginForm";
	}
	
	@RequestMapping(value="/chap07/login", method=RequestMethod.POST)
	public String login(Login login, BindingResult bindingResult) {
		new LoginValidator().validate(login, bindingResult);
		if(bindingResult.hasErrors()) {
			return "chap07/loginForm";
		}
		//login 작업
		return "redirect:/chap07/index";
	}
	
	@RequestMapping(value="/chap07/join", method=RequestMethod.GET)
	public String joinForm(Member member) {
		return "chap07/joinForm";
	}
	
	@RequestMapping(value="/chap07/join", method=RequestMethod.POST)
	public String join(Member member, BindingResult bindingResult) {
		//우효성 검사
		new MemberValidator().validate(member, bindingResult);
		if(bindingResult.hasErrors()){
			return "chap07/joinForm";
		}
		//join 작업
		logger.info(member.getMemberBirth().toString());
		return "redirect:/chap07/index";
	}
}



