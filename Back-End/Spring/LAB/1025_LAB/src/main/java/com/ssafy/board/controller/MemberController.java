package com.ssafy.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.model.dto.MemberDto;
import com.ssafy.board.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/login")
	public String list(String userId, String userPw, Model model, HttpSession session) {
		MemberDto loginInfo = memberService.login(userId, userPw);
		if (loginInfo != null) {
			session.setAttribute("loginInfo", loginInfo);
			model.addAttribute("msg", "로그인 성공");
		}
		else {
			model.addAttribute("msg", "로그인 실패, ID 또는 PW를 확인하세요");			
		}
		return "Result";
	}
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		model.addAttribute("msg", "로그아웃 완료");
		return "Result";
	}
}
