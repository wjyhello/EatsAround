package com.eatsaround.service;

import java.util.List;
import java.util.Map;

import com.eatsaround.vo.MemberVO;

public interface AdminService {
	void deleteMember(String userId) throws Exception;

	List<MemberVO> memberList() throws Exception;
	
	int getMemberCount() throws Exception;
	
	int getBlogCount() throws Exception;
	
	List<Map<String, Object>> getLoginHistory() throws Exception;

}
