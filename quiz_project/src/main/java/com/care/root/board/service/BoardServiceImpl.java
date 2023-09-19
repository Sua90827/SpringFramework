package com.care.root.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
@Autowired BoardMapper dao;
@Autowired BoardFileService bfs;

	@Override
	public Map<String, Object> getBoardList(int num) {
		int pageLetter=3;
		int allCount = dao.selectBoardCount();
		int repeat = allCount / pageLetter;
		if(allCount % pageLetter!=0) {
			repeat++;
		}
		int end = num * pageLetter;
		int start = end + 1 - pageLetter;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("repeat", repeat);
		map.put("list", dao.getBoardList(start, end));
//		List<BoardDTO> boardList = dao.getBoardList();
//		return boardList;
		return map;
	}
	
	@Override
	public String writeSave(BoardDTO dto, MultipartFile image_file_name) {
		if(image_file_name.isEmpty()) {//파일이 없는 경우
			dto.setImageFileName("nan");
		}else {//파일이 존재하는 경우
			dto.setImageFileName(bfs.saveFile(image_file_name));
		}
		int result = dao.writeSave( dto );
		String msg = "", url="";
		if(result == 1) {//디비에 성공적으로 저장
			msg = "새 글이 추가되었습니다.";
			url = "/root/board";
			//request.getContextPath()를 root대신 사용해도 된다.
		}else {//db 저장 실패
			msg = "문제가 발생했습니다";
			url = "/root/writeForm";
		}
		return bfs.getMessage(msg, url);
	}
	
	@Override
	public BoardDTO contentView(int writeNo) {
		upHit(writeNo);
		return dao.getContent(writeNo);
	}
	
	private void upHit( int writeNo) {
		dao.upHit(writeNo);
	}

	@Override
	public BoardDTO getContent(int writeNo) {
		return dao.getContent(writeNo);
	}

	@Override
	public String modify(BoardDTO dto, MultipartFile file) {
		String originName = null;
		if(! file.isEmpty()) {//수정 됨
			originName = dto.getImageFileName();
			dto.setImageFileName(bfs.saveFile(file));
		}
		int result = dao.modify(dto);
		String msg="", url="";
		if(result == 1) {
			//기존 이미지 삭제(originName)
			bfs.deleteImage(originName);			
			msg = "수정되었습니다.";
			url = "/root/contentView?writeNo="+dto.getWriteNo();
		}else {
			//수정이미지 삭제 (dto.getImageFileName)
			bfs.deleteImage( dto.getImageFileName());
			
			msg = "문제 발생!!";
			url = "/root/modify_form?writeNo="+dto.getWriteNo();
		}
		
		return bfs.getMessage(msg, url);
	}

	@Override
	public String delete(int writeNo, String fileName) {
		
		int result = dao.delete(writeNo);
		String msg="", url="";
		if(result == 1) {
			bfs.deleteImage(fileName);			
			msg = "삭제되었습니다.";
			url = "/root/board";
		}else {			
			msg = "문제 발생!!";
			url = "/root/contentView?writeNo="+writeNo;
		}
		
		return bfs.getMessage(msg, url);
	}

	@Override
	public void addReply(BoardRepDTO dto) {
		dao.addReply( dto );
	}

	@Override
	public List<BoardRepDTO> getRepList(int write_group) {
		List<BoardRepDTO> result = dao.getRepList(write_group);
		return result;
	}

}
