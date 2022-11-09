package com.ssafy.book.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.book.model.BookDto;
import com.ssafy.book.model.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public List<BookDto> list() {
		return bookMapper.list();
	}

	@Override
	public BookDto search(String isbn) {
		return bookMapper.search(isbn);
	}

	@Override
	public boolean create(BookDto bookDto) {
		return bookMapper.create(bookDto) == 1;
	}

	@Override
	public boolean modify(BookDto bookDto) {
		return bookMapper.modify(bookDto) == 1;
	}

	@Override
	@Transactional
	public boolean delete(String isbn) {
		bookMapper.deleteComment(isbn);
		return bookMapper.delete(isbn) == 1;
	}

}
