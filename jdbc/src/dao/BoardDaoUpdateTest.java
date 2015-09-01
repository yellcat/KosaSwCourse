package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BoardDaoUpdateTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		board board = new board();
		board.setNo(45);
		
		board.setTitle("������ DAO�� �մϴ�");
		board.setContent("DAO�� �� ���׿� ����־��");
		board.setHitcount(2);
		
		Connection conn = ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		int rows = boardDao.update(board);
		
		if(rows==1){
			System.out.println(board.getNo() + "�� �Խù��� ������");

		}
		else{
			System.out.println(board.getNo() + "�� �Խù��� �������� �ʽ��ϴ�");
		}
		conn.close();
	}

}
