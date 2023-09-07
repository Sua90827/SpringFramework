package com.care.root;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cookie")
public class CookieController {
	@Autowired(required=false)  //���� ioc�� �ִ� ����� �ڵ����� �������ְڴٴ� ��ɾ�. ���⿡ ȣ��� ���� ���ٸ� UnsatisfiedDependencyException ���� �߻�. 
	TestClass tc;

	@GetMapping("index")
	public String index(HttpServletResponse res) {
		System.out.println(tc);
		Cookie cookie = new Cookie("key", "12345");
		cookie.setMaxAge(5);
		res.addCookie(cookie);
		return "cookie/index";
	}
	
	@GetMapping("result")  //��� ��Ű�� �� ��ȸ�ϴ� ��ȿ������ ���
	public void result(HttpServletRequest req) {
		Cookie[] arr = req.getCookies();
		for(Cookie c : arr) {
			System.out.println("name: "+c.getName());
			System.out.println("value: "+c.getValue());
			System.out.println("----------");
			if(c.getName().equals("key")) {
				
			}
		}
	}
	
	@GetMapping("result02") //���ϴ� ��Ű�� �������� ȿ������ ���
	public void result02(@CookieValue(value="key", required = false) Cookie cookie) {
		System.out.println("result02 connected");
		System.out.println("cookie : "+cookie);
		if(cookie != null) {
			System.out.println(cookie.getName());
			System.out.println(cookie.getValue());			
		}
	}
}
