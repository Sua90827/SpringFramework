package com.care.root.mybatis.board;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;

public interface BoardMapper {

	List<BoardDTO> getBoardList(
			@Param("s") int start, @Param("e") int end); //xml���� ����� ���� ���� �������ִ� @Param. �ΰ� �̻��� �����͸� �ѱ� ���� ����ؾ� ��.

	int writeSave(BoardDTO dto);

	BoardDTO getContent(int writeNo);

	void upHit(int writeNo);

	int modify(BoardDTO dto);

	int delete(int writeNo);

	void addReply(BoardRepDTO dto);

	List<BoardRepDTO> getRepList(int write_group);

	int selectBoardCount();



}
