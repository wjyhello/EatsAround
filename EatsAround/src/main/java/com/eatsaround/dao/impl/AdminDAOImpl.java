package com.eatsaround.dao.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.eatsaround.dao.AdminDAO;
import com.eatsaround.vo.MemberVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
    private static final Logger logger = LoggerFactory.getLogger(AdminDAOImpl.class);
    
    // MyBatisのSqlSessionをインジェクションしてデータベース操作を行う
    @Inject
    private SqlSession sql;

    // MyBatisのマッパーのnamespaceを設定
    private static String namespace = "com.eatsaround.EaSql.adminMapper";

    // メンバーを物理削除するメソッド
    @Override
    public void deleteMember(String userId) throws Exception {
        // 指定されたユーザーIDに対応するメンバーを削除するSQLを実行
        sql.delete(namespace + ".deleteMember", userId);
    }

    // 全メンバーの総数を取得するメソッド
    @Override
    public int getMemberCount() throws Exception {
        // 全メンバーの件数を取得するSQLを実行
        return sql.selectOne(namespace + ".getMemberCount");
    }

    // 全ブログの総数を取得するメソッド
    @Override
    public int getBlogCount() throws Exception {
        // 全ブログの件数を取得するSQLを実行
        return sql.selectOne(namespace + ".getBlogCount");
    }

    // メンバーのログイン履歴を取得するメソッド
    @Override
    public List<Map<String, Object>> getLoginHistory() throws Exception {
        // ログイン履歴を取得するSQLを実行し、リストで返す
        return sql.selectList(namespace + ".getLoginHistory");
    }

    // メンバーをキーワードで検索するメソッド
    @Override
    public List<MemberVO> searchMember(String search) throws Exception {
        // 検索キーワードに基づいてメンバーリストを取得するSQLを実行
    	return sql.selectList(namespace + ".searchMember", search);
    }

    // ページネーションに対応したメンバーリストを取得するメソッド
    @Override
    public List<MemberVO> getMemberList(Map<String, Integer> params) throws Exception {
        // 指定されたページ範囲のメンバーリストを取得するSQLを実行
    	return sql.selectList(namespace + ".getMemberList", params);
    }
}
