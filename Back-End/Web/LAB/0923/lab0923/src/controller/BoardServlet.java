package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDTO;
import model.BoardService;
import model.ComentService;


@WebServlet("/board")
public class BoardServlet extends HttpServlet{
	private BoardService service = new BoardService();
	private ComentService cservice = new ComentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if ("list".equals(action)) {
			String pageStr = req.getParameter("page");
			int page =1;
			if (pageStr!=null && pageStr.length() > 0) {
				page = Integer.parseInt(pageStr);
			}
			req.setAttribute("boardPage", service.makePage(page));
			req.getRequestDispatcher("BoardList.jsp").forward(req, resp);
		}else if ("write".equals(action)) {
			req.getRequestDispatcher("BoardWrite.jsp").forward(req, resp);
		}else if ("content".equals(action)) {
			int bno = Integer.parseInt(req.getParameter("bno"));
			service.UpdateReadCount(bno);
			req.setAttribute("selectedBoard", service.selectOne(bno));
			req.getRequestDispatcher("BoardContent.jsp").forward(req, resp);
		}else if ("delete".equals(action)) {
			int bno = Integer.parseInt(req.getParameter("bno"));
			service.deleteOne(bno);
			req.getRequestDispatcher("DeleteSuccess.jsp").forward(req, resp);
		}else if ("editContent".equals(action)) {
			int bno = Integer.parseInt(req.getParameter("bno"));
			req.setAttribute("selectedBoard", service.selectOne(bno));
			req.getRequestDispatcher("ContentEdit.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		String action = req.getParameter("action");
		
		if ("write".equals(action)) {
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");
			
			BoardDTO board = new BoardDTO(title, writer, content);
			if (service.write(board)) {
				req.getRequestDispatcher("BoardWriteSuccess.jsp").forward(req, resp);
			}else {
				req.getRequestDispatcher("BoardWriteError.jsp").forward(req, resp);
			}
			
		}else if ("edit".equals(action)) {
			int bno = Integer.parseInt(req.getParameter("bno"));
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			service.UpdateOne(bno, title, content);
			req.getRequestDispatcher("UpdateSuccess.jsp").forward(req, resp);
		}
	}
	
}