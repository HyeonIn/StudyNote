package com.ssafy.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {
	
	@GetMapping("/boardList")
	public String boardList() {
		return "list";
	}
	@GetMapping("/boardWrite")
	public String boardWrite() {
		return "write";
	}
	@GetMapping("/boardRead/{bno}")
	public String boardRead(@PathVariable("bno") int bno, Model model) {
		model.addAttribute("bno", bno);

		return "read";
	}
}
