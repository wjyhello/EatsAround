package com.eatsaround.service;

import java.sql.Timestamp;
import java.util.List;

import com.eatsaround.vo.ActivityLogVO;

public interface ActivityLogService {
	List<ActivityLogVO> getActivityHistory() throws Exception; // 統合履歴を取得するメソッド
	void activityLogVO(String userId, String activityType, Timestamp activityTime) throws Exception;
}
