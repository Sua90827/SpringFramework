package com.care.root.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.service.BoardFileService;
import com.care.root.board.service.BoardService;

@Controller
public class BoardController {
	@Autowired BoardService service;
	
	@GetMapping("board")
	public String board(Model model, @RequestParam(required=false, defaultValue="1") int num) {
		//List<BoardDTO> boardList = service.getBoardList();
		Map<String, Object> map = service.getBoardList(num);
		model.addAttribute("boardList", map.get("list"));
		model.addAttribute("repeat", map.get("repeat") );
		return "board/boardAllList";
	}
	
	@GetMapping("writeForm")
	public String writePage() {
		return "board/writeForm";
	}
	
	@PostMapping("writeSave")
	public String writeSave(BoardDTO dto, @RequestParam (required=false) MultipartFile image_file_name, HttpServletResponse res) throws IOException {
		System.out.println(dto.getId());
		System.out.println(dto.getTitle());
		System.out.println(dto.getContent());
		System.out.println(image_file_name.getOriginalFilename());
		
		String msg = service.writeSave(dto, image_file_name);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(msg);
		return null;
	}
	
	@GetMapping("contentView")
	public String contentView(@RequestParam int writeNo, Model model) {
		model.addAttribute("dto", service.contentView(writeNo));
		return "board/contentView";
	}
	
	@GetMapping("download")
	public void download(@RequestParam String name, HttpServletResponse res)throws Exception{
		res.addHeader("Content-disposition", "attachment; fileName="+name);
		File file = new File(BoardFileService.IMAGE_REPO+"/"+name);
		FileInputStream in = new FileInputStream(file);
		FileCopyUtils.copy(in, res.getOutputStream());
		in.close();
	}
	
	@GetMapping("modify_form")
	public String modifyForm(@RequestParam int writeNo, Model model) {
		model.addAttribute("content", service.getContent(writeNo));
		return "board/modify_form";
	}
	
	@PostMapping("modify")
	public void modify(BoardDTO dto, @RequestParam MultipartFile file,
						HttpServletResponse res) throws Exception {//수정된 이미지가 없으면 file의 사이즈는 0이 됨.
		System.out.println("&&&&&&&&dto $$$$ =====>"+dto.getId());
		System.out.println("&&&&&&&&file $$$$ =====>"+file);
		String msg = service.modify(dto,file);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print( msg);
	}
	
	@GetMapping("delete")
	public void delete(@RequestParam int writeNo, @RequestParam String fileName, HttpServletResponse res) throws Exception {
		String msg = service.delete(writeNo, fileName);
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print( msg);
	}
}
