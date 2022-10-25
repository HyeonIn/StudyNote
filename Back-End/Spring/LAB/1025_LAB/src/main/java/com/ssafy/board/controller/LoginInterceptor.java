package com.ssafy.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component // id = "loginInterceptor
public class LoginInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws ServletException, IOException {
		if (request.getSession().getAttribute("loginInfo")==null) {
			request.setAttribute("msg", "로그인이 필요합니다");
			request.getRequestDispatcher("/WEB-INF/views/Result.jsp").forward(request, response);
			return false;
		}
		return true;
	}
	
}
