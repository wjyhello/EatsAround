package com.eatsaround.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.eatsaround.dao.ActivityLogDAO;
import com.eatsaround.vo.ActivityLogVO;

@Repository
public class ActivityLogDAOImpl implements ActivityLogDAO {

    @Inject
    private SqlSession sql;

    private static String namespace = "com.eatsaround.EaSql.activityLogMapper";

    @Override
    public List<ActivityLogVO> getActivityHistory() throws Exception {
        return sql.selectList(namespace + ".getActivityHistory"); // 統一履歴を取得
    }

    @Override
    public void activityLogVO(String userId, String activityType, Timestamp activityTime) throws Exception {
        sql.insert(namespace + ".activityLogVO", new ActivityLogVO(userId, activityType, activityTime)); // 活動記録
    }

    @Override
    public List<ActivityLogVO> getActivityHistory(Map<String, Object> params) throws Exception {
        return sql.selectList(namespace + ".getActivityHistory", params); // 検索・ページネーション付き
    }

    @Override
    public int getActivityHistoryCount(Map<String, Object> params) throws Exception {
        return sql.selectOne(namespace + ".getActivityHistoryCount", params); // 件数取得
    }
}
