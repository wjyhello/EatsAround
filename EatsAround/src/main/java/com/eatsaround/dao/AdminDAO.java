package com.eatsaround.dao;

import java.util.List;

import com.eatsaround.vo.MemberVO;

public interface AdminDAO {

	public void deleteMember(String userId) throws Exception;

	public List<MemberVO> getMemberList() throws Exception;

	public int getMemberCount() throws Exception;
	
	int getBoardCount() throws Exception;

}
