package com.eatsaround.dao.impl;

import java.sql.Timestamp;
import java.util.List;

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
        return sql.selectList(namespace + ".getActivityHistory"); // 統一された履歴を取得
    }

    @Override
    public void activityLogVO(String userId, String activityType, Timestamp activityTime) throws Exception { // 追加
        // INSERT SQLを呼び出して活動を記録する
        sql.insert(namespace + ".activityLogVO", new ActivityLogVO(userId, activityType, activityTime));
    }

}
