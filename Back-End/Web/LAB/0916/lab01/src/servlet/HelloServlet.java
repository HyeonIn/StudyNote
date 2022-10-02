package servlet;


import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


import model.BookDao;


@WebServlet("/hello")

public class HelloServlet extends HttpServlet{

	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("불려진 doget");

		req.setAttribute("bookList", new BookDao().selectAll());

		req.getRequestDispatcher("result.jsp").forward(req, resp);

	}
	
	@Override 
	protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		System.out.println("서비스 메소드 먼저 호출");
		
		System.out.println("doget 부르기");
		doGet(req, resp);
	}
	
	
}



