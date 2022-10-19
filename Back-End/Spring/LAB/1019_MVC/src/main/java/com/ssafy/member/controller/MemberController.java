package com.ssafy.member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@Controller
@RequestMapping("/member") // http://localhost8080/board/member
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/login")
	public String login() {
		return "user/login"; // WEB-INF/views/(user/login).jsp
	}

	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session) throws Exception {
		// memberService.loginMember(map);
		MemberDto result = memberService.loginMember(map);
		System.out.println(map);
		if (result == null) { // 로그인 실패
			model.addAttribute("msg", "아이디 또는 비밀번호 확인하세요");
			return "user/login";
		} else { // login success
			session.setAttribute("userInfo", result);
			return "redirect:/"; // 인덱스로 가세요
		}

	}
}
