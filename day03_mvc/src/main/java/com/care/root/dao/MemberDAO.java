package com.care.root.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.root.dto.MemberDTO;
@Repository
public class MemberDAO {
	
	public static ArrayList<MemberDTO> DB;
	
	public MemberDAO() {
		String [] id = new String[3];
		String [] pwd = new String[3];
		String [] name = new String[3];
		id[0] = "sua";
		id[1] = "junyoung";
		id[2] = "jeongbae";
		pwd[0] = "1";
		pwd[1] = "1";
		pwd[2] = "1";
		name[0] = "suakim";
		name[1] = "junyoungSeo";
		name[2] = "jungbae";
		DB=new ArrayList<MemberDTO>();
		for(int i=0; i<3; i++) {
		    MemberDTO dto = new MemberDTO(); // 각 반복에서 새로운 객체 생성
			dto.setId(id[i]);
			dto.setName(name[i]);
			dto.setPwd(pwd[i]);	
			DB.add(dto);
		}
	}
	
	public ArrayList<MemberDTO> getDb(){
		return DB;
	}
}