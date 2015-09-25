package com.mycompany.myapp.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.dto.Board;
import com.mycompany.myapp.service.BoardService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardservice;//媛앹껜瑜� �깮�꽦�빐二쇱� �븡�븘�룄 Autowired瑜� �넻�빐 �깮�꽦
	
	@RequestMapping("board/list")
	public String list(@RequestParam(defaultValue="1") int pageNo, Model model, HttpSession session){
		logger.info("list()");
		
		session.setAttribute("pageNo", pageNo);
		
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
	
	@RequestMapping(value = "board/write", method = RequestMethod.GET)
		public String write(){
		logger.info("writeForm()");
		return "board/writeForm";
	}
	
	@RequestMapping("board/write")
	public String write(
		Board board,
		HttpSession session){
		//parameter 紐낃낵 留ㅺ컻蹂��닔 紐낆씠 �씪移섑븷 �븣 媛믪씠 �뱾�뼱�삩�떎
		
		logger.info("write()");
		
		//泥⑤��뙆�씪�쓣 �븯�뱶�뿉 ���옣
		ServletContext application = session.getServletContext();
		String dirPath = application.getRealPath("/resources/uploadfiles");
		String originalFilename = board.getAttach().getOriginalFilename();
		String filesystemName = System.currentTimeMillis() + "-" + originalFilename;
		String contentType = board.getAttach().getContentType();
		
		//�뙆�씪�뿉 ���옣�븯湲�
		if(!board.getAttach().isEmpty()){
			try {
				board.getAttach().transferTo(new File(dirPath+"/"+filesystemName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//database�뿉 寃뚯떆臾� �젙蹂� ���옣
		/*Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);*/
		board.setOriginalFileName(originalFilename);
		board.setFilesystemName(filesystemName);
		board.setContentType(contentType);
		
		boardservice.add(board);
		
		return "redirect:/board/list";
	}
	
	
	@RequestMapping("board/updateForm")
	public String updateForm(int boardNo, Model model){
		logger.info("updateForm()");
		logger.info(String.valueOf(boardNo));
		Board board = boardservice.getBoard(boardNo);
		logger.info(board.getTitle());
		model.addAttribute("board", board);
		return "board/updateForm";
	}
	
	@RequestMapping("board/update")
	public String update(Board board){
		logger.info("update()");
		boardservice.update(board);
		return "redirect:/board/detail?boardNo="+board.getNo();
	}
	
	@RequestMapping("board/detail/{boardNo}")
	public String detail(@PathVariable("boardNo") int boardNo, Model model){
		logger.info("detail()");
		Board board = boardservice.getBoard(boardNo);
		model.addAttribute("board", board);
		return "board/detail";
	}
	
	@RequestMapping("board/delete/{boardNo}")
	public String delete(@PathVariable("boardNo") int boardNo){
		logger.info("detail()");
		boardservice.delete(boardNo);
		return "redirect board/list";
	}
}
