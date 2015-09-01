package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BoardDaoDeleteTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		board board = new board();
		Connection conn = ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		
		int rows = BoardDao.delete(44);		
		if(rows == 1){
			System.out.println(34 + "번 게시불이 저장됨");

		}
		else{
			System.out.println(34+"번 게시물이 존재하지 않음");
		}
		conn.close();
	}
}
