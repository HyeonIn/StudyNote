package com.ssafy.test.model.service;

import com.ssafy.test.model.dao.memberDao;
import com.ssafy.test.model.dto.memberDTO;

public class memberService {
	private memberDao mgr = new memberDao();
	
	private memberService() {}
	private static memberService instance = new memberService();
	public static memberService getInst() {
		return instance;
	}
	
	public memberDTO login(String mid, String mpass) {
		return mgr.select(mid, mpass);
	}
}
