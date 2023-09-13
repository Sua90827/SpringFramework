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
	   res.addHeader("Content-disposition", "attachment; fileName="+URLEncoder.encode(file, "utf-8"));//클릭한 파일ㅇ 대한 이름으로 저장할 거다.
	   //이 부분은 HTTP 응답 헤더를 설정합니다. "Content-disposition" 헤더는 클라이언트에게 어떻게 파일을 처리해야 하는지를 알려줍니다.
	   //"attachment" 값은 파일을 첨부 파일로 처리하도록 지시하고, "fileName"은 다운로드되는 파일의 이름을 설정합니다
	   File f = new File(FileService.IMAGE_REPO+"/"+file);//다운로드할 파일의 경로를 지정하는 File 객체를 생성
	   FileInputStream in = new FileInputStream(f);//이 객체는 지정된 파일을 읽어서 데이터를 가져올 수 있습니다.
	   FileCopyUtils.copy(in, res.getOutputStream()); //사용자에게 output 해주겠다.
	   //FileCopyUtils 클래스를 사용하여 파일 데이터를 읽어와서 HttpServletResponse의 OutputStream으로 복사합니다. 
	   //이렇게 하면 파일 데이터가 응답 스트림으로 전송되고, 클라이언트 브라우저는 다운로드 대화 상자를 표시하여 파일을 다운로드할 수 있도록 합니다.
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