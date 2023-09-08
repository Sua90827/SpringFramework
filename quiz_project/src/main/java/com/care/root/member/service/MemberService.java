package com.care.root.member.service;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {

	public String loginCh(MemberDTO dto);

	public ArrayList<MemberDTO> getEveryMemberInfo();

	public MemberDTO getMemberInfo(String user_id);

	public void register(MemberDTO dto);

	

}
