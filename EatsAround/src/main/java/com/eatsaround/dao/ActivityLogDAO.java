package com.eatsaround.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.eatsaround.vo.ActivityLogVO;

public interface ActivityLogDAO {
    List<ActivityLogVO> getActivityHistory() throws Exception; // 統一履歴を取得するメソッド
    void activityLogVO(String userId, String activityType, Timestamp activityTime) throws Exception; // ログ挿入
    List<ActivityLogVO> getActivityHistory(Map<String, Object> params) throws Exception; // 検索・ページネーション付き
    int getActivityHistoryCount(Map<String, Object> params) throws Exception; // 検索結果の件数を取得
}
