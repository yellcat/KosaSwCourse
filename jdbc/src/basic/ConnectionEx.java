package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionEx {

	public static void main(String[] args) {
		Connection conn =null;
		try {Class.forName("ConnectionEx.javaoracle.jdbc.OracleDriver");//�ڽ��� ��ü�� ����
		/*class OracleDriver static { 
		 * OracleDriver driver = new OracleDriver();
		 * Drivermanaber.registerDriver(driver)}*/
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@70.12.108.154:1521:orcl", 
				//����̹��� ����/���� ����̹� ����
				"user9","12345");
				//���̵�, ��й�ȣ
		System.out.println("����");
		//���Ṯ�ڿ� 1.IP 2.Port 3.ID & Password 
		}catch(Exception e){
			System.out.println("����");
			}finally{
				try {conn.close();} catch (SQLException e) {}
				}
		}
}