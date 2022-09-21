package com.ssafy.sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.sample.dto.Player;
import com.ssafy.sample.model.service.PlayerService;

@WebServlet("/player")
public class PlayerServlet extends HttpServlet {
	private PlayerService service = PlayerService.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("add".equals(action)) {			
			request.getRequestDispatcher("player/regist.jsp").forward(request, response);;
		}
		else if ("list".equals(action)) {
			request.setAttribute("playerList", service.selectAll());
			request.getRequestDispatcher("player/list.jsp").forward(request, response);
		}
		else if ("detail".equals(action)) {
			Player player = service.selectOne(Integer.parseInt(request.getParameter("pid")));
			request.setAttribute("detailPlayer", player);
			request.getRequestDispatcher("player/detail.jsp").forward(request, response);
		}
		else if ("delete".equals(action)) {
			service.delete(Integer.parseInt(request.getParameter("pid")));
			request.setAttribute("msg", "선수 삭제 성공");
			request.getRequestDispatcher("player/result.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		try {
			if ("add".equals(action)) {
				String name = request.getParameter("name");
				int backnumber = Integer.parseInt(request.getParameter("backnumber"));
				String team = request.getParameter("team");
				Player player = new Player(name, backnumber, team);
				
				service.insert(player);
				request.setAttribute("msg", "선수 등록 성공");
				request.getRequestDispatcher("player/result.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}

}
