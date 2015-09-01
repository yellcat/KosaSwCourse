package JavaProject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public static Connection getConnection() 
			throws ClassNotFoundException, SQLException{
		Connection conn =null;
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@70.12.108.154:1521:orcl", 
				"user8","12345");
		return conn;
	}
}
