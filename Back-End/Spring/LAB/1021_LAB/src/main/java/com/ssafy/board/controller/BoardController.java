package com.ssafy.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.model.dto.BoardDto;
import com.ssafy.board.model.dto.MemberDto;
import com.ssafy.board.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public ModelAndView list(@RequestParam(value="page", defaultValue="1")int page) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("list");
		mv.addObject("boardPage", boardService.makePage(page));
		
		return mv;
	}
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	@PostMapping("/write")
	public String write(BoardDto board, HttpSession session) {
		MemberDto loginInfo = (MemberDto) session.getAttribute("loginInfo");
		board.setWriter(loginInfo.getName());
		if (boardService.write(board)) {
			return "WriteSuccess";
		}else {
			return "WriteFail";
		}
	}
	
	@GetMapping("/read")
	public ModelAndView read(int bno, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		MemberDto loginInfo = (MemberDto) session.getAttribute("loginInfo");
		BoardDto board = boardService.read(bno, loginInfo, false);
		if (board == null) {
			mv.addObject("msg", "해당 게시글은 이미 삭제되었거나 존재하지 않는 게시물입니다.");
			mv.setViewName("Result");
			return mv;
		}
		
		mv.addObject("board", board);
		mv.setViewName("Read");
		return mv;
	}
	@GetMapping("/update")
	public ModelAndView update(int bno, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		MemberDto loginInfo = (MemberDto) session.getAttribute("loginInfo");
		BoardDto board = boardService.read(bno, loginInfo, true);
		System.out.println(loginInfo.getName() + "   " + board.getWriter());
		if (!loginInfo.getName().equals(board.getWriter())) {
			mv.addObject("msg", "수정이 불가한 글입니다.");
			mv.setViewName("Result");
		}else {
			mv.addObject("board", board);
			mv.setViewName("update");
		}
		return mv;
	}
	@PostMapping("/update")
	public ModelAndView update(BoardDto board) {
		ModelAndView mv = new ModelAndView();
		System.out.println(board);
		if (boardService.update(board)) {
			mv.addObject("msg", "수정 성공!");
			mv.setViewName("Result");
		}
		else {
			mv.addObject("msg", "수정 실패!");
			mv.setViewName("Result");
		}
		return mv;
	}
	@GetMapping("/delete")
	public ModelAndView delete(int bno, String writer, HttpSession session) {
		MemberDto loginInfo = (MemberDto) session.getAttribute("loginInfo");
		if (!loginInfo.getName().equals(writer)) {
			return new ModelAndView("Result", "msg", "삭제가 불가한 글입니다");
		}
		if (boardService.delete(bno)) {
			return new ModelAndView("Result", "msg", "삭제 성공!");
		}
		else {
			return new ModelAndView("Result", "msg", "삭제 실패!");
		}
				
	}
	
}
