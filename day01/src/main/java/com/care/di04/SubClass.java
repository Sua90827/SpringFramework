package com.care.di04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SubClass {
	public void print() {
		String path = "classpath:applicationCAR.xml"; //경로 지정
		GenericXmlApplicationContext ctx= new GenericXmlApplicationContext(path);
		
		Car car = ctx.getBean("car", Car.class); 
		System.out.println("subclass 실행");
		car.speed();
		System.out.println("-----------");
	}
}
