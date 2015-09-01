package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAutoIncrementValueEx {

	public static void main(String[] args) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		try {Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://blueskii.iptime.org:3306/team5", 
				"team5","123456");
		String sql = "insert into user9_boards (board_title, board_content, board_writer,board_date) values (?,?,?,now())";
		pstmt = conn.prepareStatement(sql, new String []{"board_no"});
		pstmt.setString(1,"������ ȭ����");
		pstmt.setString(2, "������ �������");
		pstmt.setString(3,  "ȫ�浿");
		int row = pstmt.executeUpdate(); //������ ����� �� �� ����
		
		int boardNo = 0;
		if(row==1){
			ResultSet rs= pstmt.getGeneratedKeys();
			if(rs.next()){
				boardNo = rs.getInt(1);
				
			}
			rs.close();
		}
		
		System.out.println(boardNo+ "�� �Խù��������");
		
		}catch(Exception e){
			e.printStackTrace();
			}finally{
				try {pstmt.close();}catch (SQLException e) {}
				try {conn.close();} catch (SQLException e) {}
				}
		}
}