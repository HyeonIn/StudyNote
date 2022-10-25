package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.FileDto;

public interface FileMapper {
	public int insert(FileDto file);
	public List<FileDto> selectFiles(int bno);
	public FileDto selectOne(int fno);
}
