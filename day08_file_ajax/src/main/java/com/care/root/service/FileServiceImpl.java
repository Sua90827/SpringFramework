package com.care.root.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.dto.FileDTO;
import com.care.root.mybatis.FileMapper;
@Service
public class FileServiceImpl implements FileService {
	@Autowired FileMapper mapper;
	
	public void fileProcess(String id, String name, MultipartFile file) {
		FileDTO dto = new FileDTO();
		dto.setId(id);
		dto.setName(name);
		
		if(file.getSize()!=0) {// !file.isEmpty라고 해도 된다.  //파일이있다면
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			String sysFileName=fo.format(new Date());
			sysFileName += file.getOriginalFilename();
			System.out.println("sysFileNmae : "+sysFileName);  //20230913103116-attendBoard05.png
			File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
			try {
				file.transferTo(saveFile);
				dto.setImgName(sysFileName);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {//파일이 존재하지 않는다면
			dto.setImgName("nan");
		}
		try {
			mapper.saveData(dto);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<FileDTO> getData(){
		List<FileDTO> list = null;
		try {
			list = mapper.getData();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void delete(String file, String id) {
		try {
			int result = mapper.delete(id);
			if(result == 1) {//db가 삭제된 경우.
				File d = new File(IMAGE_REPO+"/"+file);
				if(d.exists()) {
				d.delete(); //이미지도 삭제하겠다.
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifyDo(FileDTO dto, MultipartFile inputfile) {
		/**
		 (file로 들어온 값이 있으면)
		 =>db에 저장되어 있는 파일 이름 이용해서 폴더에 저장되어 있는 사진 삭제하고
		 =>새로운 사진 다시 넣어주기.
		 =>db에서 file도 업데이트
		 	UPDATE -- SET name=name, imgname=imgname WHERE id=id
		 
		 (file로 들어온 값이 없으면, 선택을 안했다면)
		 =>db에 저장되어 있는 파일이름 이용해서 폴더에 저장되어 있는 사진 삭제.
		 =>db에서 file명은 "nan"으로 변경
		 	UPDATE -- SET name=name, imgname='nan' WHERE id=id;
		 */
		FileDTO db = new FileDTO();
		db = mapper.selectImgName(dto);
		String storedImgName = db.getImgName();
		File previousPath = new File(IMAGE_REPO+"/"+storedImgName);
		System.out.println("storedImgName  "+storedImgName);
		System.out.println("previousPath  "+previousPath);
		if(inputfile.getSize()!=0) {
			if(storedImgName !="nan") {
				previousPath.delete(); //폴더 내부 이미지도 삭제하겠다.
			}
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			String newFileName=fo.format(new Date());
			newFileName += inputfile.getOriginalFilename();
			File newPath = new File(IMAGE_REPO+"/"+newFileName);
			
			try {
				inputfile.transferTo(newPath);
				dto.setImgName(newFileName);
				mapper.modifyDo(dto);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {//선택된 파일이 없으면,
			if(storedImgName !="nan") {
				previousPath.delete();
			}
			try {
				dto.setImgName("nan");
				mapper.modifyDo(dto);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
