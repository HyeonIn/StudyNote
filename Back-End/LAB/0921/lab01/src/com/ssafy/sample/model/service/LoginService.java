package com.ssafy.sample.model.service;

import com.ssafy.sample.dto.User;
import com.ssafy.sample.model.dao.UserDaoImpl;

public class LoginService {
	private UserDaoImpl mgr = new UserDaoImpl();
	private static LoginService instance = new LoginService();
	private LoginService() {}
	public static LoginService getInstance() {
		return instance;
	}
	public User check(String id, String pw) {
		return mgr.selectOne(id, pw);
	}
}
