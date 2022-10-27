package com.ssafy.util;

import org.springframework.stereotype.Component;

@Component
public class DBUtil {

//	private final String driverName = "com.mysql.cj.jdbc.Driver";
//	private final String url = "jdbc:mysql://localhost:3306/ssafyweb?serverTimezone=UTC";
//	private final String user = "ssafy";
//	private final String pass = "ssafy";
//
//	private static DBUtil instance = new DBUtil();
//
//	private DBUtil() {
//		try {
//			Class.forName(driverName);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static DBUtil getInstance() {
//		return instance;
//	}
//
//	public Connection getConnection() throws SQLException {
//		return DriverManager.getConnection(url, user, pass);
//	}

//	public void close(PreparedStatement pstmt, Connection conn) {
//		try {
//			if (pstmt != null)
//				pstmt.close();
//			if (conn != null)
//				conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
//		try {
//			if (rs != null)
//				rs.close();
//			if (pstmt != null)
//				pstmt.close();
//			if (conn != null)
//				conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	public void close(AutoCloseable... closeables) {
		for (AutoCloseable c : closeables) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
