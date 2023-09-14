package com.care.root.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.care.root.service.FileService;

@Configuration
//@EnableScheduling
public class ScedulerConfig {
	@Autowired FileService fs;
	@Scheduled(cron="*/10*****")//어떤 시간마다 뭘 실행할 건지
	public void test01() {
		System.out.println("10초마다 실행: "+fs);
	}	
		@Scheduled(cron="0-59*****")//어떤 시간마다 뭘 실행할 건지
		public void test02() {
			System.out.println("매 초마다 실행: "+fs);
		}
}
