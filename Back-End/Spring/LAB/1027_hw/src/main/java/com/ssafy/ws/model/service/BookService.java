package com.ssafy.ws.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.SearchCondition;

public interface BookService {
	int update(Book book, MultipartFile file) throws IllegalStateException, IOException;

	int delete(String isbn);

	Book select(String isbn);

	Map<String, Object> pagingSearch(SearchCondition condition);

	void insert(Book book) throws Exception;

	List<Book> search() throws Exception;
}
