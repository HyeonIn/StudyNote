package com.ssafy.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@GetMapping("/hello")
	public String hello(){
		return "Hi"; // /WEB-INF/views/Hi.jsp
	}
}

