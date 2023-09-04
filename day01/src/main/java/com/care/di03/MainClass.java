package com.care.di03;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.care.di02.STBean;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:applicationDB.xml"; //경로 지정
		GenericXmlApplicationContext ctx= new GenericXmlApplicationContext(path);
		
		DBClass db = ctx.getBean("db", DBClass.class); //Bean을 가져올건데, 그것의 자료형이 무엇인지도 써줌. id의 값과 동일하게 적어줘야함.
		System.out.println("id" +db.getId());
		System.out.println("pwd" +db.getPwd());
		
		DBClass db1 = ctx.getBean("db1", DBClass.class);
		System.out.println(db1.getId());
		System.out.println(db1.getPwd());

	}
}
