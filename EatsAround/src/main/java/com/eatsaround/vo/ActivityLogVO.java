package com.eatsaround.vo;

import java.sql.Timestamp;

public class ActivityLogVO {
    private String userId;
    private String activityType;
    private Timestamp activityTime; 

    public ActivityLogVO(String userId, String activityType, Timestamp activityTime) {
        this.userId = userId;
        this.activityType = activityType;
        this.activityTime = activityTime;
    }

    // ゲッターとセッター
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Timestamp getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Timestamp activityTime) {
        this.activityTime = activityTime;
    }
}
