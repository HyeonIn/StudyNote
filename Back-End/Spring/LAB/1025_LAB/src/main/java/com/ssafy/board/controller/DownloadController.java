package com.ssafy.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.board.model.dto.FileDto;
import com.ssafy.board.model.service.BoardService;

@Controller
public class DownloadController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/download")
	public void download(int fno, HttpServletResponse response) throws IOException {
		FileDto file = service.getFile(fno);
		
		//filename="profile.png";
		response.setHeader("Content-Disposition", "attachment; filename=\""+file.getOriginalName()+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		File savedFile = new File(file.getSavedPath());
		FileInputStream fis = new FileInputStream(savedFile);
		OutputStream out = response.getOutputStream();
		FileCopyUtils.copy(fis, out);
		
		
	}
}
