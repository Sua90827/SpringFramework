package com.care.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDAO dao;
	
	public MemberService() {
		System.out.println("service");
	}
	public void test() {
		System.out.println("test ¿¬µ¿");
		dao.test();
	}
	public MemberDTO result() {
		return dao.result();
	}
}
