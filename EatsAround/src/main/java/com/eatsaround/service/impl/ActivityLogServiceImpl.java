package com.eatsaround.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.eatsaround.dao.ActivityLogDAO;
import com.eatsaround.service.ActivityLogService;
import com.eatsaround.vo.ActivityLogVO;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    @Inject
    private ActivityLogDAO dao;

    @Override
    public List<ActivityLogVO> getActivityHistory() throws Exception {
        return dao.getActivityHistory(); // 統一履歴を取得
    }

    @Override
    public void activityLogVO(String userId, String activityType, Timestamp activityTime) throws Exception {
        dao.activityLogVO(userId, activityType, activityTime); // 活動記録
    }

    @Override
    public List<ActivityLogVO> getActivityHistory(Map<String, Object> params) throws Exception {
        return dao.getActivityHistory(params); // 検索・ページネーション付き
    }

    @Override
    public int getActivityHistoryCount(Map<String, Object> params) throws Exception {
        return dao.getActivityHistoryCount(params); // 件数取得
    }
}
