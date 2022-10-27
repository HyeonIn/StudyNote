package com.ssafy.ws.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dao.BookMapper;
import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.util.PageNavigation;

/**
 * 빈으로 등록될 수 있도록 @Service를 선언한다.
 *
 */
@Service
public class BookServiceImpl implements BookService {

	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	/**
	 * has a 관계로 사용할 BookDao 타입의 dao를 선언한다.
	 */
	private BookMapper dao;


	@Override
	public void insert(Book book) throws Exception {
		dao.insert(book);
	}

	@Override
	public List<Book> search() throws Exception {
		return dao.search();
	}

	@Override
	public int update(Book book, MultipartFile file) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String isbn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Book select(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> pagingSearch(SearchCondition condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
