package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// BookManagerImpl -> 이제 배열이 아니라 데이터베이스에 데이터 저장됨. 그 작업을 전담하는 클래스.
public class BookDao { // Data Access Object || Repository
	
	public BookDao() {
		// DB 접속 전 1회 드라이버 로드 작업 필요(최근엔 생략되기도 하는 과정.)
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 오류");
		}
	}
	
	public int insert(Book book) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			//	1. 커넥션 생성
			String url = "jdbc:mysql://182.224.88.96:3306/ssafy_8th";
			conn = DriverManager.getConnection(url, "ssafy", "ssafy");
			
			//	2. SQL명령어 작성(미완성 명령어상태)
			String sql = 
					  " INSERT INTO "
					+ " BOOK_TB(TITLE,WRITER,PUBLISHER,PRICE) "
					+ " VALUES(?,?,?,?) ";
			//	3. PreparedStatement 객체에 담아야 됨(예전에는 그냥 Statement를 쓰기도 했었음.)
			pstmt = conn.prepareStatement(sql);
			//	4. 미완성 된 부분을 채움(?들을 채움. 채울필요 없을때도 있음.)
			pstmt.setString(1, book.getTitle()); // 1번 물음표 자리에 제목 채우기:String
			pstmt.setString(2, book.getWriter()); // 2번 물음표 자리에 저자 채우기:String
			pstmt.setString(3, book.getPublisher()); // 3번 물음표 자리에 출판사 채우기:String
			pstmt.setInt(4, book.getPrice()); // 4번 물음표 자리에 가격 채우기:int
			
			//	5. SQL실행
			//	 (1)executeUpdate : int > insert, update, delete
			result = pstmt.executeUpdate();
			//	 (2)executeQuery : ResultSet > select
			//	6. 결과값 확인(int는 간단하지만 ResultSet은 파싱같은걸 해야함.)
			System.out.println("dao insert success:"+result);
		} catch (SQLException e) {
			System.out.println("insert 에러");
			e.printStackTrace(); // 이거 지우면 나중에 디버깅 죽어남.
		} finally {
			//	7. 사용한 자원 반납 close
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return result;
	}
//	
//	public int delete(int bno) {
//		
//	}
//	
	public int update(Book book) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			//	1. 커넥션 생성
			String url = "jdbc:mysql://182.224.88.96:3306/ssafy_8th";
			conn = DriverManager.getConnection(url, "ssafy", "ssafy");
			
			//	2. SQL명령어 작성(미완성 명령어상태)
			String sql = 
					  " UPDATE BOOK_TB SET "
					  + "TITLE=?, WRITER=?, PUBLISHER=?, PRICE=? "
					 +" WHERE BNO=?";
			//	3. PreparedStatement 객체에 담아야 됨(예전에는 그냥 Statement를 쓰기도 했었음.)
			pstmt = conn.prepareStatement(sql);
			//	4. 미완성 된 부분을 채움(?들을 채움. 채울필요 없을때도 있음.)
			pstmt.setString(1, book.getTitle()); // 1번 물음표 자리에 제목 채우기:String
			pstmt.setString(2, book.getWriter()); // 2번 물음표 자리에 저자 채우기:String
			pstmt.setString(3, book.getPublisher()); // 3번 물음표 자리에 출판사 채우기:String
			pstmt.setInt(4, book.getPrice()); // 4번 물음표 자리에 가격 채우기:int
			pstmt.setInt(5, book.getBno());
			//	5. SQL실행
			//	 (1)executeUpdate : int > insert, update, delete
			result = pstmt.executeUpdate();
			//	 (2)executeQuery : ResultSet > select
			//	6. 결과값 확인(int는 간단하지만 ResultSet은 파싱같은걸 해야함.)
			System.out.println("dao update success:"+result);
		} catch (SQLException e) {
			System.out.println("insert 에러");
			e.printStackTrace(); // 이거 지우면 나중에 디버깅 죽어남.
		} finally {
			//	7. 사용한 자원 반납 close
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return result;
	}
	
	public Book selectOne(int bno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book result = null;
		
		try {
			//	1. 커넥션 생성
			String url = "jdbc:mysql://182.224.88.96:3306/ssafy_8th";
			conn = DriverManager.getConnection(url, "ssafy", "ssafy");
			
			//	2. SQL명령어 작성(미완성 명령어상태)
			String sql = 
					  " SELECT BNO, TITLE, WRITER, PUBLISHER, PRICE "
					+ " FROM BOOK_TB WHERE BNO=? ";
			//	3. PreparedStatement 객체에 담아야 됨(예전에는 그냥 Statement를 쓰기도 했었음.)
			pstmt = conn.prepareStatement(sql);
			//	4. 미완성 된 부분을 채움(?들을 채움. 채울필요 없을때도 있음.)
			pstmt.setInt(1, bno);
			//	5. SQL실행
			//	 (1)executeUpdate : int > insert, update, delete
			//	 (2)executeQuery : ResultSet > select
			rs = pstmt.executeQuery();
			//	6. 결과값 확인(int는 간단하지만 ResultSet은 파싱같은걸 해야함.)
			if(rs.next()) {
				result = new Book();
				result.setBno(rs.getInt(1));
				result.setTitle(rs.getString(2));
				result.setWriter(rs.getString(3));
				result.setPublisher(rs.getString(4));
				result.setPrice(rs.getInt(5));
			}
			System.out.println("dao selectOne success:"+result);
		} catch (SQLException e) {
			System.out.println("selectOne 에러");
			e.printStackTrace(); // 이거 지우면 나중에 디버깅 죽어남.
		} finally {
			//	7. 사용한 자원 반납 close
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return result;
	}
	
	public List<Book> selectAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Book> result = new ArrayList<>();
		
		try {
			//	1. 커넥션 생성
			String url = "jdbc:mysql://182.224.88.96:3306/ssafy_8th";
			conn = DriverManager.getConnection(url, "ssafy", "ssafy");
			
			//	2. SQL명령어 작성(미완성 명령어상태)
			String sql = 
					  " SELECT BNO, TITLE, WRITER, PUBLISHER, PRICE "
					+ " FROM BOOK_TB ";
			//	3. PreparedStatement 객체에 담아야 됨(예전에는 그냥 Statement를 쓰기도 했었음.)
			pstmt = conn.prepareStatement(sql);
			//	4. 미완성 된 부분을 채움(?들을 채움. 채울필요 없을때도 있음.)
			//	5. SQL실행
			//	 (1)executeUpdate : int > insert, update, delete
			//	 (2)executeQuery : ResultSet > select
			rs = pstmt.executeQuery();
			//	6. 결과값 확인(int는 간단하지만 ResultSet은 파싱같은걸 해야함.)
			while(rs.next()) {
				Book b = new Book();
				b.setBno(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setWriter(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setPrice(rs.getInt(5));
				result.add(b); // ArrayList<Book>
			}
			System.out.println("dao selectAll success:"+result);
		} catch (SQLException e) {
			System.out.println("selectAll 에러");
			e.printStackTrace(); // 이거 지우면 나중에 디버깅 죽어남.
		} finally {
			//	7. 사용한 자원 반납 close
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return result;
	}
}
