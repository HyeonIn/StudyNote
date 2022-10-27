package com.ssafy.admin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<?> list() {
		try {
			return returnList();
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}

	@DeleteMapping("/user/{userid}")
	public ResponseEntity<?> list(@PathVariable("userid") String userId) {
		try {
			memberService.deleteMember(userId);
			return returnList();
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}

	@PostMapping("/user")
	public ResponseEntity<?> join(@RequestBody MemberDto memberDto) {
		try {
			memberService.joinMember(memberDto);
			return returnList();
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> modify(@RequestBody MemberDto memberDto) {
		try {
			memberService.modifyMember(memberDto);
			return returnList();
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}

	private ResponseEntity<?> returnList() throws Exception {
		List<MemberDto> list = memberService.listMember(null);
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		return new ResponseEntity<String>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@GetMapping("/user/{userid}")
	public ResponseEntity<?> userView(@PathVariable("userid") String userId) {
		try {
			MemberDto memberDto = memberService.getMember(userId);
			if (memberDto != null) {
				return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
}
