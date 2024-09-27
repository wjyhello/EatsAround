package com.eatsaround.controller;

//ログインリクエストを処理するクラス

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.eatsaround.service.LoginService; // LoginServiceをインポート
import com.eatsaround.vo.LoginRequestVO; // LoginRequestVOをインポート

/**
 * Handles login requests for the application.
 */
@Controller
public class LoginController {

    @Autowired
    LoginService loginService; // LoginServiceをオートワイヤリング

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    
    // ログインページを表示
    @GetMapping(value = "/login")
    public String getLogin() {
        return "login/login"; // login.jspのパス
    }

    // ログイン処理
    @PostMapping(value = "/login")
    public String postLogin(LoginRequestVO loginRequestVO, Model model) {
        logger.info("Logging in username: {}", loginRequestVO.getUsername());

        boolean isSuccessLogin = loginService.login(loginRequestVO);
        
        if (isSuccessLogin) {
            return "redirect:/home"; // ログイン成功後のリダイレクト先
        }
        
        model.addAttribute("error", "ログインに失敗しました。");
        return "login/login"; // ログインページに戻す
    }
}
