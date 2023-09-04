package com.care.di03;

public class DBClass {
	String id , pwd;

	public DBClass() {
		//기본 생성자
	}
	public DBClass(String id, String pwd) {
		this.id=id;
		this.pwd=pwd;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
