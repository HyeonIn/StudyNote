package com.ssafy.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.model.dto.CommentDto;
import com.ssafy.rest.model.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class CommentController {
	@Autowired
	private CommentService service;
	
	@GetMapping("/list")
	public List<CommentDto> commentList(int bno){
		return service.selectList(bno); //gson 라이브러리로 자바스크립트 객체 형태로 만들어줘야 하지만, 스프링에서 처리함
	}
	
	@PostMapping("/write")
	public String write(@RequestBody CommentDto comment) {
		System.out.println(comment);
		if (service.insert(comment) == 1) {
			return "success";
		}
		else {
			return "fail";
		}
	}
}
