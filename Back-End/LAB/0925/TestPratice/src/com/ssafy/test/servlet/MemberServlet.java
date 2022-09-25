package com.ssafy.test.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.test.model.dto.memberDTO;
import com.ssafy.test.model.service.memberService;

@WebServlet("/user")
public class MemberServlet extends HttpServlet {
	private memberService service = memberService.getInst();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("act");
		if ("logout".equals(action)) {
			HttpSession session = request.getSession();
			session.invalidate();
			request.setAttribute("msg","로그아웃 되었습니다.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("act");
		
		if ("login".equals(action)) {
			String mid = request.getParameter("id");
			String mpass = request.getParameter("pass");
			memberDTO user = service.login(mid, mpass);
			if (user == null) {
				request.setAttribute("msg", "로그인 실패");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", user);
				request.setAttribute("msg", user.getMname()+"님 환엽합니다.");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
	}

}
