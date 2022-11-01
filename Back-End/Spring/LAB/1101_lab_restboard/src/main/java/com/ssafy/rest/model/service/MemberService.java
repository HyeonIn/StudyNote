package com.ssafy.rest.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.rest.model.dao.MemberMapper;
import com.ssafy.rest.model.dto.MemberDto;

@Service
public class MemberService {
	@Autowired
	private MemberMapper dao;
	
	public MemberDto login(String id, String pw) {
		return dao.selectOne(id, pw);
	}
}
