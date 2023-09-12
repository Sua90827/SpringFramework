package com.care.root.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
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
		System.out.println("컨트롤러리스트 동작");
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
	public String registerDo(HttpServletRequest req, MemberDTO dto, Model model
			) {
		String[] addr = req.getParameterValues("addr");
		String ad = "";
		for(String a : addr) {
			System.out.println(a);
			ad += a+"/";
		}
		System.out.println(ad);
		String[] addr02 = ad.split("/");
		for(String a1 : addr02) {
			System.out.println(a1);
		}
		System.out.println("-----------------dto");
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		
		ms.register(dto, req.getParameterValues("addr"));
//		String msg = ms.register(dto);
//		if(msg != null) {
//			model.addAttribute("msg", msg);
//			model.addAttribute("dto", dto);
//			return "member/register";
//		}else {
			return "redirect:login";			
//		}
	}
}
