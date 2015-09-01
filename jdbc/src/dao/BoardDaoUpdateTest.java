package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BoardDaoUpdateTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		board board = new board();
		board.setNo(45);
		
		board.setTitle("오늘은 DAO를 합니다");
		board.setContent("DAO가 참 쉽네요 재미있어요");
		board.setHitcount(2);
		
		Connection conn = ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		int rows = boardDao.update(board);
		
		if(rows==1){
			System.out.println(board.getNo() + "번 게시물이 수정됨");

		}
		else{
			System.out.println(board.getNo() + "번 게시물이 존재하지 않습니다");
		}
		conn.close();
	}

}
