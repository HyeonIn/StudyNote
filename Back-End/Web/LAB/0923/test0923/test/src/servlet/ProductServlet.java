package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.ProductDTO;
import model.service.ProductService;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private ProductService service = ProductService.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("act");
		if ("list".equals(action)) {
			request.setAttribute("productList", service.selectAll());
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}else if ("registForm".equals(action)) {
			HttpSession session = request.getSession();
			
			if (session.getAttribute("loginUser") == null) {
				request.setAttribute("msg", "로그인 후 이용 가능합니다");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("regist.jsp").forward(request, response);				
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("act");
		request.setCharacterEncoding("utf-8");
		if ("regist".equals(action)) {
			String pcode = request.getParameter("code");
			String pname = request.getParameter("name");
			String pquantity = request.getParameter("quantity");
			System.out.println(pquantity);
			if (pcode == "" || pname == "" || pquantity == "") {
				request.getRequestDispatcher("error/500.jsp").forward(request, response);
			}
			else {
				service.insert(new ProductDTO(pcode, pname, Integer.parseInt(pquantity)));
								
				request.setAttribute("msg", "등록되었습니다.");
				request.getRequestDispatcher("regist.jsp").forward(request, response);
			}			
		}
	}

}
