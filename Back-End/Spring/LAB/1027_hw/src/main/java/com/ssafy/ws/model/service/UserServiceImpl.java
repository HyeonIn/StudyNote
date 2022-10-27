package com.ssafy.ws.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.UserDao;
import com.ssafy.ws.model.dto.User;

/**
 * 빈으로 등록될 수 있도록 @Service를 선언한다.
 *
 */
@Service
public class UserServiceImpl implements UserService {
	/**
	 * has a 관계로 사용할 UserDao 타입의 dao를 선언한다.
	 */
	private UserDao dao;
	
	/**
	 * 생성자를 통해 UserDao를 주입받는다.
	 * UserDao 타입의 빈을 주입받기 위해 @Autowired를 사용한다.
	 * @param dao
	 */
	@Autowired
	public UserServiceImpl(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public User select(String id) {
		return null;
	}

}
