package com.care.root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.care.root.dto.InfoDTO;
import com.care.root.service.InfoService;

@RestController //jsp가 아닌, 데이터를 return으로 돌려주는 controller. 여기에서는 @reponsebody를 생략할 수 있다. 
public class AjaxRestController {
	
	@GetMapping(value="rest",
			produces="application/text; charset=utf-8")
	public String get() {
		return "get: 데이터 요청 시 사용";
	}
	
	@PostMapping(value="rest",
			produces="application/text; charset=utf-8")
	public String post() {
		return "post: 데이터 추가 시 사용";
	}
	
	@PutMapping(value="rest",
			produces="application/text; charset=utf-8")
	public String put() {
		return "put: 데이터 수정 시 사용";
	}
	
	@DeleteMapping(value="rest",
			produces="application/text; charset=utf-8")
	public String del() {
		return "delete: 데이터 삭제 시 사용";
	}
	
	@Autowired InfoService is;
	@GetMapping(value="users", produces = "application/json; charset=utf-8")
	public List<InfoDTO> users(){
		return is.getList();
	}
	
	@GetMapping(value="getUser", produces = "application/json; charset=utf-8")
	public InfoDTO getUser(@RequestParam String id) {
		return is.getUser( id );
	}
	@GetMapping(value="getUser/{name}", produces = "application/json; charset=utf-8")
	public InfoDTO getUser2(@PathVariable (value="name") String id) {
		System.out.println("dlskjlkjdslj"+id);
		return is.getUser( id );
	}
	@PutMapping(value="modify", produces = "application/json; charset=utf-8")
	public int modify(@RequestBody InfoDTO dto) {
		int result = is.modify( dto );
		return 1;
	}
	@PostMapping(value="insert", produces = "application/json; charset=utf-8")
	public int insert(@RequestBody InfoDTO dto) { //Map map 으로 받아도 상관없음.
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		int result = is.insert( dto );
		return 1;
	}
	@DeleteMapping(value="delete/{uId}", produces = "application/json; charset=utf-8")
	public void delete(@PathVariable String uId) { 
		System.out.println(uId);
		is.delete( uId );

	}
}
