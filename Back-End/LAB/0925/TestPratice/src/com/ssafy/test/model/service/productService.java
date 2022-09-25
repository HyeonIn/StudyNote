package com.ssafy.test.model.service;

import java.util.List;

import com.ssafy.test.model.dao.productDao;
import com.ssafy.test.model.dto.productDTO;

public class productService {
	private productDao mgr = new productDao();
	
	private productService() {}
	private static productService instance = new productService();
	public static productService getInst() {
		return instance;
	}
	
	public List<productDTO> selectAll() {
		return mgr.selectAll();
	}
	public boolean insert(productDTO product) {
		if (mgr.insert(product) == 1) {
			return true;
		}
		return false;
	}
	public productDTO selectOne(String pcode) {
		return mgr.selectOne(pcode);
	}
}
