package com.ssafy.board;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;

public class BoardTest extends UnitTestConfig {

	private final Logger logger = LoggerFactory.getLogger(BoardTest.class);
	
	@Autowired
	private BoardService boardService;
	
	@Test
	public void listTest() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("pgno", "1");
		map.put("key", "");
		map.put("word", "");
		List<BoardDto> list = boardService.listArticle(map);
		assertEquals(10, list.size());
		logger.debug("list : {}", list);
		logger.debug("list size : {}", list.size());
	}
	
	@Test
//	@Ignore
	public void modifyTest() throws Exception {
		BoardDto boardDto = new BoardDto();
		boardDto.setArticleNo(1);
		boardDto.setSubject("제목 수정해요!!!!");
		boardDto.setContent("내용도 수정해요!!!");
		boardService.modifyArticle(boardDto);		
	}

	
}