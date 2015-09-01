package dao;

import dto.*;
import java.sql.*;
import java.util.*;
import dao.*;

public class ProductDao {
	private Connection conn;
	public ProductDao(Connection conn) {
		this.conn = conn;
	}
	
	public Integer insert(Product product) throws SQLException{
		Integer pk = null;
		
		String sql = "insert into ExProducts (product_name, product_price) values (?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"product_no"});
		pstmt.setString(1, product.getName());
		pstmt.setInt(2, product.getPrice());
		
		int rows = pstmt.executeUpdate();
		
		if(rows==1){
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				pk=rs.getInt(1);
			}
			rs.close();
		}
		pstmt.close();
		return pk;
	}
	
	public List<Product> selectByPage(int rownum, int rowPerPage) throws SQLException{
		List<Product> list = new ArrayList<Product>();
		String sql = ""
				+ "select product_no, product_name, product_price "
				+ "from ExProducts order by product_no desc "
				+ "limit ?,?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, (rownum-1)*rowPerPage);
		pstmt.setInt(2,  rowPerPage);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Product product = new Product();
			product.setNo(rs.getInt("product_no"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getInt("product_price"));
			
			list.add(product);
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public Product selectByPk(int productNo) throws SQLException{
		Product product = new Product();
		String sql = "select * from ExProducts where product_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, productNo);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			product.setNo(rs.getInt("product_no"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getInt("product_price"));
		}
		rs.close();
		pstmt.close();
		return product;
	}
	
	public int update(Product product) throws SQLException{
		int rows = 0;
		String sql = 
				"update ExProducts set product_name = ?, product_price = ? where product_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, product.getName());
		pstmt.setLong(2, product.getPrice());
		pstmt.setInt(3, product.getNo());
		
		rows = pstmt.executeUpdate();
		
		pstmt.close();
		return rows; 
	}
	
	public int delete(int productNo) throws SQLException{
		int rows = 0;
		String sql = "delete from ExProducts where product_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, productNo);
		
		rows = pstmt.executeUpdate();

		pstmt.close();
		return rows;
	}
}
