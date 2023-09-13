package com.care.root.mybatis;

import java.util.List;

import com.care.root.dto.FileDTO;

public interface FileMapper {

	void saveData(FileDTO dto);

	public List<FileDTO> getData();

}
