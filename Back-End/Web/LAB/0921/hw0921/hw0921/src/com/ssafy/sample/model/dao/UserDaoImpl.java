package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.sample.dto.Player;
import com.ssafy.sample.dto.User;
import com.ssafy.sample.util.DBUtil;

public class UserDaoImpl implements UserDao{
	private DBUtil dbu = DBUtil.getInstance();
	private static UserDaoImpl instance = new UserDaoImpl();
	private UserDaoImpl() {}
	public static UserDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public int insert(User user) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = dbu.getConnection();
			String sql = "insert into `user` values (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("회원 가입 에러");
			e.printStackTrace();
			throw e;
		} finally {
			dbu.close(conn, pstmt);
		}
		
		return result;
	}

	@Override
	public User select(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		User result = null;
		ResultSet rs = null;
		try {
			conn = dbu.getConnection();
			String sql = "select * from `user` where id=? and pw=?";
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
			System.out.println("로그인 에러");
			e.printStackTrace();
		} finally {
			dbu.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
}
