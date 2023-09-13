package com.care.root.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.service.FileService;

@Controller
@RequestMapping("file")
public class FileController {
	@Autowired FileService fs;
	
   @GetMapping("form")
   public String form() {
      return "file/uploadForm";
   }
   @PostMapping("upload1")
   public String upload1(@RequestParam String id, @RequestParam String name, @RequestParam MultipartFile file) {
	   System.out.println("id: "+id);
	   System.out.println("name: "+name);
	   System.out.println("file: "+file.getOriginalFilename());
	   
	   fs.fileProcess(id, name, file);
	   return "redirect:form";

   }
   @PostMapping("upload2")
   public String upload2(MultipartHttpServletRequest mt) {
	   System.out.println("mt id : "+mt.getParameter("id"));
	   System.out.println("mt name : "+mt.getParameter("name"));
	   MultipartFile file = mt.getFile("file");
	   System.out.println("mt file : "+file.getOriginalFilename());
	   return "redirect:form";
   }
}