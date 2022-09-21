package com.ssafy.sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.sample.dto.User;
import com.ssafy.sample.model.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UserService service = UserService.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
	
		if ("logout".equals(action)) {
			HttpSession session = request.getSession();
			session.invalidate();
			request.setAttribute("msg", "로그아웃 되었습니다");
			request.getRequestDispatcher("player/result.jsp").forward(request, response);
		}
		else if ("register".equals(action)) {
			request.getRequestDispatcher("player/register.jsp").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			if ("loginCheck".equals(action)) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				
				User user = service.Login(id, pw);
				HttpSession session = request.getSession();
				
				if (user != null) {
					session.setAttribute("id", user.getId());
					request.setAttribute("msg", "로그인 성공");
					request.getRequestDispatcher("player/result.jsp").forward(request, response);
				}
				else {
					session.invalidate();
					request.setAttribute("msg", "로그인 실패");
					request.getRequestDispatcher("player/result.jsp").forward(request, response);
				}
			}else if ("register".equals(action)) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				User user = new User(id, pw);
				service.Register(user);
				request.setAttribute("msg", "회원가입 성공");
				request.getRequestDispatcher("player/result.jsp").forward(request, response);
				
			}
		}catch (Exception e) {
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		
		
	}

}
