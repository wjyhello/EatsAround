package com.eatsaround.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.eatsaround.dao.AdminDAO;
import com.eatsaround.service.AdminService;
import com.eatsaround.vo.MemberVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	private AdminDAO dao;

	// 退会処理
	@Override
	public void deleteMember(String userId) throws Exception {
		dao.deleteMember(userId);
	}

	// メンバーリスト取得
	@Override
	public List<MemberVO> memberList() throws Exception {
		return dao.getMemberList();
	}

	//会員数の取得
	@Override
	public int getMemberCount() throws Exception {
		return dao.getMemberCount();
	}

	@Override
	public int getBoardCount() throws Exception {
		return dao.getBoardCount();
	}

}
