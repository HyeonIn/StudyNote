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

import com.ssafy.rest.model.dto.CommentDto;
import com.ssafy.rest.model.service.CommentService;

@Controller
@RequestMapping("/comment")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class CommentController {
	@Autowired
	private CommentService service;
	
	@GetMapping("/list")
	@ResponseBody // ViewResolver한테 가지말라고 이게 그냥 다이렉트 응답이라고 말하는거래, jsp를 찾지 않고 바로 데이터만 넘기는 거지
	public List<CommentDto> commentList(int bno){
		System.out.println(bno);
		return service.selectList(bno); //gson 라이브러리로 자바스크립트 객체 형태로 만들어줘야 하지만, 스프링에서 처리함
	}
	@PostMapping("/write")
	@ResponseBody
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
