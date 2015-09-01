package JavaProject.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
private Connection conn;
   
   public OrderDao(Connection conn) {
      this.conn = conn;
   }
   
   public Integer insert(Order order) throws SQLException {
      Integer pk = null;
      String sql = "insert into orders(order_no, order_date, order_payment,member_id) values(orders_seq2.nextval,sysdate, ?, ?)";
      
      PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"order_no"});
      pstmt.setString(1, order.getPayment());
//      pstmt.setInt(2, order.getPrice());
      pstmt.setString(2, order.getId());
      int row = pstmt.executeUpdate();
      if(row == 1) {
         ResultSet rs = pstmt.getGeneratedKeys();
         if(rs.next()) {
            pk = rs.getInt(1);
         }
         rs.close();
      }
      pstmt.close();         
      return pk;
   }
   
   public Order selectByPk(int orderNo) throws SQLException {
      Order order = null;
      String sql = "select*from orders where order_no=?";
      
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, orderNo);
      ResultSet rs = pstmt.executeQuery();
      
      if(rs.next()) {
         order = new Order();
         order.setNo(rs.getInt("order_no"));
         order.setDate(rs.getDate("order_date"));
         order.setPayment(rs.getString("order_payment"));
 //        order.setPrice(rs.getInt("order_price"));
         order.setId(rs.getString("member_id"));
      }
      return order;
   }
   
	public List <Order> selectByPk (String member_id) 
	         throws SQLException, ClassNotFoundException{
	      List <Order> list= new ArrayList<Order>();
	      String sql = "select * from orders where member_id = ?";
	      
	      conn = ConnectionManager.getConnection();
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      
	      pstmt.setString(1, member_id);
	      ResultSet rs = pstmt.executeQuery();
	      
	      while(rs.next()){
	         Order order = new Order();
	         order.setNo(rs.getInt("order_no"));
	         order.setId(rs.getString("member_id"));         
//	         order.setPrice(rs.getInt("order_price"));
	         list.add(order);
	      }
	      rs.close();
	      pstmt.close();
	      return list;
	   }
}
