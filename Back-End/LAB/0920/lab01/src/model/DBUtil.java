package model;

import java.io.IOException;
import java.sql.*;


public class DBUtil {
	static final String driver ="com.mysql.cj.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost:3306/ssafy_8th";
	static final String dbUser = "ssafy";
	static final String dbPw ="ssafy";
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	static Connection makeConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, dbUser, dbPw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("커넥션 생성 오류");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(AutoCloseable...closeables) {
		for (AutoCloseable closeable : closeables) {
			if (closeable!=null) {
				try {closeable.close();} catch (Exception e) {	}
			}
			
		}
	}

	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		// TODO Auto-generated method stub
		
	}
}
