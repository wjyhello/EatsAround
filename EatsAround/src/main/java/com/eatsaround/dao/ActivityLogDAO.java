package com.eatsaround.dao;

import java.sql.Timestamp;
import java.util.List;

import com.eatsaround.vo.ActivityLogVO;

public interface ActivityLogDAO {
    List<ActivityLogVO> getLoginHistory() throws Exception;
	void logActivityVO(String userId, String activityType, Timestamp activityTime) throws Exception;
}
