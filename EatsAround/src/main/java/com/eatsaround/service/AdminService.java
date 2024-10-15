package com.eatsaround.service;

import java.util.List;

import com.eatsaround.vo.MemberVO;

public interface AdminService {
	void deleteMember(String userId) throws Exception;

	List<MemberVO> memberList() throws Exception;
}
