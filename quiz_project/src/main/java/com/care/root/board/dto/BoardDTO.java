package com.care.root.board.dto;

public class BoardDTO {
	private int writeNo;
	private String title;
	private String content;
	private String saveDate;
	private int hit;
	private String imagineFileName;
	private String id;
	public int getWriteNo() {
		return writeNo;
	}
	public void setWriteNo(int writeNo) {
		this.writeNo = writeNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSaveDate() {
		return saveDate;
	}
	public void setSaveDate(String saveDate) {
		this.saveDate = saveDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getImagineFileName() {
		return imagineFileName;
	}
	public void setImagineFileName(String imagineFileName) {
		this.imagineFileName = imagineFileName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
