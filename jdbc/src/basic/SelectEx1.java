package basic;

import java.sql.*;

public class SelectEx1 {

	public static void main(String[] args) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		try {Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://blueskii.iptime.org:3306/team5", 
				"team5","123456");
		String sql = "select * from user9_boards where board_content like ?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, "%ø¿¥√¿∫%");
		ResultSet rs = pstmt.executeQuery();
		
		
		while(rs.next()){
			int boardNo = rs.getInt("board_no");
			String boardTitle = rs.getString("board_title");
			String boardContent = rs.getString("board_content");
			Date boardDate = rs.getDate("board_date");
			String boardWriter = rs.getString("board_writer");
			int boardHitcount = rs.getInt("board_hitcount");
			System.out.println(boardNo +"\t" +"\t" + boardTitle +"\t" + boardContent);
		}
		
		rs.close();

		}catch(Exception e){
			e.printStackTrace();
			}finally{
				try {pstmt.close();}catch (SQLException e) {}
				try {conn.close();} catch (SQLException e) {}
				}
		}
}
