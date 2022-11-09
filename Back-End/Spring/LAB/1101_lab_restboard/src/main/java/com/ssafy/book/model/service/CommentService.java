package com.ssafy.book.model.service;

import java.util.List;

import com.ssafy.book.model.CommentDto;

public interface CommentService {

	List<CommentDto> list(String isbn);

	boolean create(CommentDto commentDto);

	boolean modify(CommentDto commentDto);

	boolean delete(int commentNo);
	
}
