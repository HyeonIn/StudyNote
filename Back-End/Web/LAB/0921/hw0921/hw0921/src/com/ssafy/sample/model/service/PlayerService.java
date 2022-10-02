package com.ssafy.sample.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.Player;
import com.ssafy.sample.model.dao.PlayerDaoImpl;

public class PlayerService {
	private PlayerDaoImpl mgr = PlayerDaoImpl.getInstance();
	private PlayerService() {}
	private static PlayerService instance = new PlayerService();
	public static PlayerService getInstance() {
		return instance;
	}
	
	public boolean insert(Player player) throws SQLException {
		if (mgr.insert(player) == 1) {
			return true;
		}
		return false;
	}
	public List<Player> selectAll(){
		return mgr.selectAll();
	}
	public Player selectOne(int pid) {
		return mgr.selectOne(pid);
	}
	public boolean delete(int pid){
		if (mgr.delete(pid) == 1) {
			return true;
		}
		return false;
	}
}
