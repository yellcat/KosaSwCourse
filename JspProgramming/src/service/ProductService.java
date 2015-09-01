package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectionManager;
import dao.ProductDao;
import dto.Product;

public class ProductService {
	public void insert(Product product){
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			ProductDao pdao = new ProductDao(conn);
			pdao.insert(product);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<Product> getPage(int rownum, int rowPerPage){
		Connection conn = null;
		List<Product> list = new ArrayList<Product>();
		
		try {	
			conn = ConnectionManager.getConnection();
			ProductDao pdao = new ProductDao(conn);
			list = pdao.selectByPage(rownum,rowPerPage);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public Product getProduct(int productNo){
		Connection conn = null;
		Product product = new Product();
		
		try {	
			conn = ConnectionManager.getConnection();
			ProductDao pdao = new ProductDao(conn);
			product = pdao.selectByPk(productNo);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return product;
	}
	
	public void update(Product product){
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			ProductDao pdao = new ProductDao(conn);
			pdao.update(product);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void delete(int productNo){
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			ProductDao pdao = new ProductDao(conn);
			pdao.delete(productNo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
