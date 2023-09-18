package com.care.root.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.care.root.common.LoginSession;

public class BoardInterceptor extends HandlerInterceptorAdapter implements LoginSession{
	 
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		System.out.println("==========durldidldld============");
//		if(session.getAttribute(LOGIN) == null) {
//			String msg = "<script>alert('Login first');";
//			msg+= "location.href='/root/login';</script>";
//			response.setContentType("text/html; charset UTF-8");
//			PrintWriter out = response.getWriter();
//			out.print(msg);
//			return false;
//		}
//		System.out.println("list 컨트롤러 전 실행-----");
//		return true;
//
//	}
}
