package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.board.model.BoardDto;

public interface BoardDao {

	int writeArticle(BoardDto boardDto) throws SQLException;
	List<BoardDto> listArticle(Map<String, String> map) throws SQLException;
	int totalArticleCount(Map<String, String> map) throws SQLException;
	BoardDto getArticle(int articleNo) throws SQLException;
	void updateHit(int articleNo) throws SQLException;
	void modifyArticle(BoardDto boardDto) throws SQLException;
	void deleteArticle(int articleNo) throws SQLException;
	
}
