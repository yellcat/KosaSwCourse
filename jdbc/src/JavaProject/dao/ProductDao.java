package JavaProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	private Connection conn;

	public ProductDao(Connection conn) {
		this.conn = conn;
	}

	public Product selectByPk(int product_no) throws SQLException {
		Product product = null;
		String sql = "select * from products where product_no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, product_no);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			product = new Product();
			product.setProduct_no(rs.getInt("product_no"));
			product.setProduct_name(rs.getString("product_name"));
			product.setProduct_inventory(rs.getInt("product_inventory"));
			product.setProduct_price(rs.getInt("product_price"));
		}

		return product;

	}

	public List<Product> selectByPage(int pageNo, int rowsPerPage) throws SQLException {
		List<Product> list = new ArrayList<Product>();
		String sql = "select rn, product_no, product_name, product_inventory, product_price from ( "
				+ "select rownum rn, product_no, product_name, product_inventory, product_price from ( "
				+ "select product_no, product_name, product_inventory, product_price from "
				+ "products order by product_no ) where rownum<=? ) where rn>=? ";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pageNo * rowsPerPage);
		pstmt.setInt(2, (pageNo - 1) * rowsPerPage + 1);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Product product = new Product();
			product.setProduct_no(rs.getInt("product_no"));
			product.setProduct_name(rs.getString("product_name"));
			product.setProduct_inventory(rs.getInt("product_inventory"));
			product.setProduct_price(rs.getInt("product_price"));
			list.add(product);
		}

		rs.close();
		pstmt.close();
		return list;
	}
}
