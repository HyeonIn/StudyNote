package com.ssafy.sample.model.dao;

import java.sql.SQLException;

import com.ssafy.sample.dto.User;

public interface UserDao {
	int insert(User user) throws SQLException;
	User select(String id, String pw);
}
