package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComentDao {
	public int insert(ComentDTO coment) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtil.makeConnection();
			String sql = "insert into coment_tb(bno, cwriter, ccontent) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, coment.getBno());
			pstmt.setString(2, coment.getCwriter());
			pstmt.setString(3, coment.getCcontent());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Comment insert err");
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt);
		}
		return result;
	}
	
	public List<ComentDTO> selectComentList(int bno){
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<ComentDTO> result = new ArrayList<>();
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();
			
			String sql = "select * from coment_tb where bno=? order by cno desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ComentDTO c = new ComentDTO();
				c.setCno(rs.getInt(1));
				c.setBno(rs.getInt(2));
				c.setCwriter(rs.getString(3));
				c.setCcontent(rs.getString(4));
				
				result.add(c);
			}
			return result;
		}catch (Exception ex) {
			System.out.println("select List error");
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	public int delete(int cno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();
			
			String sql = "delete from coment_tb where cno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			
			result = pstmt.executeUpdate();
			
		}catch (Exception ex) {
			System.out.println("coment delete error");
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return result;
	}
}
