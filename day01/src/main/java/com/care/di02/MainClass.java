package com.care.di02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
public static void main(String[] args) {
	//classpath : resources ������ �����ϴ� ����
	//���� ��δ�,, src/main/resources/applicationST.xml
	String path = "classpath:applicationST.xml"; //��� ����
	GenericXmlApplicationContext ctx= new GenericXmlApplicationContext(path);//path�� ������ �����ϰ� �ش� bean ���� ioc�����̳ʿ� ����Ѵ�.
	
	STBean stb = ctx.getBean("stb", STBean.class); //Bean�� �����ðǵ�, �װ��� �ڷ����� ���������� ����. id�� ���� �����ϰ� ���������.
//	stb.setName("Sua Kim");
//	stb.setAge(30);
	
	stb.namePrint();
	stb.agePrint();
}
}
