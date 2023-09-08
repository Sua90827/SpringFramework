package com.care.root.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("loginDo")
	public String loginDo(MemberDTO dto, Model model, HttpSession session) {
		String msg = ms.loginCh(dto);
		if (!(msg.equals("로그인성공"))){
			model.addAttribute("msg", msg);
			return "member/login";
		}
		session.setAttribute("user_id", dto.getId());
		model.addAttribute("msg", msg);
		return "member/successLogin";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@GetMapping("memberInfo")
	public String memberInfo(Model model) {
		ArrayList<MemberDTO> list = ms.getEveryMemberInfo();
		model.addAttribute("list", list);
		return "member/memberInfo";
	}
	@GetMapping("info")
	public String info(@RequestParam("id") String user_id, Model model) {
		MemberDTO dto = ms.getMemberInfo(user_id);
		model.addAttribute("info", dto);
		return "member/info";
	}
	
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("registerDo")
	public String registerDo(MemberDTO dto) {
		ms.register(dto);
		return "member/login";
	}
}
