package com.ssafy.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/") //contextPath = http://localhost:8080/board/
	public String index() {
		return "index"; //viewResolver한테 보내는 뷰이름, /WEB-INF/views/(뷰이름).jsp
	}
}
