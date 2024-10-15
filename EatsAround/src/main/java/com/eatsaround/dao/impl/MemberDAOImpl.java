package com.eatsaround.dao.impl;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.eatsaround.dao.MemberDAO;
import com.eatsaround.vo.MemberVO;

@Repository // Springが管理するBeanとして登録
public class MemberDAOImpl implements MemberDAO{

    private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
    
    @Inject
    private SqlSession sql;
    
    // mapper
    private static String namespace = "com.eatsaround.EaSql.EaMapper";
    
    @Override // 회원가입
    public void signup(MemberVO vo) throws Exception {
        try {
            sql.insert(namespace + ".signup", vo);
            logger.info("회원가입 성공: {}", vo);
        } catch (Exception e) {
            logger.error("회원가입 실패", e);
            throw e;
        }
    }

    @Override // 로그인
    public MemberVO signin(MemberVO vo) throws Exception {
        MemberVO member = null;
        try {
            member = sql.selectOne(namespace + ".signin", vo);
            logger.info("로그인 성공: {}", vo);
        } catch (Exception e) {
            logger.error("로그인 실패", e);
            throw e;
        }
        return member;
    }
}
