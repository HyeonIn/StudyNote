package com.ssafy.sample.model.dao;

import java.sql.*;

import com.ssafy.sample.dto.User;
import com.ssafy.sample.util.DBUtil;

public class UserDaoImpl implements UserDao {
	private DBUtil dbu = DBUtil.getInstance();
	@Override
	public User selectOne(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		User result = null;
		ResultSet rs = null;
		try {
			conn = dbu.getConnection();
			String sql = "select * from userinfo where id=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				User u = new User();
				u.setId(rs.getString(1));
				u.setPw(rs.getString(2));
				result = u;
			}
			
		} catch (Exception e) {
			System.out.println("User select error");
			e.printStackTrace();
		} finally {
			dbu.close(conn, pstmt, rs);
		}
		return result;
	}
	
}
