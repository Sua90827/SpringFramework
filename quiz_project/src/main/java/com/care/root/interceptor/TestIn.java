package com.care.root.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestIn extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
System.out.println("new interceptor is uploaded");
		
		HttpSession session = request.getSession();
		
		if(StringUtils.isEmpty(session.getAttribute("user_id"))) {
			System.out.println("durldlisjdj;dj");
			String msg = "<script>alert('Login first');";
			msg += "location.href='/root/login';</script>";
			System.out.println(msg);
			response.setContentType("text/html; charset UTF-8");
			PrintWriter out = response.getWriter();
			out.print(msg);
			return false;
		}
		
		return true;
	}

	

}
