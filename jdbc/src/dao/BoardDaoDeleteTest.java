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
			System.out.println(34 + "�� �Խú��� �����");

		}
		else{
			System.out.println(34+"�� �Խù��� �������� ����");
		}
		conn.close();
	}
}
