package com.care.get_post;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/my")//��� ���� ��θ� ���� �������ϱ� �̸� ���⿡ ������. �̷��� ��� /root/my/�� ����
public class MyController {
	public MyController() {
		System.out.println("������ ����!!");
	}
	
	@RequestMapping("/index")
	public String index() {
		return "get_post/index";
	}
	
	@RequestMapping(value="/result", method=RequestMethod.GET)
	public String result(HttpServletRequest req, Model model) {//request�� ���� �ڷ���. ������� ���� �������� ������ �ִ� ��.
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		System.out.println("���� ��� : "+req.getMethod());
		System.out.println("id : "+name+"age:"+age);
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("method", req.getMethod());
		
		return "get_post/result";
	}
	
	@PostMapping("/result")
	public String resultPost(@RequestParam String name, @RequestParam("age")int a, HttpServletRequest req, Model model) {//age��� ���� int a�� �����ϰڴٴ� ��.
		model.addAttribute("name", name);
		model.addAttribute("age", a);
		model.addAttribute("method", req.getMethod());
		return "/get_post/result";
	}
	
	@PostMapping("/dto")
	public String dto(MyDTO dto, Model model) {
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		System.out.println(dto.getAddr());
		
		model.addAttribute("dto", dto);
		return "get_post/dto";
		
	}
	
}