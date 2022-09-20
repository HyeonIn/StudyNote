package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private DBUtil() {
		// 드라이버 jar 제대로 인식되는지 체크
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 인식 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 인식 오류");
			e.printStackTrace();
		}
	}
	private static DBUtil instance = new DBUtil();
	public static DBUtil getInstance() {
		return instance;
	}
/////////////////////////////////////////////////////////////////////	
	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/ssafy_8th";
		String username = "ssafy";
		String password = "ssafy";
		return DriverManager.getConnection(url, username, password);
	}
	
	public void close(AutoCloseable... res) {
		for(AutoCloseable tmp: res) {
			if(tmp!=null) {
				try {
					tmp.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
