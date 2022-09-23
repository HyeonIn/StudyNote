package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.ProductDTO;
import model.dto.UserDTO;
import util.DBUtil;

public class ProductDao {
	private DBUtil dbu = DBUtil.getUtil();
	
	private ProductDao() {}
	private static ProductDao instance = new ProductDao();
	public static ProductDao getInstance(){
		return instance;
	}
	
	public int insert(ProductDTO product){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = dbu.getConnection();
			String sql = "insert into tproduct value(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, product.getPcode());
			pstmt.setString(2, product.getPname());
			pstmt.setInt(3, product.getPquantity());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("상품 등록 에러");
			e.printStackTrace();
			
		} finally {
			dbu.close(conn,pstmt);
		}
		return result;
	}
	public List<ProductDTO> selectAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<ProductDTO> result = new ArrayList<>();
		ResultSet rs = null;
		try {
			conn = dbu.getConnection();
			String sql = "select * from tproduct";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ProductDTO p = new ProductDTO();
				p.setPcode(rs.getString(1));
				p.setPname(rs.getString(2));
				p.setPquantity(rs.getInt(3));
				result.add(p);
			}
			
		} catch (Exception e) {
			System.out.println("상품 목록 에러");
			e.printStackTrace();
		} finally {
			dbu.close(conn, rs, pstmt);
		}
		return result;
	}
	public ProductDTO selectOne(String pcode){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ProductDTO result =null;
		ResultSet rs = null;
		try {
			conn = dbu.getConnection();
			String sql = "select * from tproduct where pcode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pcode);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ProductDTO p = new ProductDTO();
				p.setPcode(rs.getString(1));
				p.setPname(rs.getString(2));
				p.setPquantity(rs.getInt(3));
				result = p;
			}
			
		} catch (Exception e) {
			System.out.println("상품 검색 에러");
			e.printStackTrace();
		} finally {
			dbu.close(conn, rs, pstmt);
		}
		return result;
	}
	
}
