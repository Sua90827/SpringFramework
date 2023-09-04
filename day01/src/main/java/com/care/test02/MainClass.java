package com.care.test02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:application_test02.xml"; //경로 지정
		GenericXmlApplicationContext ctx= new GenericXmlApplicationContext(path);
		
		SaveClass save = ctx.getBean("numOp", SaveClass.class); 
		save.operationClass();
		save.printClass();
	}
}
