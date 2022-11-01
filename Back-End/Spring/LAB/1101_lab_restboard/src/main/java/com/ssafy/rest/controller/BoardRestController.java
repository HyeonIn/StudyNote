package com.ssafy.rest.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.rest.model.dto.BoardDto;
import com.ssafy.rest.model.dto.FileDto;
import com.ssafy.rest.model.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardRestController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping
	public ResponseEntity<?> list(@RequestParam(value="page", defaultValue = "1") int page) {
		return new ResponseEntity<Map<String, Object>>(boardService.makePage(page), HttpStatus.ACCEPTED);
	}
	@GetMapping("/{bno}")
	public ResponseEntity<?> read(@PathVariable("bno") int bno){
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("board", boardService.read(bno));
		data.put("fileList", boardService.selectFile(bno));
		return new ResponseEntity<Map<String, Object>>(data, HttpStatus.ACCEPTED);
	}
	@PostMapping
	public ResponseEntity<String> write(BoardDto board, MultipartFile[] uploadFile) throws IllegalStateException, IOException {		
		boolean writeResult = boardService.write(board); // 글이 먼저 DB에 들어가야 글번호 업로드 가능
	//////////////////////////////////////////////////////////////////////////////////////
		/* File Upload */
		if(uploadFile != null && uploadFile.length > 0) {
			String uploadPath = "c:/SSAFY/upload";
			File uploadDir = new File(uploadPath);

			if(!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			
			for(MultipartFile file : uploadFile) {
				String savedName = new Random().nextInt(100000000)+ "";
				File savedFile = new File(uploadPath + "/" + "file"+ savedName);
				file.transferTo(savedFile);
				
				FileDto dto = new FileDto(board.getBno(), file.getOriginalFilename(), savedFile.getAbsolutePath());
				boardService.uploadFile(dto);
			}
		}
		
		if(writeResult) {
			return new ResponseEntity<String>("success", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
