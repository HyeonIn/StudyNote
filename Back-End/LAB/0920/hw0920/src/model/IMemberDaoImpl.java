package model;

import java.sql.*;

public class IMemberDaoImpl {
	public int insert(Member member){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		DBUtil dbu = DBUtil.getInstance();
		try {
			conn = dbu.getConnection();
			String sql = "insert into member_tb values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getEmail());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("회원가입 오류");
		} finally {
			dbu.close(conn, pstmt);
		}
		
		return result;
	} // 회원가입
	public Member selectOne(String id, String pw){
		Connection conn = null;
		PreparedStatement pstmt = null;
		Member result = null;
		ResultSet rs = null;
		DBUtil dbu = DBUtil.getInstance();
		try {
			conn = dbu.getConnection();
			String sql = "select * from member_tb where id=? and password=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Member m = new Member();
				m.setId(rs.getString(1));
				m.setName(rs.getString(2));
				m.setPassword(rs.getString(3));
				m.setPhone(rs.getString(4));
				m.setEmail(rs.getString(5));
				result = m;
			}
		} catch (Exception e) {
			System.out.println("회원가입 오류");
		} finally {
			dbu.close(conn, pstmt);
		}
		
		return result;// 로그인
	}
}
