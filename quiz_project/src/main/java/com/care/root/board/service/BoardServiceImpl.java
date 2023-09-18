package com.care.root.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
@Autowired BoardMapper dao;
@Autowired BoardFileService bfs;

	@Override
	public List<BoardDTO> getBoardList() {
//		List<BoardDTO> boardList = dao.getBoardList();
//		return boardList;
		return dao.getBoardList();
	}
	
	@Override
	public String writeSave(BoardDTO dto, MultipartFile image_file_name) {
		if(image_file_name.isEmpty()) {//������ ���� ���
			dto.setImageFileName("nan");
		}else {//������ �����ϴ� ���
			dto.setImageFileName(bfs.saveFile(image_file_name));
		}
		int result = dao.writeSave( dto );
		String msg = "", url="";
		if(result == 1) {//��� ���������� ����
			msg = "�� ���� �߰��Ǿ����ϴ�.";
			url = "/root/board";
			//request.getContextPath()�� root��� ����ص� �ȴ�.
		}else {//db ���� ����
			msg = "������ �߻��߽��ϴ�";
			url = "/root/writeForm";
		}
		return bfs.getMessage(msg, url);
	}
	
	@Override
	public BoardDTO contentView(int writeNo) {
		
		return dao.getContent(writeNo);
	}

}
