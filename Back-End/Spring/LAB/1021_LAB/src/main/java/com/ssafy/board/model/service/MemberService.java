package com.ssafy.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.MemberMapper;
import com.ssafy.board.model.dto.MemberDto;

@Service
public class MemberService {
	@Autowired
	private MemberMapper dao;
	
	public MemberDto login(String id, String pw) {
		return dao.selectOne(id, pw);
	}
}
