package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BoardDaoSelectByPageTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		List <board> list = boardDao.selectByPage(2,10);
		
		for(board board: list){
			System.out.println("��ȣ: " + board.getNo());
			System.out.println("����: " + board.getTitle());
//			System.out.println("����: " + board.getContent());
			System.out.println("��¥ " + board.getDate());
			System.out.println("�۾���: " + board.getWriter());
			System.out.println("��ȸ��:" + board.getHitcount());

		}
		if(list.isEmpty()){
			System.out.println("�Խù��� �������� ����");
		}
		conn.close();
	}
}
