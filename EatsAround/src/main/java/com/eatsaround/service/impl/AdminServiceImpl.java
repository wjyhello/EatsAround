package com.eatsaround.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.eatsaround.dao.AdminDAO;
import com.eatsaround.service.AdminService;
import com.eatsaround.vo.MemberVO;

@Service
public class AdminServiceImpl implements AdminService {
	
    // AdminDAOをインジェクションし、データベース操作を委譲
    @Inject
    private AdminDAO dao;

    // メンバーを物理削除するサービスメソッド
    @Override
    public void deleteMember(String userId) throws Exception {
        dao.deleteMember(userId);
    }

    // 全メンバー数を取得するサービスメソッド
    @Override
    public int getMemberCount() throws Exception {
        return dao.getMemberCount();
    }

    // 全ブログ数を取得するサービスメソッド
    @Override
    public int getBlogCount() throws Exception {
        return dao.getBlogCount();
    }

    // メンバーのログイン履歴を取得するサービスメソッド
    @Override
    public List<Map<String, Object>> getLoginHistory() throws Exception {
        return dao.getLoginHistory();
    }

    // 検索キーワードに基づくメンバーリストを取得するサービスメソッド
    @Override
    public List<MemberVO> searchMember(String search) throws Exception {
        return dao.searchMember(search);
    }

    // ページネーションに対応したメンバーリストを取得するサービスメソッド
    @Override
    public List<MemberVO> getMemberList(Map<String, Integer> params) throws Exception {
        return dao.getMemberList(params);
    }
}
