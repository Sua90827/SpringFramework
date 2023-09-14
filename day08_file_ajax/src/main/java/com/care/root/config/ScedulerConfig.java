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
	@Scheduled(cron="*/10*****")//� �ð����� �� ������ ����
	public void test01() {
		System.out.println("10�ʸ��� ����: "+fs);
	}	
		@Scheduled(cron="0-59*****")//� �ð����� �� ������ ����
		public void test02() {
			System.out.println("�� �ʸ��� ����: "+fs);
		}
}
