package com.care.root.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
	
	@Bean  //�ڹ��ڵ�� �� ����.
	public TestClass tc() {
		TestClass test = new  TestClass();
		test.setName("sua Kim");
		return test;
	}
}
