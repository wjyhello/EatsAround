package com.eatsaround.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.eatsaround.vo.MemberVO;

// 管理者としてのアクセスを制御するインターセプター
public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
        HttpSession session = req.getSession();
        MemberVO member = (MemberVO) session.getAttribute("member");

        // ログインしていない場合
        if (member == null) {
            res.sendRedirect("/member/signin");
            return false;
        }
        
        // 管理者権限の確認
        if (member.getVerify() != 9) {
            res.sendRedirect("/");
            return false;
        }

        return true; // アクセス許可
    }
}
