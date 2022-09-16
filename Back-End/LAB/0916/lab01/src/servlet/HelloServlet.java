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

		System.out.println("�ҷ��� doget");

		req.setAttribute("bookList", new BookDao().selectAll());

		req.getRequestDispatcher("result.jsp").forward(req, resp);

	}
	
	@Override 
	protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		System.out.println("���� �޼ҵ� ���� ȣ��");
		
		System.out.println("doget �θ���");
		doGet(req, resp);
	}
	
	
}



