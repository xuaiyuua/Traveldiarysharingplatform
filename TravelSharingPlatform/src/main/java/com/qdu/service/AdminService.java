package com.qdu.service;

import com.qdu.pojo.Admin;
import com.qdu.pojo.Group_travel_activity;
import com.qdu.pojo.Travel_log;
import com.qdu.pojo.User;


import java.util.List;

public interface AdminService {
    Admin selectAdmin(String adminname, String password);

    List<Travel_log> getAllLog();

    List<Travel_log> getLogLikeId(String userid);

    //根据手机号模糊查询
    List<Travel_log> getLogLikeTitle(String logtitle);

    void deleteLog(int logId);

    List<Group_travel_activity> getAllActivity();

    List<Group_travel_activity> getActivityLikeId(String userid);

    //根据手机号模糊查询
    List<Group_travel_activity> getActivityLikeTitle(String activitytitle);

    void deleteActivity(int activityId);
}
