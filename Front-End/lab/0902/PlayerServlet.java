package servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import model.Player;

import model.PlayerDao;

@WebServlet("/player")
public class PlayerServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");

		
		if("add".equals(action)) {

			req.getRequestDispatcher("Write.jsp").forward(req, resp);

		}else if("list".equals(action)) {

			req.setAttribute("playerList", new PlayerDao().selectAll());

			req.getRequestDispatcher("List.jsp").forward(req, resp);

		}

	}

	
	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		String action = req.getParameter("action");

		
		if("add".equals(action)) {  
			
			String id = req.getParameter("id");
			
			String name  = req.getParameter("name");

			String backnumber = req.getParameter("backnumber");

			String team = req.getParameter("team");

			
			Player player = new Player(Integer.parseInt(id), name, Integer.parseInt(backnumber), team);

			if(new PlayerDao().insert(player)==1) {

				req.getRequestDispatcher("WriteSuccess.jsp").forward(req, resp);

			}else {

				req.getRequestDispatcher("WriteFail.jsp").forward(req, resp);

			}

		}

	}


}
