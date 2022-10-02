package com.ssafy.sample.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.ssafy.sample.dto.Player;
import com.ssafy.sample.util.DBUtil;


public class PlayerDaoImpl implements PlayerDao{
	private DBUtil dbu = DBUtil.getInstance();
	private PlayerDaoImpl() {};
	private static PlayerDaoImpl instance = new PlayerDaoImpl();
	public static PlayerDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public int insert(Player player) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = dbu.getConnection();
			String sql = "insert into `player`(name, backnumber, team) values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, player.getName());
			pstmt.setInt(2, player.getBacknumber());
			pstmt.setString(3, player.getTeam());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("선수 추가 에러");
			e.printStackTrace();
			throw e;
		} finally {
			dbu.close(conn, pstmt);
		}
		
		return result;
	}

	@Override
	public int delete(int pid){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = dbu.getConnection();
			String sql = "delete from `player` where pid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("선수 삭제 에러");
			e.printStackTrace();
		} finally {
			dbu.close(conn, pstmt);
		}
		
		return result;
	}

	@Override
	public Player selectOne(int pid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Player result = null;
		ResultSet rs = null;
		try {
			conn = dbu.getConnection();
			String sql = "select * from `player` where pid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Player p = new Player();
				p.setPid(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setBacknumber(rs.getInt(3));
				p.setTeam(rs.getString(4));
				result = p;
			}
			
		} catch (Exception e) {
			System.out.println("선수 검색 에러");
			e.printStackTrace();
		} finally {
			dbu.close(conn, pstmt, rs);
		}
		
		return result;
	}

	@Override
	public List<Player> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<Player> result = new ArrayList<>();
		ResultSet rs = null;
		try {
			conn = dbu.getConnection();
			String sql = "select * from `player` order by pid";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Player p = new Player();
				p.setPid(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setBacknumber(rs.getInt(3));
				p.setTeam(rs.getString(4));
				result.add(p);
			}
			
		} catch (Exception e) {
			System.out.println("선수 전체 검색 에러");
			e.printStackTrace();
		} finally {
			dbu.close(conn, pstmt, rs);
		}
		
		return result;
	}

}
