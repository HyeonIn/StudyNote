package com.ssafy.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;

//보통 테스트 클래스는 대상 클래스 하나 당 테스트 클래스 하나씩 매핑해서 만듦
public class BoardServiceTest extends UnitTestConfig{
	@Autowired
	private BoardService boardService;
	
	@Test
	public void writeTest() throws Exception {
		BoardDto dto = new BoardDto();
		dto.setContent("내용");
		dto.setSubject("제목인가요?");
		dto.setUserId("ssafy");
		dto.setUserName("김싸피");
		int result = boardService.writeArticle(dto);
		assertEquals(1, result); // 실행 결과 기대값, 실제 결과 값
	}
	@Test
    public void listTest() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("pgno", "1");
        map.put("key", "");
        map.put("word", "");
        List<BoardDto> list = boardService.listArticle(map);
        assertTrue(list.size()>0);
    }

    @Test
    public void modifyTest() throws Exception {
        BoardDto boardDto = new BoardDto();
        boardDto.setArticleNo(1);
        boardDto.setSubject("제목 수정해요!!!!");
        boardDto.setContent("내용도 수정해요!!!");
        boardService.modifyArticle(boardDto);
    }
}
