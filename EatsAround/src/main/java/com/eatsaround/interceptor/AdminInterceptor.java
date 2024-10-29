package com.eatsaround.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.eatsaround.vo.MemberVO;

// 管理者としてのアクセスを制御するインターセプター
public class AdminInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
        HttpSession session = req.getSession();
        MemberVO member = (MemberVO) session.getAttribute("member");

        if (member == null) {
            logger.warn("未ログインユーザーによるアクセスを検出: " + req.getRequestURI());
            res.sendRedirect("/member/signin");
            return false;
        }

        if (member.getVerify() != 9) {
            logger.warn("管理者権限のないユーザーによるアクセスを検出: " + member.getUserId());
            res.sendRedirect("/");
            return false;
        }

        return true; // アクセス許可
    }
}