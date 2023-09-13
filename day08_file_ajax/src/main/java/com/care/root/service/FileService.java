package com.care.root.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	public String IMAGE_REPO = "C:\\spring\\image_repo";
	public void fileProcess(String id, String name, MultipartFile file);

}
