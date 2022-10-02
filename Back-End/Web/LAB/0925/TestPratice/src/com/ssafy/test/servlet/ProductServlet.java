package com.ssafy.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.test.model.dto.productDTO;
import com.ssafy.test.model.service.productService;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private productService service = productService.getInst();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("act");
		response.setCharacterEncoding("utf-8");
		if ("list".equals(action)) {
			request.setAttribute("productList", service.selectAll());
			request.getRequestDispatcher("list.jsp").forward(request, response);;
		} else if ("registForm".equals(action)) {
			HttpSession session = request.getSession();
			if (session.getAttribute("loginUser") == null) {
				request.setAttribute("msg", "로그인 후 이용해주세요");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				response.sendRedirect("regist.jsp");
			}
		} else if ("check".equals(action)) {
			String pcode = request.getParameter("code");
			productDTO p = service.selectOne(pcode);
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			if (p != null) {
				out.println(1);				
			}else {
				out.println(0);
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("act");
		if ("regist".equals(action)) {
			String pcode = request.getParameter("code");
			String pname = request.getParameter("name");
			String pquantity = request.getParameter("quantity");
			if (pquantity.equals("")) {
				request.getRequestDispatcher("error/500.jsp").forward(request, response);;
			} else {
				service.insert(new productDTO(pcode, pname, Integer.parseInt(pquantity)));
				request.setAttribute("msg", "등록되었습니다");
				request.getRequestDispatcher("regist.jsp").forward(request, response);
			}
		}
		
	}

}
