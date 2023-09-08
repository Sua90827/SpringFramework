package com.care.root.mybatis.member;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {

	public MemberDTO getMemberInfo(String id);

	public ArrayList<MemberDTO> getEveryMemberInfo();

	public MemberDTO getEveryMemberInfo(String user_id);

	public void register(MemberDTO dto);

}
