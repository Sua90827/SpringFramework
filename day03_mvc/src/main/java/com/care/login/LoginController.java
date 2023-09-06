package com.care.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("red")
public class LoginController {
	public LoginController() {
		System.out.println("LoginController");
	}
	
	@GetMapping("/index")
	public String index() {
		return "test/index";
	}
	@PostMapping("login_chk")
	public String loginChk(@RequestParam String id, @RequestParam String pwd) {
		System.out.println("id :"+id);
		System.out.println("pwd: "+pwd);
		return null;
	}
}
