package com.ssafy.book.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.book.model.CommentDto;
import com.ssafy.book.model.service.CommentService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/vuews/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/comment")
public class CommentRestController {

	private static final Logger logger = LoggerFactory.getLogger(CommentRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	CommentService commentService;

	@ApiOperation(value = "isbn에 해당하는 도서평 목록을 반환한다.", response = List.class)
	@GetMapping("{isbn}")
	public ResponseEntity<List<CommentDto>> listComment(@PathVariable("isbn") String isbn) {
		logger.debug("listComment - 호출");
		return new ResponseEntity<>(commentService.list(isbn), HttpStatus.OK);
	}

	@ApiOperation(value = "새로운 도서평을 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> createComment(@RequestBody CommentDto commentDto) {
		logger.debug("createComment - 호출");
		if(commentService.create(commentDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "글번호가 comment_no에 해당하는 도서평을 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyComment(@RequestBody CommentDto commentDto) {
		logger.debug("modifyComment - 호출");
		logger.debug("" + commentDto);
		System.out.println("댓글 수정하자!!!"  + commentDto);
		if(commentService.modify(commentDto)) {
			System.out.println("댓글 수정 성공!!!");
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "글번호가 comment_no에 해당하는 도서평을 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{commentNO}")
	public ResponseEntity<String> deleteBook(@PathVariable("commentNO") int commentNO) {
		logger.debug("deleteBook - 호출");
		if(commentService.delete(commentNO)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
}
