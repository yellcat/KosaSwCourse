package com.mycompany.myapp.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.myapp.ApplicationContextLoader;
import com.mycompany.myapp.dto.Board;
import com.mycompany.myapp.service.BoardService;;

public class BoardServiceTest extends ApplicationContextLoader{
	
	@Autowired
	private BoardService boardService;
	
	@Test
	public void testxxx(){
		Board board = new Board();
		board.setTitle("제목1");
		board.setContent("내용1");
		board.setWriter("글쓴이1");
		boardService.add(board);
	}
}
