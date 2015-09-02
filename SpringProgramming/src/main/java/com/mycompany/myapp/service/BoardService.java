package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.BoardDao;
import com.mycompany.myapp.dto.Board;

@Component
public class BoardService {
	@Autowired
	private BoardDao boardDao;
	
	public void add(Board board) {
		boardDao.insert(board);
	}
	
	public List<Board> getPage(int pageNo, int rowsPerPage){
		List<Board> list = boardDao.selectByPage(pageNo, rowsPerPage);
		return list;
	}
	
	public Board getBoard(int boardNo){
		Board board = boardDao.selectByPk(boardNo);
		return board;
	}
	
	public void modify(Board board) {
		boardDao.update(board);
	}
	
	public void delete(long boardNo){
		boardDao.delete(boardNo);
	}	
	
	public void addHitcount(int boardNo) {
		boardDao.updateHitcount(boardNo);
	}

	///////////////////////////////////////////////////////
	private int rowsPerPage = 5;
	private int pagesPerGroup = 5;
	public int getRowsPerPage(){
		return rowsPerPage;
	}
	public int getGroupNo(int pageNo){
		return (pageNo-1)/pagesPerGroup + 1;
	}
	public int startPageNo(int groupNo){
		return (groupNo-1)*rowsPerPage+1;
	}
	public int endPageNo(int groupNo){
		if(!isEndGroupNo(groupNo)){
			return getTotalPageNo();
		}else{
			return groupNo*rowsPerPage;
		}
	}
	public int getTotalPageNo(){
		int totalPageNo =1;
		int rows=boardDao.selectcount();
		totalPageNo = (rows%rowsPerPage != 0)?rows/rowsPerPage+1:rows/rowsPerPage;
		return totalPageNo;
	}
	
	public boolean isEndGroupNo(int groupNo){	
		int totalGroupNo= (getTotalPageNo()%pagesPerGroup!=0)?
				getTotalPageNo()/pagesPerGroup+1:getTotalPageNo()/pagesPerGroup;
		return (groupNo<totalGroupNo);
	}
	
	public int getEndGroupStartNo(int groupNo){	
		int totalGroupNo= (getTotalPageNo()%pagesPerGroup!=0)?
				getTotalPageNo()/pagesPerGroup+1:getTotalPageNo()/pagesPerGroup;
		return startPageNo(totalGroupNo);
	}	
}
