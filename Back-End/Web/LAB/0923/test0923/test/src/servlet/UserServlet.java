package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.UserDTO;
import model.service.UserService;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	
	private UserService service = UserService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if ("logout".equals(action)) {
			req.setAttribute("msg", "로그아웃 성공");
			HttpSession session = req.getSession();
			session.invalidate();
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("act");
		if ("login".equals(action)) {
			String mid = request.getParameter("id");
			String mpass = request.getParameter("pass");
			
			UserDTO user = service.login(mid, mpass);
			if (user == null) {
				request.setAttribute("msg", "id 또는 password를 확인하세요!!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", user);
				request.setAttribute("msg", "로그인 성공, 반갑습니다. "+user.getMname()+"님!");
				
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}

}
