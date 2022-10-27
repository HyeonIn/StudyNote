package com.ssafy.admin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@RestController
@RequestMapping("/admin")
public class AdminUserController {
	
	private MemberService memberService;

	public AdminUserController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	@GetMapping("/user")
	public String list() {
		try {
			List<MemberDto> list = memberService.listMember(null);
			System.out.println(list.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "{aaa:'aaa'}";
	}
}
