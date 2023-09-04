package com.care.di03;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.care.di02.STBean;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:applicationDB.xml"; //��� ����
		GenericXmlApplicationContext ctx= new GenericXmlApplicationContext(path);
		
		DBClass db = ctx.getBean("db", DBClass.class); //Bean�� �����ðǵ�, �װ��� �ڷ����� ���������� ����. id�� ���� �����ϰ� ���������.
		System.out.println("id" +db.getId());
		System.out.println("pwd" +db.getPwd());
		
		DBClass db1 = ctx.getBean("db1", DBClass.class);
		System.out.println(db1.getId());
		System.out.println(db1.getPwd());

	}
}
