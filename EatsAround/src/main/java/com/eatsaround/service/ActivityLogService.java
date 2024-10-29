package com.eatsaround.service;

import java.sql.Timestamp;
import java.util.List;

import com.eatsaround.vo.ActivityLogVO;

public interface ActivityLogService {
    List<ActivityLogVO> getLoginHistory() throws Exception;
    List<ActivityLogVO> getLogoutHistory() throws Exception;
	void logActivityVO(String userId, String activityType, Timestamp activityTime) throws Exception;
}
