package com.ssafy.test.model.dao;

import java.sql.*;

import com.ssafy.test.model.dto.memberDTO;
import com.ssafy.test.util.DBUtil;

public class memberDao {
	private DBUtil dbu = DBUtil.getUtil();
	public memberDTO select(String mid, String mpass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		memberDTO result = null;
		ResultSet rs = null;
		try {
			conn = dbu.getConnection();
			String sql ="select * from tmember where mid=? and mpass=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpass);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = new memberDTO(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbu.close(conn, pstmt, rs);
		}
		return result;
	}
}
