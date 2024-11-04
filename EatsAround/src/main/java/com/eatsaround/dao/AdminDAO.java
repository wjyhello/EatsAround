package com.eatsaround.dao;

import java.util.List;
import java.util.Map;

import com.eatsaround.vo.MemberVO;

public interface AdminDAO {

	public void deleteMember(String userId) throws Exception;

	public List<MemberVO> getMemberList() throws Exception;

	public int getMemberCount() throws Exception;
	
	int getBlogCount() throws Exception;
	
	public List<Map<String, Object>> getLoginHistory() throws Exception;

	public List<MemberVO> getMemberList(String search) throws Exception;

}
