package com.ssafy.sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.sample.dto.User;
import com.ssafy.sample.model.service.LoginService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private LoginService service = LoginService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if ("logout".equals(action)) {
			HttpSession session = req.getSession();
			session.invalidate();
			req.setAttribute("msg", "로그아웃 되었습니다.");
			req.getRequestDispatcher("product/result.jsp").forward(req, resp);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("loginCheck".equals(action)) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");	
			User user = service.check(id, pw);
			
			if (user != null) {
				HttpSession	session = request.getSession();
				session.setAttribute("id", id); // 로그인 성공 시점에 기록 
				
				System.out.println("로그인 성공");
				request.setAttribute("msg", "로그인 성공");
				request.getRequestDispatcher("product/result.jsp").forward(request, response);
			}
			else {
				HttpSession session = request.getSession();
				session.invalidate(); //기존 세션 객체를 통으로 삭제
				System.out.println("로그인 실패");
				request.setAttribute("msg", "로그인 실패");
				request.getRequestDispatcher("product/result.jsp").forward(request, response);
			}
		}
	}

}
