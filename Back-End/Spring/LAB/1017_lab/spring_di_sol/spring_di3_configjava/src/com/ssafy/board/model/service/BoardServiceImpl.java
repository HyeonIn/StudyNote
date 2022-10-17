package com.ssafy.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.util.SizeConstant;

@Service(value = "boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
//	생성자 Injection 권장.
//	생성자 주입방식은 아래와 같은 장점을 가진다
//	의존관계 설정이 되지 않으면 객체생성 불가 -> 컴파일 타임에 인지 가능, NPE 방지
//	의존성 주입이 필요한 필드를 final 로 선언가능 -> Immutable
//	(스프링에서) 순환참조 감지가능 -> 순환참조시 앱구동 실패
//	테스트 코드 작성 용이
	
//	필드 인젝션은 아래와 같은 장점을 가진다
//	편하다는 것 말고는 없다
	
//	private final BoardDao boardDao;
	
//	생성자가 1개만 있을 경우에 @Autowired를 생략해도 주입이 가능하도록 편의성을 제공
//	@Autowired
//	public BoardServiceImpl(BoardDao boardDao) {
//		super();
//		this.boardDao = boardDao;
//	}

	@Override
	public int writeArticle(BoardDto boardDto) throws Exception {
		return boardDao.writeArticle(boardDto);
	}

	@Override
	public List<BoardDto> listArticle(Map<String, String> map) throws Exception {
		int pgNo = Integer.parseInt(map.get("pgno"));
		int end = pgNo * SizeConstant.LIST_SIZE;
		int start = end - SizeConstant.LIST_SIZE;
		map.put("start", start + "");
		map.put("end", end + "");
		return boardDao.listArticle(map);
	}

	@Override
	public BoardDto getArticle(int articleNo) throws Exception {
		return boardDao.getArticle(articleNo);
	}

	@Override
	public void updateHit(int articleNo) throws Exception {
		boardDao.updateHit(articleNo);
	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws Exception {
		boardDao.modifyArticle(boardDto);
	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {
		boardDao.deleteArticle(articleNo);
	}

}
