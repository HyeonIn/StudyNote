package com.ssafy.rest.model.dao;

import java.util.List;

import com.ssafy.rest.model.dto.FileDto;

public interface FileMapper {
	public int insert(FileDto file);
	public List<FileDto> selectFiles(int bno);
	public FileDto selectOne(int fno);
}
