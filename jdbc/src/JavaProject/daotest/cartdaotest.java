package JavaProject.daotest;

import java.sql.Connection;
import java.sql.SQLException;
import JavaProject.dao.ConnectionManager;
import JavaProject.dao.CartDao;

public class cartdaotest {
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		Connection conn = ConnectionManager.getConnection();
		CartDao cartDao = new CartDao(conn);
		
		int rows = cartDao.delete("dddd");		
		if(rows != 0){
			System.out.println("aaa의 게시물 삭제");
		}
		else{
			System.out.println("aaa의 게시물 삭제 실패");
			System.out.println(rows);
		}
		conn.close();
	}
}