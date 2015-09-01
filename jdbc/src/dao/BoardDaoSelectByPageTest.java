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
			System.out.println("번호: " + board.getNo());
			System.out.println("제목: " + board.getTitle());
//			System.out.println("내용: " + board.getContent());
			System.out.println("날짜 " + board.getDate());
			System.out.println("글쓴이: " + board.getWriter());
			System.out.println("조회수:" + board.getHitcount());

		}
		if(list.isEmpty()){
			System.out.println("게시물이 존재하지 않음");
		}
		conn.close();
	}
}
