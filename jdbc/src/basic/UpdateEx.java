package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEx {

	public static void main(String[] args) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		try {Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://blueskii.iptime.org:3306/team5", 
				"team5","123456");
		String sql = "update user9_boards set board_title=?, board_content = ?, board_writer=? where board_no =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,"����");
		pstmt.setString(2,"����");
		pstmt.setString(3,"�̸�");
		pstmt.setInt(4, 1);
		int row = pstmt.executeUpdate();
		System.out.println(row + "���� ���� ������Ʈ");
		
		}catch(Exception e){
			e.printStackTrace();
			}finally{
				try {pstmt.close();}catch (SQLException e) {}
				try {conn.close();} catch (SQLException e) {}
				}
		}
}