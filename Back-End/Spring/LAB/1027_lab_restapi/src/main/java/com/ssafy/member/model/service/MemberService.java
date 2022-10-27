package com.ssafy.member.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.member.model.MemberDto;

public interface MemberService {

	int idCheck(String userId) throws Exception;
	void joinMember(MemberDto memberDto) throws Exception;
	MemberDto loginMember(Map<String, String> map) throws Exception;
	List<MemberDto> listMember(Map<String, Object> map) throws Exception;
	void deleteMember(String userId) throws Exception;
	MemberDto getMember(String userId) throws Exception;
	void modifyMember(MemberDto memberDto) throws Exception;
	
}
