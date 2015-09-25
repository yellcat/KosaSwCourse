package com.mycompany.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.dto.Board;

@Controller
public class Chap07Controller {
//	private static final Logger logger = LoggerFactory.getLogger(Chap07Controller.class);
	
	@RequestMapping(value="/chap07/commandObject", method=RequestMethod.GET)
	public String commandObjectGet(){
		return "chap07/writeForm";
	}

	@RequestMapping(value="/chap07/commandObject", method=RequestMethod.POST)
	public String commandObjectPost(Board board, Model model){
		model=model.addAttribute(board);
		
		if(board.getTitle()==null||board.getTitle().equals("")){
			return "chap07/writeForm";
		}
		if(board.getWriter()==null|board.getWriter().equals("")){
			return "chap07/writeForm";
		}
		if(board.getContent()==null|board.getContent().equals("")){
			return "chap07/writeForm";
		}
		return "redirect:/board/list";
	}
}
