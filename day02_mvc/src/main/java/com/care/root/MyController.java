package com.care.root;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("/index") // url ���� ���
	public String memberIndex() {
		System.out.println("index ����");
		return "member/index"; //views������ ���
	}
	
	@RequestMapping("/login")
	public ModelAndView memberLogin() {
		ModelAndView model = new ModelAndView();
		model.addObject("abc", "abc�� ����");
		model.setViewName("member/login");
		System.out.println("login ����");
		return model;
	}
	
	@RequestMapping("/logout")
	public String memberLogout(Model model) {
		System.out.println("run logout");
		model.addAttribute("test","�� �Դϴ�");
		return "member/logout";
	}
}