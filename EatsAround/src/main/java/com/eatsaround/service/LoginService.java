package com.eatsaround.service;

import org.springframework.stereotype.Service;

import com.eatsaround.vo.LoginRequestVO;
//ログインのビジネスロジックを処理するインターフェース

@Service
public class LoginService {

	// 実際のユーザー認証ロジックをここに実装
	public boolean login(LoginRequestVO loginRequestVO) {
		// DBから取得しここでユーザー名とパスワードの確認を行う）
		String correctUsername = "username"; // 正しいユーザー名
		String correctPassword = "password"; // 正しいパスワード

		return loginRequestVO.getUsername().equals(correctUsername) &&
				loginRequestVO.getPassword().equals(correctPassword);
	}
}
