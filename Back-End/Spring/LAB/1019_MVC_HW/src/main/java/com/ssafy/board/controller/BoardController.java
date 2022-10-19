package com.ssafy.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;

@Controller
@RequestMapping("/notice")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
		List<BoardDto> list = boardService.listArticle(map);
		
		System.out.println("게시판 목록 요청 들어옴, 서비스 실행 결과 : "+ list);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("articles", list);
		mv.addObject("pgno", map.get("pgno"));
		mv.addObject("key", map.get("key"));
		mv.addObject("word", map.get("word"));
		mv.setViewName("notice/list");
		return mv;
	}
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write() {
		return "notice/write";
	}
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(BoardDto dto) throws Exception {
		System.out.println(dto);
		boardService.writeArticle(dto);
		
		return "redirect:/notice/list?pgno=1&key=&word=";
	}
	@RequestMapping(value = "view", method=RequestMethod.GET)
	public ModelAndView view(@RequestParam String articleNo) throws NumberFormatException, Exception {
		System.out.println(articleNo);
		BoardDto dto = boardService.getArticle(Integer.parseInt(articleNo));
		ModelAndView mv = new ModelAndView();
		mv.addObject("article", dto);
		mv.setViewName("notice/view");
		return mv;
	}
}
