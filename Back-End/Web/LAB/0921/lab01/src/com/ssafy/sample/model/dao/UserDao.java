package com.ssafy.sample.model.dao;

import com.ssafy.sample.dto.User;

public interface UserDao {
	User selectOne(String id, String pw);
}
