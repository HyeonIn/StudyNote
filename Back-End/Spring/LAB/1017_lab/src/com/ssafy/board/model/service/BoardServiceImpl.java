package com.ssafy.board.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.util.SizeConstant;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		super();
		this.boardDao = boardDao;
	}

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
