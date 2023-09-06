package com.care.login;

import javax.servlet.SessionTrackingMode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController02 {
	@GetMapping("form")
	public String form() {
		return "login/form";
	}
	
	@PostMapping("login_chk")
	public String loginChk(@RequestParam String id, @RequestParam String pwd, HttpSession session) {
		String DBId="1", DBPwd="1", nick="suakim";
		if(id.equals(DBId) && pwd.equals(DBPwd)	) {
			session.setAttribute("id", DBId);
			session.setAttribute("nick", nick);
			return "redirect:main";
		}
		return "redirect:form";
	}
	@RequestMapping("main")
	public String main() {
		return "login/main";
	}
	@GetMapping("logout")
	public String logout(HttpSession session1, HttpServletRequest req) {
		HttpSession session2 = req.getSession();
		System.out.println("session1 : "+session1.getAttribute("nick"));
		System.out.println("session2 : "+session2.getAttribute("nick"));
		session1.invalidate();
		return "redirect:form";
	}
}
