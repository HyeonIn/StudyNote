package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.IMemberDaoImpl;
import model.Member;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	IMemberDaoImpl mgr = new IMemberDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if ("logout".equals(action)) {
			HttpSession session = req.getSession();
			session.invalidate(); //기존 세션 객체를 통으로 삭제
			req.getRequestDispatcher("logout.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");	
		Member member = mgr.selectOne(userid, userpw);
		
		if (member != null) {
			HttpSession	session = req.getSession();
			session.setAttribute("loginInfo", member); // 로그인 성공 시점에 기록 
			
			System.out.println("로그인 성공");
			req.getRequestDispatcher("loginSuccess.jsp").forward(req, resp);
		}
		else {
			HttpSession session = req.getSession();
			session.invalidate(); //기존 세션 객체를 통으로 삭제
			System.out.println("로그인 실패");
			req.getRequestDispatcher("loginFail.jsp").forward(req, resp);
		}
	}

}
