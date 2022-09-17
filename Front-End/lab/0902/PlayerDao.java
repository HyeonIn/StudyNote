package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao {
	public PlayerDao() {
		//DB 접속 전 1회 드라이버 로드 작업 필요
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int insert(Player player) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String url = "jdbc:mysql://localhost/soccer";
			conn = DriverManager.getConnection(url, "ssafy", "ssafy");
			
			String sql = " INSERT INTO "
					+ " PLAYER(ID, NAME, BACKNUMBER, TEAM) "
					+ " VALUES(?,?,?,?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  player.getId());
			pstmt.setString(2,  player.getName());
			pstmt.setInt(3,  player.getBacknumber());
			pstmt.setString(4,  player.getTeam());
			result = pstmt.executeUpdate();
			
		}catch (SQLException e) {

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
	public int delete(int id) {
		return id;
		
	}
	public int update(Player player) {
		Connection conn = null;

		PreparedStatement pstmt = null;

		int result = 0;

		
		try {

			//	1. 커넥션 생성

			String url = "jdbc:mysql://localhost/soccer";

			conn = DriverManager.getConnection(url, "ssafy", "ssafy");

			
			//	2. SQL명령어 작성(미완성 명령어상태)

			String sql = 

					  " UPDATE PLAYER SET "

					  + "NAME=?, BACKNUMBER=?, TEAM=? "

					 +" WHERE ID=?";

			//	3. PreparedStatement 객체에 담아야 됨(예전에는 그냥 Statement를 쓰기도 했었음.)

			pstmt = conn.prepareStatement(sql);

			//	4. 미완성 된 부분을 채움(?들을 채움. 채울필요 없을때도 있음.)

			pstmt.setString(1, player.getName()); 

			pstmt.setInt(2, player.getBacknumber()); 

			pstmt.setString(3, player.getTeam()); 

			pstmt.setInt(4, player.getId());

			//	5. SQL실행

			//	 (1)executeUpdate : int > insert, update, delete

			result = pstmt.executeUpdate();

			//	 (2)executeQuery : ResultSet > select

			//	6. 결과값 확인(int는 간단하지만 ResultSet은 파싱같은걸 해야함.)


		} catch (SQLException e) {

			System.out.println("Update 에러");

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
	public Player selectOne(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Player result = null;
		try {
			String url = "jdbc:mysql://localhost/soccer";
			conn = DriverManager.getConnection(url, "ssafy", "ssafy");
			
			String sql = " SELECT ID, NAME, BACKNUMBER, TEAM "
					+ " FROM PLAYER "
					+ " WHERE ID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new Player();
				result.setId(rs.getInt(1));
				result.setName(rs.getString(2));
				result.setBacknumber(rs.getInt(3));
				result.setTeam(rs.getString(4));
			}			
		}catch (SQLException e) {
			System.out.println("selectOne 에러");
			e.printStackTrace();
		}finally {
			if (rs != null) {
				
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return result;
	}
	public List<Player> selectAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Player> result = new ArrayList<>();
		try {
			String url = "jdbc:mysql://localhost/soccer";
			conn = DriverManager.getConnection(url, "ssafy", "ssafy");
			
			String sql = " SELECT ID, NAME, BACKNUMBER, TEAM "
					+ " FROM PLAYER ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Player b = new Player();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setBacknumber(rs.getInt(3));
				b.setTeam(rs.getString(4));
				result.add(b);
			}
			
		}catch (SQLException e) {
			System.out.println("selectAll 에러");
			e.printStackTrace();
		}finally {
			if (rs != null) {
				
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return result;
	}
}
