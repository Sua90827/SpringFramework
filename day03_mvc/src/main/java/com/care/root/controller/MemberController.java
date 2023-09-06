package com.care.root.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.root.dto.MemberDTO;
import com.care.root.service.MemberService;

@Controller
@RequestMapping("quiz/")
public class MemberController {
	@Autowired
	private MemberService service;
	
	
	@GetMapping("login")
	public String login() {
		return "quiz/form";
	}
	
	@PostMapping("login.do")
	public String loginDo(Model model, HttpSession session, MemberDTO dto) {
		String result = service.loginCh(dto);
		if(result.equals("로그인 성공")) {
			session.setAttribute("userId", dto.getId());
			model.addAttribute("result", result);
		}
		model.addAttribute("result", result);
		return "redirect:login";
	}
}
