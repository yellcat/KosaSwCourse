package com.mycompany.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.dto.Board;
import com.mycompany.myapp.service.BoardService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardservice;//객체를 생성해주지 않아도 Autowired를 통해 생성
	
	@RequestMapping("board/list")
	public String list(@RequestParam(defaultValue="1") int pageNo, Model model){
		logger.info("list()");
		
		int rowsPerPage = 10;
		int pagesPerGroup = 5;
		
		int totalBoardNo = boardservice.getTotalBoardNo();
		
		int totalPageNo = totalBoardNo/rowsPerPage;
		if(totalBoardNo%rowsPerPage != 0){totalPageNo++;}
		
		int totalGroupNo = totalPageNo/pagesPerGroup;
		if(totalPageNo%pagesPerGroup!=0){totalGroupNo++;}
			
		int groupNo = (pageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup +1;
		int endPageNo = startPageNo + pagesPerGroup -1;
		if (groupNo==totalGroupNo) {endPageNo = totalPageNo;}
		
		List<Board> list = boardservice.getPage(pageNo, rowsPerPage);
		model.addAttribute("list", list);
		
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("list", list);
		
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
	public String detail(int boardNo, HttpServletRequest request){
		logger.info("detail()");
		/*logger.info(boardNo);*/
		Board board = boardservice.getBoard(boardNo);
		logger.info(board.getTitle());
		request.setAttribute("board", board);
		return "board/detail";
	}
}
