package com.care.root.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.dto.FileDTO;
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
   
   @GetMapping("views")
   public String views(Model model) {
	   model.addAttribute("list", fs.getData());
	   return "file/result";
   }
   
   @GetMapping("download")
   public void download(@RequestParam String file, HttpServletResponse res) throws Exception{
	   res.addHeader("Content-disposition", "attachment; fileName="+URLEncoder.encode(file, "utf-8"));//Ŭ���� ���Ϥ� ���� �̸����� ������ �Ŵ�.
	   //�� �κ��� HTTP ���� ����� �����մϴ�. "Content-disposition" ����� Ŭ���̾�Ʈ���� ��� ������ ó���ؾ� �ϴ����� �˷��ݴϴ�.
	   //"attachment" ���� ������ ÷�� ���Ϸ� ó���ϵ��� �����ϰ�, "fileName"�� �ٿ�ε�Ǵ� ������ �̸��� �����մϴ�
	   File f = new File(FileService.IMAGE_REPO+"/"+file);//�ٿ�ε��� ������ ��θ� �����ϴ� File ��ü�� ����
	   FileInputStream in = new FileInputStream(f);//�� ��ü�� ������ ������ �о �����͸� ������ �� �ֽ��ϴ�.
	   FileCopyUtils.copy(in, res.getOutputStream()); //����ڿ��� output ���ְڴ�.
	   //FileCopyUtils Ŭ������ ����Ͽ� ���� �����͸� �о�ͼ� HttpServletResponse�� OutputStream���� �����մϴ�. 
	   //�̷��� �ϸ� ���� �����Ͱ� ���� ��Ʈ������ ���۵ǰ�, Ŭ���̾�Ʈ �������� �ٿ�ε� ��ȭ ���ڸ� ǥ���Ͽ� ������ �ٿ�ε��� �� �ֵ��� �մϴ�.
   }
   
   @GetMapping("delete")
   public String delete(@RequestParam String file, @RequestParam String id) {
	   fs.delete(file, id);
	   return "redirect:views";
   }
   
   @GetMapping("modify")
   public String modify(FileDTO dto, Model model) {
	   System.out.println(dto.getId());
	   System.out.println(dto.getName());
	   System.out.println(dto.getImgName());
	   model.addAttribute("dto", dto);
	   
	   return "file/modify_view";
   }
   
   @PostMapping("modify.do")
   public String modifyDo(FileDTO dto, @RequestParam MultipartFile file) {
	   fs.modifyDo(dto, file);
	   return "redirect:views";
   }
}