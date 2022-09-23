package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static final String URL = "jdbc:mysql://127.0.0.1:3306/ssafy_test?serverTimezone=UTC";
	static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String ID = "ssafy";
	static final String PASSWORD = "ssafy";

	private static DBUtil util = new DBUtil();
	public static DBUtil getUtil() {
		return util;
	}
	
	private DBUtil(){
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}

	public void close(AutoCloseable... acs) {
		for(AutoCloseable c: acs) {
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

