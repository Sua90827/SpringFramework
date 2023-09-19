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
		if(! file.isEmpty()) {//���� ��
			originName = dto.getImageFileName();
			dto.setImageFileName(bfs.saveFile(file));
		}
		int result = dao.modify(dto);
		String msg="", url="";
		if(result == 1) {
			//���� �̹��� ����(originName)
			bfs.deleteImage(originName);			
			msg = "�����Ǿ����ϴ�.";
			url = "/root/contentView?writeNo="+dto.getWriteNo();
		}else {
			//�����̹��� ���� (dto.getImageFileName)
			bfs.deleteImage( dto.getImageFileName());
			
			msg = "���� �߻�!!";
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
			msg = "�����Ǿ����ϴ�.";
			url = "/root/board";
		}else {			
			msg = "���� �߻�!!";
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
