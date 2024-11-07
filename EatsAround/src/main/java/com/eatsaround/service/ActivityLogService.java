package com.eatsaround.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.eatsaround.vo.ActivityLogVO;

public interface ActivityLogService {
    List<ActivityLogVO> getActivityHistory() throws Exception; // 統一履歴を取得
    void activityLogVO(String userId, String activityType, Timestamp activityTime) throws Exception; // ログ記録
    List<ActivityLogVO> getActivityHistory(Map<String, Object> params) throws Exception; // 検索・ページネーション付き
    int getActivityHistoryCount(Map<String, Object> params) throws Exception; // 件数取得
}
