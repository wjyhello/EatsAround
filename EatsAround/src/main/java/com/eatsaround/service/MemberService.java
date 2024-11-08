package com.eatsaround.service;

import javax.servlet.http.HttpSession;

import com.eatsaround.vo.MemberVO;

public interface MemberService {

	void signup(MemberVO vo) throws Exception; //회원가입 시그니처
	
	public MemberVO signin(MemberVO vo) throws Exception; //로그인 시그니처
	
	public void signout(HttpSession session)throws Exception;

}
