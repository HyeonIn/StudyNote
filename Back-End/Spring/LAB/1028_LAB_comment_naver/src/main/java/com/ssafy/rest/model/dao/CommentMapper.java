package com.ssafy.rest.model.dao;

import java.util.List;

import com.ssafy.rest.model.dto.CommentDto;

public interface CommentMapper {
	public int insert(CommentDto comment);
	public List<CommentDto> selectList(int bno);
}
