package JavaProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	private Connection conn;
		
	//생성자 주입 방식
	public MemberDao(Connection conn) {
		this.conn = conn;
	}
	
	//데이터 작업 메소드
	public Integer insert(Member member) throws SQLException {
		Integer pk = null;
		String sql = "insert into Members (Member_id, Member_pw, Member_name, Member_mobile, Member_Address) values (?, ?, ?, ?, ?)";	
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPw());
		pstmt.setString(3, member.getName());
		pstmt.setString(4, member.getMobile());
		pstmt.setString(5, member.getAddress());
		
		pk = pstmt.executeUpdate();
		pstmt.close();
		return pk;
	}
		
	public Member selectByPk(String MemberId) throws SQLException {
		Member member = null;
		String sql = "select *from members where member_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, MemberId);
//		pstmt.setString(2, MemberPw);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
		member = new Member();
		member.setId(rs.getString("member_id"));
		member.setPw(rs.getString("member_pw"));
		member.setName(rs.getString("member_name"));
		member.setMobile(rs.getString("member_mobile"));
		member.setAddress(rs.getString("member_address"));
		}
		rs.close();
		
		pstmt.close();
		return member;
	}
}
