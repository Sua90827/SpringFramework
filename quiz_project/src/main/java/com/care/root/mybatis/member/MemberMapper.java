package com.care.root.mybatis.member;

import java.util.ArrayList;
import java.util.Map;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {

	public MemberDTO getMemberInfo(String id);

	public ArrayList<MemberDTO> getEveryMemberInfo();

	public MemberDTO getEveryMemberInfo(String user_id);

	public void register(MemberDTO dto);

	public void keepLogin(Map<String, Object> map);

	public MemberDTO getUserSessionId(String sessionId);
}
