package com.qdu.service.impl;

import com.qdu.mapper.Group_travel_activityMapper;
import com.qdu.mapper.Travel_logMapper;
import com.qdu.pojo.Admin;
import com.qdu.pojo.Group_travel_activity;
import com.qdu.pojo.Travel_log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements com.qdu.service.AdminService{

    @Autowired
    private com.qdu.mapper.AdminMapper adminMapper;

    @Autowired
    private com.qdu.mapper.Travel_logMapper travelLogMapper;

    @Autowired
    private Group_travel_activityMapper groupTravelActivityMapper;

    @Override
    public Admin selectAdmin(String adminname, String password) {
        return adminMapper.selectAdmin(adminname, password);
    }

    @Override
    public List<Travel_log> getAllLog() {
        return travelLogMapper.selectAll();
    }

    @Override
    public List<Travel_log> getLogLikeId(String userid) {
        return travelLogMapper.selectByUseridLike(userid);
    }

    @Override
    public List<Travel_log> getLogLikeTitle(String logtitle) {
        return travelLogMapper.selectByTitleLike(logtitle);
    }

    @Override
    public void deleteLog(int logId) {
        travelLogMapper.deleteByPrimaryKey(logId);
    }

    public List<Group_travel_activity> getAllActivity() {
        return groupTravelActivityMapper.selectAll();
    }

    @Override
    public List<Group_travel_activity> getActivityLikeId(String userid) {
        return groupTravelActivityMapper.selectByActivityUseridLike(userid);
    }

    @Override
    public List<Group_travel_activity> getActivityLikeTitle(String activitytitle) {
        return groupTravelActivityMapper.selectByActivityTitleidLike(activitytitle);
    }

    @Override
    public void deleteActivity(int activityId) {
        groupTravelActivityMapper.deleteByPrimaryKey(activityId);
    }
}
