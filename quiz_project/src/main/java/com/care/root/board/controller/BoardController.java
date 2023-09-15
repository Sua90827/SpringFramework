package com.care.root.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.service.BoardService;

@Controller
public class BoardController {
	@Autowired BoardService service;
	
	@GetMapping("board")
	public String board(Model model) {
		List<BoardDTO> boardList = service.getBoardList();
		model.addAttribute("boardList", boardList);
		return "board/boardAllList";
	}
	
	@GetMapping("writeForm")
	public String writePage() {
		return "board/writeForm";
	}
	
	@PostMapping("boardWrite.do")
	public String boardWriteDo(BoardDTO dto) {
		System.out.println(dto.getId());
		return null;
	}
}
