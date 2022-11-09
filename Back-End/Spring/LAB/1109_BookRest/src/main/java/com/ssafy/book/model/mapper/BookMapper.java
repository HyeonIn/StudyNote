package com.ssafy.book.model.mapper;

import java.util.List;

import com.ssafy.book.model.BookDto;

public interface BookMapper {

	List<BookDto> list();

	BookDto search(String isbn);

	int create(BookDto bookDto);

	int modify(BookDto bookDto);

	void deleteComment(String isbn);
	int delete(String isbn);
	
}
