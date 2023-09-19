package com.care.root.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;

public interface BoardService {

	Map<String, Object> getBoardList(int num);

	String writeSave(BoardDTO dto, MultipartFile image_file_name);

	BoardDTO contentView(int writeNo);

	BoardDTO getContent(int writeNo);

	String modify(BoardDTO dto, MultipartFile file);

	String delete(int writeNo, String fileName);

	void addReply(BoardRepDTO dto);

	List<BoardRepDTO> getRepList(int write_group);

}
