package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEx {

	public static void main(String[] args) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		try {Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://blueskii.iptime.org:3306/team5", 
				"team5","123456");
		String sql = "insert into user9_boards (board_title, board_content, board_writer, board_date) values (?,?,?,now())";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,"오늘은 화요일");
		pstmt.setString(2, "오늘은 졸리웁당");
		pstmt.setString(3,  "홍길동");
		int row = pstmt.executeUpdate(); //맞으면 1을 리턴
		System.out.println("1개의 행이 저장");
		
		}catch(Exception e){
			e.printStackTrace();
			}finally{
				try {pstmt.close();}catch (SQLException e) {}
				try {conn.close();} catch (SQLException e) {}
				}
		}
}