package com.care.root.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("test/index")
	public void test(HttpServletResponse res, HttpServletRequest req) throws IOException {
		System.out.println(req.getContextPath());  // /root Ãâ·Â
		String msg = "<script>alert('Login first');";
		msg+= "location.href='/root/login';</script>";
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
	}
}
