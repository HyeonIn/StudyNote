package com.ssafy.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.model.dto.CommentDTO;
import com.ssafy.rest.model.service.CommentService;

//@Controller
@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class CommentController {
	@Autowired
	private CommentService service; // 댓글 구조가 복잡해지면 CommentService 클래스를 만들겠지..
	
	@GetMapping("/list")
//	@ResponseBody // ViewResolver한테 가지 말라고 이게 그냥 다이렉트 응답이라고. jsp 찾으러 갎 필요 없다고.
	public List<CommentDTO> commentList(int bno){
		return service.getComments(bno); // gson라이브러리로 자바스크립트 객체 형태로 만들어줘야함.
	}
	
	@PostMapping("/write")
//	@ResponseBody 
	public String write(@RequestBody CommentDTO comment) { // 프론트에서 자바스크립트 객체 json이 오는구나
		System.out.println(comment);
		if(service.writeComment(comment)==1)
			return "success"; // success.jsp 화면을 만들겠다는게 아님. 그냥 문자열 "success"를 보내고 싶은거임.
		else
			return "fail";
	}
	
}
