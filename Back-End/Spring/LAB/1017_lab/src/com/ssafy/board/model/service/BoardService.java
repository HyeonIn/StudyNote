package com.ssafy.board.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.board.model.BoardDto;

public interface BoardService {

	int writeArticle(BoardDto boardDto) throws Exception;
	List<BoardDto> listArticle(Map<String, String> map) throws Exception;
	BoardDto getArticle(int articleNo) throws Exception;
	void updateHit(int articleNo) throws Exception;
	void modifyArticle(BoardDto boardDto) throws Exception;
	void deleteArticle(int articleNo) throws Exception;
	
}
