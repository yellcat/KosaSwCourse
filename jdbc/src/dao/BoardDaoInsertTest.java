package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BoardDaoInsertTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		board board = new board();
		board.setTitle("������ DAO�� ����� ��");
		board.setContent("DAO�� �� �����ϳ׿� ���������� �ؾ� �� �� �����ϴ�");
		board.setWriter("ȫ�浿");

		Connection conn = ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		
		Integer pk = boardDao.insert(board);
		
		if(pk!= null){
			System.out.println(pk + "�� �Խú��� �����");

		}
		else{
			System.out.println("����");
		}
		conn.close();
	}

}
