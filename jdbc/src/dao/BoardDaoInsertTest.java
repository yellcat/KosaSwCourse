package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BoardDaoInsertTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		board board = new board();
		board.setTitle("오늘은 DAO를 만드는 날");
		board.setContent("DAO가 참 유용하네요 연습을많이 해야 할 것 같습니다");
		board.setWriter("홍길동");

		Connection conn = ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		
		Integer pk = boardDao.insert(board);
		
		if(pk!= null){
			System.out.println(pk + "번 게시불이 저장됨");

		}
		else{
			System.out.println("실패");
		}
		conn.close();
	}

}
