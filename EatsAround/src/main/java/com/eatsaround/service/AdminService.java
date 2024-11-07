package com.eatsaround.service;

import java.util.List;
import java.util.Map;

import com.eatsaround.vo.MemberVO;

public interface AdminService {
    void deleteMember(String userId) throws Exception; // メンバーを物理削除するメソッド
    int getMemberCount() throws Exception; // 全メンバーの総数を取得するメソッド
    int getBlogCount() throws Exception; // ブログ投稿の総数を取得するメソッド
    List<Map<String, Object>> getLoginHistory() throws Exception; // ログイン履歴を取得するメソッド
    List<MemberVO> searchMember(String search) throws Exception; // 検索キーワードに基づいてメンバーを検索するメソッド
    List<MemberVO> getMemberList(Map<String, Integer> params) throws Exception; // ページネーションに対応したメンバーリストを取得するメソッド

}
