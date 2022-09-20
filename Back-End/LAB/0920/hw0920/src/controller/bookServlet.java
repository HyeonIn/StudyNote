package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.bookService;

/**
 * Servlet implementation class bookServlet
 */
@WebServlet("/book")
public class bookServlet extends HttpServlet {
	bookService service = new bookService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if ("list".equals(action)) {
			req.setAttribute("bookList", service.selectAll());
			req.getRequestDispatcher("bookList.jsp").forward(req, resp);
		}
		else if ("detail".equals(action)) {
			req.setAttribute("bookFind", service.selectOne(Integer.parseInt(req.getParameter("no"))));
			req.getRequestDispatcher("bookDetail.jsp").forward(req, resp);
		}
		else if ("delete".equals(action)) {
			if (service.delete(Integer.parseInt(req.getParameter("no")))) {
				req.getRequestDispatcher("deleteSuccess.jsp").forward(req, resp);				
			}
			else {
				req.getRequestDispatcher("deleteSuccess.jsp").forward(req, resp);								
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if ("add".equals(action)) {
			String title = req.getParameter("title");
			int price = Integer.parseInt(req.getParameter("price"));
			String publisher = req.getParameter("publisher");
			String writer = req.getParameter("writer");
			if (service.insert(new Book(title, price, publisher, writer))) {
				req.getRequestDispatcher("bookAddSuccess.jsp").forward(req, resp);
			}
			
		}
		// TODO Auto-generated method stub
	}

}
