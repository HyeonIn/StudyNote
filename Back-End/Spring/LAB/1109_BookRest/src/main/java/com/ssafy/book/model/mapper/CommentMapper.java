package com.ssafy.book.model.mapper;

import java.util.List;

import com.ssafy.book.model.CommentDto;

public interface CommentMapper {

	List<CommentDto> list(String isbn);

	int create(CommentDto commentDto);

	int modify(CommentDto commentDto);

	int delete(int commentNo);
	
}
