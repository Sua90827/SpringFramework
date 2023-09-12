package com.care.root.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("user_id") == null) {
			//response.sendRedirect("login");
			String msg = "<script>alert('Login first');";
			msg+= "location.href='/root/login';</script>";
			response.setContentType("text/html; charset UTF-8");
			PrintWriter out = response.getWriter();
			out.print(msg);
			return false;
		}
		System.out.println("list 컨트롤러 전 실행-----");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("----list 컨트롤러 후 실행");
	}
	
}
