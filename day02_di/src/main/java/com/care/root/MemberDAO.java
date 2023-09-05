package com.care.root;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	public MemberDAO() {
		System.out.println("member dao");
	}
	public void test() {
		System.out.println("run dao test");
	}
	public MemberDTO result() {
		MemberDTO dto = new MemberDTO();
		dto.setId("aaa");
		dto.setName("ȫ�浿");
		return dto;
	}
}
