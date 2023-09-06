package com.care.get_post;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/my")//계속 같은 경로를 적기 귀찮으니깐 미리 여기에 적어줌. 이러면 모두 /root/my/로 시작
public class MyController {
	public MyController() {
		System.out.println("생성자 실행!!");
	}
	
	@RequestMapping("/index")
	public String index() {
		return "get_post/index";
	}
	
	@RequestMapping(value="/result", method=RequestMethod.GET)
	public String result(HttpServletRequest req, Model model) {//request에 대한 자료형. 웹통신을 위해 서블릿이 가지고 있는 것.
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		System.out.println("전송 방식 : "+req.getMethod());
		System.out.println("id : "+name+"age:"+age);
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("method", req.getMethod());
		
		return "get_post/result";
	}
	
	@PostMapping("/result")
	public String resultPost(@RequestParam String name, @RequestParam("age")int a, HttpServletRequest req, Model model) {//age라는 값을 int a에 저장하겠다는 뜻.
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
