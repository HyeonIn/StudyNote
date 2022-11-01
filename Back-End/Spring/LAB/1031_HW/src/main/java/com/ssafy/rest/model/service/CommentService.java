package com.ssafy.rest.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.rest.model.dao.CommentMapper;
import com.ssafy.rest.model.dto.CommentDTO;

@Service
public class CommentService {
	@Autowired
	private CommentMapper cdao;

	public int writeComment(CommentDTO comment) {
		return cdao.insert(comment);
	}

	public List<CommentDTO> getComments(int bno) {
		return cdao.selectList(bno);
	}
}
