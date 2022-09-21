package com.ssafy.sample.model.dao;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
	private DBUtil dbu = DBUtil.getInstance();
	@Override
	public int insert(Product product) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = dbu.getConnection();
			String sql = "INSERT INTO `product` VALUES (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getCode());
			pstmt.setString(2, product.getModel());
			pstmt.setInt(3, product.getPrice());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Product insert error");
			e.printStackTrace();
			throw e;
		} finally {
			dbu.close(conn, pstmt);
		}
		return result;
	}

	@Override
	public int delete(String code) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = dbu.getConnection();
			String sql = "delete from `product` where code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Product delete error");
			e.printStackTrace();
			throw e;
		} finally {
			dbu.close(conn, pstmt);
		}
		return result;
	}

	@Override
	public Product selectOne(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Product result = null;
		ResultSet rs = null;
		try {
			conn = dbu.getConnection();
			String sql = "select * from `product` where code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Product p = new Product();
				p.setCode(rs.getString(1));
				p.setModel(rs.getString(2));
				p.setPrice(rs.getInt(3));
				result = p;
			}
		} catch (Exception e) {
			System.out.println("Product select error");
			e.printStackTrace();
		} finally {
			dbu.close(conn, pstmt);
		}
		return result;
	}
	@Override
	public	List<Product> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<Product> result = new ArrayList<>();
		ResultSet rs = null;
		try {
			conn = dbu.getConnection();
			String sql = "select * from `product`";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setCode(rs.getString(1));
				p.setModel(rs.getString(2));
				p.setPrice(rs.getInt(3));
				result.add(p);
			}
		} catch (Exception e) {
			System.out.println("Product selectAll error");
			e.printStackTrace();
		} finally {
			dbu.close(conn, pstmt);
		}
		return result;
	}
	
}
