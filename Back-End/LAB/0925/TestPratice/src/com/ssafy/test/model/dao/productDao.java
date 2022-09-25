package com.ssafy.test.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.test.model.dto.productDTO;
import com.ssafy.test.util.DBUtil;

public class productDao {
	private DBUtil dbu = DBUtil.getUtil();
	public List<productDTO> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<productDTO> result = new ArrayList<>();
		ResultSet rs = null;
		try {
			conn = dbu.getConnection();
			String sql ="select * from tproduct";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				result.add(new productDTO(rs.getString(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbu.close(conn, pstmt, rs);
		}
		return result;
	}
	public productDTO selectOne(String pcode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		productDTO result = null;
		ResultSet rs = null;
		try {
			conn = dbu.getConnection();
			String sql ="select * from tproduct where pcode=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pcode);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = new productDTO(rs.getString(1), rs.getString(2), rs.getInt(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbu.close(conn, pstmt, rs);
		}
		return result;
	}
	public int insert(productDTO product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = dbu.getConnection();
			String sql ="insert into tproduct value(?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPcode());
			pstmt.setString(2, product.getPname());
			pstmt.setInt(3, product.getPquantity());

			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbu.close(conn, pstmt);
		}
		return result;
	}
}
