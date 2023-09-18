package com.care.root.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;

public interface BoardService {

	List<BoardDTO> getBoardList();

	String writeSave(BoardDTO dto, MultipartFile image_file_name);

	BoardDTO contentView(int writeNo);

}
