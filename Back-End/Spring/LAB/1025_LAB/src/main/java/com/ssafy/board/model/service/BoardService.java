package com.ssafy.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.board.model.dao.BoardMapper;
import com.ssafy.board.model.dao.FileMapper;
import com.ssafy.board.model.dto.BoardDto;
import com.ssafy.board.model.dto.FileDto;
import com.ssafy.board.model.dto.MemberDto;

@Repository
public class BoardService {
	private static final int COUNT_PER_PAGE = 10;
	
	@Autowired
	private BoardMapper dao;
	@Autowired
	private FileMapper fdao;
	
	public Map<String, Object> makePage(int page){
		Map<String, Object> pageMap = new HashMap<>();
		
		pageMap.put("currPage", page);
		
		int totalCount = dao.selectTotalCount();
		int totalPage = totalCount/COUNT_PER_PAGE; // 한 페이지당 보여줄 글의 갯수
		if(totalCount%COUNT_PER_PAGE>0)
			totalPage++;
		
		int startPage = (page-1)/COUNT_PER_PAGE*COUNT_PER_PAGE+1; // 1~10은 시작페이지1, 11~20은 시작페이지 11
		int endPage = startPage+9; // 화면하단 끝 페이지는 시작페이지 +9
		if(endPage>totalPage) // 혹시 총 게시글 자체가 적은 경우 끝 페이지 줄이기.
			endPage = totalPage;
		
		pageMap.put("totalPage", totalPage);
		pageMap.put("startPage", startPage);
		pageMap.put("endPage", endPage);
		
		int startRow = (page-1)*COUNT_PER_PAGE;
		
		pageMap.put("boardList", dao.selectList(startRow, COUNT_PER_PAGE));
		return pageMap;
	}
	public boolean write(BoardDto board) {
		if (board == null || board.getTitle() == null || board.getTitle().length() == 0|| board.getWriter() == null || board.getWriter().length() == 0) {
			return false;
		}
		if(dao.insert(board)==1)
			return true;
		return false;
	}

	public BoardDto read(int bno, MemberDto loginInfo, boolean modify) {
		BoardDto result = dao.selectOne(bno); // 일단 해당 번호의 게시글을 조회해보고
		if(!result.getWriter().equals(loginInfo.getName()) && !modify ) { // 있는 게시글이면 조회수 증가.
			dao.updateReadCount(bno);
		}
		
		return result;
	}
	public boolean update(BoardDto board) {
		if (board == null || board.getTitle() == null || board.getTitle().length() == 0|| board.getWriter() == null || board.getWriter().length() == 0) {
			return false;
		}
		if (dao.update(board) == 1) {
			return true;
		}
		return false;
	}
	public boolean delete(int bno) {
		if (dao.delete(bno) == 1) {
			return true;
		}
		return false;
	}
	public int uploadFile(FileDto file) {
		return fdao.insert(file);
	}
	public List<FileDto> selectFile(int bno){
		return fdao.selectFiles(bno);
	}
	public FileDto getFile(int fno) {
		return fdao.selectOne(fno);
	}
}
