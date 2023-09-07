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

@RunWith(SpringRunner.class) //������ �����ϴ� ���� �ƴ϶�, SpringRunner�� ����ؼ� �׽�Ʈȯ������ �����ϰڴٴ� �ǹ�. 
@ContextConfiguration( locations = {"classpath:testMember.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestMock {
	
	@Autowired MemberController mc;
	MockMvc mock;
	
	@org.junit.Before
	public void setUp() {
		System.out.println("������ ����");
		mock= MockMvcBuilders.standaloneSetup(mc).build(); //mock�� �̿��ؼ� mc��� ��η� ������ ����  /mock ��ü ����
		}
	
	//@Test //����
	public void testIndex() throws Exception{
		System.out.println("--test ����");
		mock.perform(get("/list"))
		.andDo( print() ) //���� �� ��θ� ��û���� �� ��û �� ���¸� ����ϰڴ�.
		.andExpect( status().isOk() ) //�������ִ� ����. �����̸� 200.
		.andExpect(forwardedUrl("member/list")); //���� ��ΰ� list�̸� ���. ���߿� test�� ���� ��� ��������� ��.
		Assert.assertNull(null);
	}
	
	@Test
	@Transactional(transactionManager = "txMgr")//�ѹ�ó��
	public void testInsert() throws Exception{
		System.out.println("---test ����");
		mock.perform(post("/insert")
				.param("id", "1234")
				.param("name", "test4")) //dto�� ����ȴ�.
			.andDo(print())
			.andExpect( status().is3xxRedirection() );
	}
	

}
