package com.ssafy.rest.model.dao;

import java.util.List;

import com.ssafy.rest.model.dto.CommentDTO;

public interface CommentMapper {
	public int insert(CommentDTO comment);
	public List<CommentDTO> selectList(int bno);
}

