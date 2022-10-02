package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IBookDaoImpl implements IBookDao{ // Data Access Object = DAO
	public int insert(Book book) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		DBUtil dbu = DBUtil.getInstance();
		try {
			conn = dbu.getConnection();
			String sql = "insert into book_tb values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book.getNo());
			pstmt.setInt(2, book.getPrice());
			pstmt.setString(3, book.getTitle());
			pstmt.setString(4, book.getPublisher());
			pstmt.setString(5, book.getWriter());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("책 추가 오류");
		} finally {
			dbu.close(conn, pstmt);
		}
		
		return result;
	};
	public int delete(int no) {
		//delete from book_tb where no = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		DBUtil dbu = DBUtil.getInstance();
		try {
			conn = dbu.getConnection();
			String sql = "delete from book_tb where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("책 삭제 오류");
		} finally {
			dbu.close(conn, pstmt);
		}
		
		return result;
	};
	
	public Book selectOne(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Book result = null;
		ResultSet rs = null;
		DBUtil dbu = DBUtil.getInstance();
		try {
			conn = dbu.getConnection();
			String sql = "select * from book_tb where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Book b = new Book();
				b.setNo(rs.getInt(1));
				b.setPrice(rs.getInt(2));
				b.setTitle(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setWriter(rs.getString(5));
				result = b;
			}
		} catch (Exception e) {
			System.out.println("책 검색 오류");
		} finally {
			dbu.close(rs, conn, pstmt);
		}
		
		return result;
	}
	public List<Book> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<Book> result = new ArrayList<Book>();
		ResultSet rs = null;
		DBUtil dbu = DBUtil.getInstance();
		try {
			conn = dbu.getConnection();
			String sql = "select no, price, title, writer, publisher from book_tb";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setNo(rs.getInt(1));
				b.setPrice(rs.getInt(2));
				b.setTitle(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setWriter(rs.getString(5));
				result.add(b);
			}
		} catch (Exception e) {
			System.out.println("책 목록 오류");
			e.printStackTrace();
		} finally {
			dbu.close(rs, conn, pstmt);
		}
		
		return result;
	}
}
