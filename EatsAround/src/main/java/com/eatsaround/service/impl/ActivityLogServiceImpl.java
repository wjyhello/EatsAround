package com.eatsaround.service.impl;

import java.sql.Timestamp;
import java.util.List;

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
        return dao.getActivityHistory(); // 統一された履歴を取得
    }

    @Override
    public void activityLogVO(String userId, String activityType, Timestamp activityTime) throws Exception { // 追加
        dao.activityLogVO(userId, activityType, activityTime);
    }

}
