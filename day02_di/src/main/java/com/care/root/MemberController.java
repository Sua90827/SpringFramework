package com.care.root;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
	@Autowired
	private HttpSession session;
	
	public MemberController() {
		System.out.println("controller");
	}
	@GetMapping("/index")//url path
	public String index() {
		System.out.println("====>"+ms);//====>com.care.root.MemberService@5b17b7d7
		ms.test();
		return "index";//views->jsp path
	}
	@GetMapping("/result")
	public String result(Model model) {
		model.addAttribute("member", ms.result());
		return "result";
	}
	
	@GetMapping("/register")
	public String register() {
		
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@PostMapping("/register.do")
	public String register(@RequestParam("id") String id) {
		session.setAttribute("userId", id);
		return "redirect:login";
	}
	
	@PostMapping("/login.do")
	public String login(@RequestParam("id") String id, Model model){
		if(id.equals(session.getAttribute("userId").toString())) {
			model.addAttribute("msg", "로그인 성공");
			return "index";
		}else {
			model.addAttribute("msg", "로그인 실패");
			return "login";
		}
			
	}
	
}
