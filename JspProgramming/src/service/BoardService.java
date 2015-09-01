package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BoardDao;
import dao.ConnectionManager;
import dto.Board;

public class BoardService {
	public void add(Board board) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			BoardDao boardDao = new BoardDao(conn);
			boardDao.insert(board);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch (SQLException e) {}
		}
	}
	
	public List<Board> getPage(int pageNo, int rowsPerPage){
		List<Board> list = new ArrayList<Board>();
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			BoardDao boardDao = new BoardDao(conn);
			list = boardDao.selectByPage(pageNo, rowsPerPage);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch (SQLException e) {}
		}
		return list;
	}
	
	public Board getBoard(int boardNo){
		Board board = new Board();
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			BoardDao boardDao = new BoardDao(conn);
			board = boardDao.selectByPk(boardNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch (SQLException e) {}
		}
		return board;
	}
	
	public void modify(Board board) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			BoardDao boardDao = new BoardDao(conn);
			boardDao.update(board);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch (SQLException e) {}
		}
	}
	
	public void delete(long boardNo){
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			BoardDao boardDao = new BoardDao(conn);
			boardDao.delete(boardNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch (SQLException e) {}
		}
	}	
	
	public void addHitcount(int boardNo) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			BoardDao boardDao = new BoardDao(conn);
			boardDao.updateHitcount(boardNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch (SQLException e) {}
		}
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
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			BoardDao boardDao = new BoardDao(conn);
			int rows=boardDao.selectcount();
			totalPageNo = (rows%rowsPerPage != 0)?rows/rowsPerPage+1:rows/rowsPerPage;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch (SQLException e) {}
		}
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
