package com.care.root.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.dao.MemberDAO;
import com.care.root.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired 
	private MemberDAO dao;

	public String loginCh(MemberDTO dto) {
		ArrayList<MemberDTO> db = dao.getDb();
		for(int i=0; i<3; i++) {
			if(dto.getId().equals(db.get(i).getId())) {
				if(dto.getPwd().equals(db.get(i).getPwd())){
					return "�α��� ����";
				}else {
					return "��й�ȣ �ٸ�";
				}
			}

		}
		return "���̵� ����";
	}

}
