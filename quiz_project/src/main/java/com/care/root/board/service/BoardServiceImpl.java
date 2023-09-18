package com.care.root.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.board.dto.BoardDTO;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
@Autowired BoardMapper dao;
	@Override
	public List<BoardDTO> getBoardList() {
//		List<BoardDTO> boardList = dao.getBoardList();
//		return boardList;
		return dao.getBoardList();
	}

}
