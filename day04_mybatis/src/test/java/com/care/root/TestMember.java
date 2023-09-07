package com.care.root;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.member.controller.MemberController;
import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

/*
 * junit : test를 진행하기 위한 프래임워크(기능들의 집합)
 * 테스트 주도 개발. 
 * 테스트가 주가 되면 기본 코드를 작성할 때 지치기 때문에 간단하게 만드는 것이 좋음. 
 * 코드 작성 후 테스트 하기 위해서는 서버를 구동해야 함. 코드가 커질 수록 서버에서 처리할 것이 많아져서 느려진다. 
 * 이건 서버로 동작하는 것이 아니라서 처리 속도가 빠름.
 * 
 * 테스트 종류 (단위, 통합)
 * 단위 = 단위별로 기능 동작 확인.
 * 통합 = 단위테스트 후 결과를 종합적으로, 통합적으로 테스트 하는 것.
 * 
 * 테스트 진행을 위해서는 라이브러리가 필요함.
 */
@RunWith(SpringRunner.class) //서버로 구동하는 것이 아니라, SpringRunner를 사용해서 테스트환경으로 구동하겠다는 의미. 
@ContextConfiguration( locations = {"classpath:testMember.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestMember {
	@Autowired MemberController mc;
	@Test
	public void testMc() {
		System.out.println(mc);
		assertNotNull(mc);//해당 빈이 null이 아니면 성공, 만약 빈이 null이면 실패
	} 
	
	@Autowired MemberService ms;
	@Test
	public void testMs() {
		assertNotNull(ms);
		
		MemberDTO dto = new MemberDTO();
		dto.setId(222);
		dto.setName("suaKim");
		int result = ms.insertMember(dto);
		System.out.println("result : "+result);
		assertEquals(result, 1);
	}
	
	@Autowired MemberDAO dao;
	@Test public void testDao() {
		assertNotNull(dao);
		MemberDTO dto = new MemberDTO();
		dto.setId(111);
		dto.setName("suaKim");
		int result = dao.insertMember(dto);
		System.out.println("result : "+result);
		assertEquals(result, 1);
	}
}
