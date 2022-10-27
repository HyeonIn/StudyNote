package com.ssafy.ws.model.dao;

import com.ssafy.ws.model.dto.User;

public interface UserDao {
	User select(String id);
}
