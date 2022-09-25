package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api")
public class apiServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String lawd = req.getParameter("lawd");
		String deal = req.getParameter("deal");
		
		String responseBody = HttpUtil.execute(lawd, deal); // 검색 키워드 넣어서 네이버와 통신 결과 받아오기.

		
		resp.setContentType("text/xml;charset=UTF-8");

		resp.getWriter().write(responseBody);

	}
}
