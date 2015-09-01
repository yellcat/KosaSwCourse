package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionEx {

	public static void main(String[] args) {
		Connection conn =null;
		try {Class.forName("ConnectionEx.javaoracle.jdbc.OracleDriver");//자신의 객체를 생성
		/*class OracleDriver static { 
		 * OracleDriver driver = new OracleDriver();
		 * Drivermanaber.registerDriver(driver)}*/
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@70.12.108.154:1521:orcl", 
				//드라이버의 종류/접근 드라이버 종류
				"user9","12345");
				//아이디, 비밀번호
		System.out.println("성공");
		//연결문자열 1.IP 2.Port 3.ID & Password 
		}catch(Exception e){
			System.out.println("실패");
			}finally{
				try {conn.close();} catch (SQLException e) {}
				}
		}
}