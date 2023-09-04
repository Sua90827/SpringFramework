package com.care.di04;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.care.di03.DBClass;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:applicationCAR.xml"; //경로 지정
		GenericXmlApplicationContext ctx= new GenericXmlApplicationContext(path);
		
		Car car = ctx.getBean("car", Car.class); 
		System.out.println("run main");
		car.speed();
		System.out.println("-----------");
		
		SubClass sc = new SubClass();
		sc.print();
	}
}
