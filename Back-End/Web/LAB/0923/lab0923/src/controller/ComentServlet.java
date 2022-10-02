package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.ComentDTO;
import model.ComentService;

@WebServlet("/coment")
public class ComentServlet extends HttpServlet {
	private ComentService service= new ComentService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("list".equals(action)) {
			int bno = Integer.parseInt(request.getParameter("bno"));
			List<ComentDTO> cList = service.selectComentList(bno);
			response.setContentType("text/json;charset=UTF-8");
			Gson gs = new Gson();
			response.getWriter().write(gs.toJson(cList));
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("add".equals(action)) {
			int bno = Integer.parseInt(request.getParameter("bno"));
			String cwriter = request.getParameter("cwriter");
			String ccontent = request.getParameter("ccontent");
			ComentDTO coment = new ComentDTO(bno, cwriter, ccontent);
			response.getWriter().write(service.insert(coment));
		}
	}

}
