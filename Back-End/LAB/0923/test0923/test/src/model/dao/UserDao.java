package model.dao;

import java.sql.*;

import model.dto.UserDTO;
import util.DBUtil;


public class UserDao {
	private DBUtil dbu = DBUtil.getUtil();
	
	private UserDao() {}
	private static UserDao instance = new UserDao();
	public static UserDao getInstance(){
		return instance;
	}
	
	public UserDTO select(String mid, String mpass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		UserDTO result = null;
		ResultSet rs = null;
		try {
			conn = dbu.getConnection();
			String sql = "select * from tmember where mid=? and mpass=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpass);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				UserDTO u = new UserDTO();
				u.setMid(rs.getString(1));
				u.setMpass(rs.getString(2));
				u.setMname(rs.getString(3));
				result = u;
			}
			
		} catch (Exception e) {
			System.out.println("로그인 에러");
			e.printStackTrace();
		} finally {
			dbu.close(conn, rs, pstmt);
		}
		return result;
	}
}
