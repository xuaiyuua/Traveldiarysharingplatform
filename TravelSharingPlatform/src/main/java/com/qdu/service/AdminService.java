package com.qdu.service;

import com.qdu.pojo.*;


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

    List<Activity_participant> getParticipantLikeId(String userid);

    //根据手机号模糊查询
    List<Group_travel_activity> getActivityLikeTitle(String activitytitle);

    void deleteActivity(int activityId);

    void deleteParticipant(int participantId);
}
