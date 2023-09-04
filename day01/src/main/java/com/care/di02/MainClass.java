package com.care.di02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
public static void main(String[] args) {
	//classpath : resources 폴더를 지정하는 문법
	//실제 경로는,, src/main/resources/applicationST.xml
	String path = "classpath:applicationST.xml"; //경로 지정
	GenericXmlApplicationContext ctx= new GenericXmlApplicationContext(path);//path의 파일을 실행하고 해당 bean 값을 ioc컨테이너에 등록한다.
	
	STBean stb = ctx.getBean("stb", STBean.class); //Bean을 가져올건데, 그것의 자료형이 무엇인지도 써줌. id의 값과 동일하게 적어줘야함.
//	stb.setName("Sua Kim");
//	stb.setAge(30);
	
	stb.namePrint();
	stb.agePrint();
}
}
