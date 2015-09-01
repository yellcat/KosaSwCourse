package dao;

import java.sql.*;

public class ConnectionManager {
	public static Connection getConnection() 
			throws ClassNotFoundException, SQLException{
		Connection conn =null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc::mysql://blueskii.iptime.org:3306/team5",
				"team5", "123456");
		return conn;
	}
}
