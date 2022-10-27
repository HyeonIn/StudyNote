package com.ssafy.ws.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.ws.model.dto.Book;

@Mapper
public interface BookMapper {

	int insert(Book book) throws SQLException;

	int update(Book book) throws SQLException;

	int delete(String isbn) throws SQLException;
	
	Book select(String isbn) throws SQLException;
	
	List<Book> search() throws SQLException;
}
