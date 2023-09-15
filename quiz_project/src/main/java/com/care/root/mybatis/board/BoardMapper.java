package com.care.root.mybatis.board;

import java.util.List;

import com.care.root.board.dto.BoardDTO;

public interface BoardMapper {

	List<BoardDTO> getBoardList();

}
