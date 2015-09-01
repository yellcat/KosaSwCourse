package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
//	//싱글톤
//	private static BoardDao singlton = new BoardDao();
//	private BoardDao (){}
//	public static BoardDao getInstance (){
//		return singlton;
//	}
	
	private static Connection conn;
	
	//생성자 주입방식
	public BoardDao(Connection conn){
		this.conn = conn;
	}	
	
	//데이터작업메소드
	public Integer insert(board board) throws SQLException {
		//insert가 실패한 경우, Integer는 null을 반환할 수 있다
		Integer pk = null;	
		String sql = "insert into boards (board_title, board_content, board_writer, board_date) values (?,?,?, now())";

		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql, new String []{"board_no"});
		pstmt.setString(1,board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setString(3, board.getWriter());
		int row = pstmt.executeUpdate(); //맞으면 변경된 행 수 리턴
	
		if(row==1){
			ResultSet rs= pstmt.getGeneratedKeys();
			if(rs.next()){
				pk = rs.getInt(1);				
			}
			rs.close();
		}
	return pk;
	}
	
	//행수가리턴되므로 int타입
	public int update(board board)throws SQLException{
		int rows=0;
		String sql = "update boards set board_title=?, board_content = ?, board_hitcount =? where board_no =?";
		
		PreparedStatement pstmt = null;
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getHitcount());
		pstmt.setInt(4, board.getNo());
		
		rows = pstmt.executeUpdate();
		pstmt.close();
		return rows;
	}
	
	public static int delete(int boardNo) throws SQLException{
		int rows =0;
		String sql = "delete from boards where board_no = ?";

		PreparedStatement pstmt = null;
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);
		
		rows = pstmt.executeUpdate();

		return rows;
	}
	
	public board selectByPk(int boardNo) throws SQLException{
		board board =null;
		String sql = "select * from boards where board_no = ?";
		
		PreparedStatement pstmt = null;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			board = new board();
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setContent(rs.getString("board_content"));
			board.setDate(rs.getDate("board_date"));
			board.setWriter(rs.getString("board_writer"));
			board.setHitcount(rs.getInt("board_hitcount"));
		}
		rs.close();
		pstmt.close();
		
		return board;
	}

	public List <board> selectByPage(int page, int rowsPerPage) throws SQLException{
		List <board> list = new ArrayList<board>();
		String sql ="select rn, board_no, board_title, board_writer, board_date, board_hitcount from "
				+ "(select rownum as rn, board_no, board_title, board_writer, board_date, board_hitcount from "
				+ "(select * from boards order by board_no desc)) "
				+ "where rn between ? and ?";

		PreparedStatement pstmt = null;

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, (page-1)*rowsPerPage+1);
			pstmt.setInt(2, page*rowsPerPage);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				board board = new board();
				board.setNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("board_title"));
				board.setDate(rs.getDate("board_date"));
				board.setWriter(rs.getString("board_writer"));
				board.setHitcount(rs.getInt("board_hitcount"));
				
				list.add(board);
			}
			rs.close();
			pstmt.close();
			return list;
	}
}
