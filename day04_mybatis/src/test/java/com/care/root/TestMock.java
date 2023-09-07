package com.care.root;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.care.root.member.controller.MemberController;

import junit.framework.Assert;

@RunWith(SpringRunner.class) //서버로 구동하는 것이 아니라, SpringRunner를 사용해서 테스트환경으로 구동하겠다는 의미. 
@ContextConfiguration( locations = {"classpath:testMember.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestMock {
	
	@Autowired MemberController mc;
	MockMvc mock;
	
	@org.junit.Before
	public void setUp() {
		System.out.println("실행전 실행");
		mock= MockMvcBuilders.standaloneSetup(mc).build(); //mock을 이용해서 mc라는 경로로 접근이 가능  /mock 객체 생성
		}
	
	//@Test //통합
	public void testIndex() throws Exception{
		System.out.println("--test 실행");
		mock.perform(get("/list"))
		.andDo( print() ) //내가 이 경로를 요청했을 때 요청 시 상태를 출력하겠다.
		.andExpect( status().isOk() ) //검증해주는 것임. 성공이면 200.
		.andExpect(forwardedUrl("member/list")); //리턴 경로가 list이면 통과. 나중에 test할 때는 경로 수정해줘야 함.
		Assert.assertNull(null);
	}
	
	@Test
	@Transactional(transactionManager = "txMgr")//롤백처리
	public void testInsert() throws Exception{
		System.out.println("---test 실행");
		mock.perform(post("/insert")
				.param("id", "1234")
				.param("name", "test4")) //dto에 저장된다.
			.andDo(print())
			.andExpect( status().is3xxRedirection() );
	}
	

}
