package JavaProject.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDao {	
private Connection conn;
	
	public CartDao(Connection conn) {
		this.conn = conn;
	}
	
	//데이터 작업 메소드
	public Integer insert(Cart cart) 
			throws SQLException, ClassNotFoundException{
		Integer pk = null;
		String sql = "insert into carts (cart_no, member_id, product_no, cart_amount) values (carts_seq.nextval, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"cart_no"}); //pk는 자동생성키만 들어온다
		
		pstmt.setString(1, cart.getMember_id());
		pstmt.setInt(2, cart.getProduct_no());
		pstmt.setInt(3, cart.getCart_amount());
				
		int row = pstmt.executeUpdate(); //실행 후 실제 삽입된 행 수 삽입
		
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()){
			if(row ==1){
				pk = rs.getInt(1);
			}
		}
		rs.close();
		pstmt.close();
		return pk;
	}
	//상품개수 변경
	public int update(Cart cart) 
			throws SQLException, ClassNotFoundException{
		int row = 0;
		String sql = "update carts set cart_amount =? where member_id = ? and product_no = ?";
		
		conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setLong(1, cart.getCart_amount());
		pstmt.setString(2, cart.getMember_id());
		pstmt.setInt(3, cart.getProduct_no());
		
		row = pstmt.executeUpdate();

		pstmt.close();
		return row;
	}
	//주문시 삭제
	public int delete(String member_id) 
			throws SQLException, ClassNotFoundException{
		int rows = 0;
		String sql = "delete from carts where member_id = ?";	

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, member_id);
		rows = pstmt.executeUpdate();

		pstmt.close();
		return rows;
	}
	//전체출력
	public List <Cart> selectByPk (String member_id) 
			throws SQLException, ClassNotFoundException{
		List <Cart> list= new ArrayList <Cart>();
		String sql = "select * from carts where member_id = ?";
		
		conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, member_id);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			Cart cart= new Cart();
			cart.setMember_id(rs.getString("member_id"));
			cart.setProduct_no(rs.getInt("product_no"));
			cart.setCart_amount(rs.getInt("cart_amount"));
			cart.setCart_no(rs.getInt("cart_no"));
			
			list.add(cart);
		}
		rs.close();
		pstmt.close();
		return list;
	}

}
