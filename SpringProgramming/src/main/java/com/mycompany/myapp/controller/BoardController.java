package com.mycompany.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.dto.Board;
import com.mycompany.myapp.service.BoardService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardservice;//객체를 생성해주지 않아도 Autowired를 통해 생성
	
	@RequestMapping("board/list")
	public String list(HttpServletRequest request){
		logger.info("list()");
		List<Board> list = boardservice.getPage(1, 10);
		request.setAttribute("list", list);
		return "board/list";
	}
	
	@RequestMapping("board/writeForm")
	public String writeForm(){
		logger.info("writeForm()");
		return "board/writeForm";
	}
	
	@RequestMapping("board/updateForm")
	public String updateForm(){
		logger.info("updateForm()");
		return "board/updateForm";
	}
	
	@RequestMapping("board/write")
	public String write(String title, String writer, String content){
		//parameter 명과 매개변수 명이 일치할 때 값이 들어온다
		logger.info("write()");
		
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		boardservice.add(board);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("board/update")
	public String update(){
		logger.info("update()");
		return "redirect:/board/list";
	}
	
	@RequestMapping("board/detail")
	public String detail(HttpServletRequest request){
		logger.info("detail()");
		Board board = boardservice.getBoard(325);
		request.setAttribute("board", board);
		return "board/detail";
	}
}
