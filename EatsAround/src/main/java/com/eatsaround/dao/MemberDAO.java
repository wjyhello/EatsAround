package com.eatsaround.dao;

import com.eatsaround.vo.MemberVO;

//ユーザー情報をデータベースから取得するためのインターフェース
public interface MemberDAO {
	//회원가입
	public void signup(MemberVO vo) throws Exception;
	
	//로그인
	public MemberVO signin(MemberVO vo) throws Exception;

}
