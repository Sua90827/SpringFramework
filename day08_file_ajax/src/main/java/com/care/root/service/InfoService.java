package com.care.root.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.care.root.dto.InfoDTO;

@Service
public class InfoService {
	Map<String, InfoDTO> DB;
	ArrayList<InfoDTO> list;
	
	public InfoService() {
		DB = new HashMap<String, InfoDTO>();
		list = new ArrayList<InfoDTO>();
		for(int i=0; i<5; i++) {
			InfoDTO dto = new InfoDTO();
			dto.setName("sua" +i);
			dto.setAge(i);
			list.add(dto);
			DB.put("sua"+i, dto);
		}
	}

	public List<InfoDTO> getList() {
		// select * from table;
		return list;
	}

	public InfoDTO getUser(String id) {
		// select * from table where id=id
		return DB.get(id);
	}

	public int modify(InfoDTO dto) { //반환 타입이 int, 받는 타입은 dto
		//update table set
		DB.replace(dto.getName(), dto);
		return 1;
	}

	public int insert(InfoDTO dto) {
		DB.put(dto.getName(), dto);
		list.add(dto);
		return 1;
	}

	public void delete(String uId) {
		DB.remove(uId);
		for(int i=0; i<list.size();i++) {
			InfoDTO dto = list.get(i);
			if(dto.getName().equals(uId)) {
				list.remove(i);
			}
		}
	}


	

}
