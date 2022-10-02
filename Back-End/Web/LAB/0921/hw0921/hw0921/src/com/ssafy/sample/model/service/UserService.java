package com.ssafy.sample.model.service;

import java.sql.SQLException;

import com.ssafy.sample.dto.User;
import com.ssafy.sample.model.dao.UserDaoImpl;

public class UserService {
	private UserDaoImpl mgr = UserDaoImpl.getInstance();
	private static UserService instance = new UserService();
	private UserService() {}
	public static UserService getInstance() {
		return instance;
	}
	
	public User Login(String id, String pw) {
		return mgr.select(id, pw);
	}
	public boolean Register(User user) throws SQLException{
		if (mgr.insert(user) == 1) {
			return true;
		}
		return false;
	}
	
}
