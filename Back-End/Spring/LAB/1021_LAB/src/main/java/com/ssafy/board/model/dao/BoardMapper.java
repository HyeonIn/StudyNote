package com.ssafy.board.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssafy.board.model.dto.BoardDto;

@Repository
public interface BoardMapper {
	public int insert(BoardDto board);
	public List<BoardDto> selectList(@Param("start")int startRow, @Param("cnt")int count);
	public int selectTotalCount();
	public BoardDto selectOne(int bno);
	public int updateReadCount(int bno);
	public int update(BoardDto board);
	public int delete(int bno);
}
