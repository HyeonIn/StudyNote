package com.ssafy.sample.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.Player;

public interface PlayerDao {
	int insert(Player player) throws SQLException;
	int delete(int pid);
	Player selectOne(int pid);
	List<Player> selectAll();
}
