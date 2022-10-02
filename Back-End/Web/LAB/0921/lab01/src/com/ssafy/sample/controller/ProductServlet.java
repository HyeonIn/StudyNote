package com.ssafy.sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.model.service.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private ProductService service = ProductService.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			if ("add".equals(action)) {
				
				request.getRequestDispatcher("product/regist.jsp").forward(request, response);
				
			}	
			else if ("list".equals(action)) {
				
				request.setAttribute("productList", service.selectAll());
				
				request.getRequestDispatcher("product/productList.jsp").forward(request, response);
			}
			else if ("detail".equals(action)) {
				request.setAttribute("selectedProduct", service.selectOne(request.getParameter("code")));
				request.getRequestDispatcher("product/detail.jsp").forward(request, response);
			}
			else if ("delete".equals(action)) {
				service.deleteProduct(request.getParameter("code"));
				request.setAttribute("msg", "삭제 성공");
				request.getRequestDispatcher("product/result.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		try {
			if ("add".equals(action)) {
				String code = request.getParameter("code");
				String model = request.getParameter("model");
				int price = Integer.parseInt(request.getParameter("price"));
				System.out.println(code + " " + model);
				service.insert(new Product(code, model, price));
				request.setAttribute("msg", "상품 등록 성공");
				request.getRequestDispatcher("product/result.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", "오류 발생");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

}
