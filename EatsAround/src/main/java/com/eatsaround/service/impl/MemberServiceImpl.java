package com.eatsaround.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.eatsaround.dao.MemberDAO;
import com.eatsaround.service.MemberService;
import com.eatsaround.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject 
	private MemberDAO dao;
	
	//회원가입
	@Override
	public void signup(MemberVO vo) throws Exception {
		dao.signup(vo);		
	}

	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return dao.signin(vo);
	}

}
