package com.care.root.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired 
	private MemberMapper dao;
	
	public String loginCh(MemberDTO dto) {
		MemberDTO db = new MemberDTO();
		db = dao.getMemberInfo(dto.getId());

		if(db == null) {
			return "아이디 없음";
		}
		
		if (db.getId().equals(dto.getId())){
			if(dto.getPw().equals(db.getPw())) {
				return "로그인성공";
			}else {
				return "비밀번호를 확인하세요";
			}
		}else {
			return "존재하지 않는 아이디입니다.";
		}
	}


	public ArrayList<MemberDTO> getEveryMemberInfo() {
		ArrayList<MemberDTO> result=dao.getEveryMemberInfo();
		return result;
	}


	public MemberDTO getMemberInfo(String user_id) {
		MemberDTO result = dao.getMemberInfo(user_id);
		return result;
	}



	public void register(MemberDTO dto) {
		dao.register(dto);
	}


	
	
}