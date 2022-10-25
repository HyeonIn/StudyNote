package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.CommentDto;

public interface CommentMapper {
	public int insert(CommentDto comment);
	public List<CommentDto> selectList(int bno);
}
