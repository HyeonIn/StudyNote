package com.ssafy.rest.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.rest.model.dao.CommentMapper;
import com.ssafy.rest.model.dto.CommentDto;

@Service
public class CommentService {
	@Autowired
	private CommentMapper dao;
	
	public int insert(CommentDto comment) {
		return dao.insert(comment);
	}
	
	public List<CommentDto> selectList(int bno){
		return dao.selectList(bno);
	}
}
