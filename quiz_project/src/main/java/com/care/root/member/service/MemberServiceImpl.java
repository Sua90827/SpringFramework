package com.care.root.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired 
	private MemberMapper dao;
	BCryptPasswordEncoder encoder;
	public MemberServiceImpl() {
		encoder = new BCryptPasswordEncoder();
	}
	
	public String loginCh(MemberDTO dto) {
		MemberDTO db = new MemberDTO();
		db = dao.getMemberInfo(dto.getId());

		if(db == null) {
			return "아이디 없음";
		}
		
		if (db.getId().equals(dto.getId())){
			if( encoder.matches(dto.getPw(),  db.getPw()) || dto.getPw().equals(db.getPw())) {
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
	@Override
	public void register(MemberDTO dto, String[] addr) {
		String ad = "";
		for(String a : addr) {
			ad += a +"/";
		}
		dto.setAddr(ad);
		System.out.println("평문 : "+dto.getPw());
		System.out.println("암호화 : "+encoder.encode(dto.getPw()));
		
		dto.setPw( encoder.encode(dto.getPw()));
		try {
			dao.register(dto);			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void keepLogin(String sessionId, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sessionId", sessionId);
		map.put("id", id);
		dao.keepLogin(map);
	}

	@Override
	public MemberDTO getUserSessionId(String sessionId) {
		return dao.getUserSessionId(sessionId);
	}


//	public String register(String[]addr, MemberDTO dto) {
//		
//		if(dto.getId().equals("")) {
//			return "아이디를 입력하세요";
//		}else if(dto.getPw().equals("")) {
//			return "비밀번호를 입력하세요";
//		}else if(dto.getAddr().equals("")) {
//			return "주소를 입력하세요";
//		}
//		MemberDTO db = new MemberDTO();
//		db = dao.getMemberInfo(dto.getId());
//
//		if(db != null) {
//			return "
//			dao.register(dto);
//		}
	//return null;



	//}
	
}
