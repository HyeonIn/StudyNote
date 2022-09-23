package model.service;

import model.dao.UserDao;
import model.dto.UserDTO;

public class UserService {
	private UserDao mgr = UserDao.getInstance();
	
	private UserService() {}
	private static UserService instance = new UserService();
	public static UserService getInstance() {
		return instance;
	}
	
	public UserDTO login(String mid, String mpass) {
		return mgr.select(mid, mpass);
	}
}
