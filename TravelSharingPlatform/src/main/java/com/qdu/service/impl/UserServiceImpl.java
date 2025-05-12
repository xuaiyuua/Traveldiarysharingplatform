package com.qdu.service.impl;

import com.qdu.mapper.Activity_participantMapper;
import com.qdu.mapper.Group_travel_activityMapper;
import com.qdu.mapper.Log_commentMapper;
import com.qdu.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.transform.Result;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements com.qdu.service.UserService{

    @Autowired
    private com.qdu.mapper.UserMapper userMapper;

    @Autowired
    private com.qdu.mapper.Travel_logMapper travelLogMapper;

    @Autowired
    private com.qdu.mapper.Log_commentMapper logCommentMapper;

    @Autowired
    private Group_travel_activityMapper groupTravelActivityMapper;

    @Autowired
    private Activity_participantMapper activityParticipantMapper;


    @Override
    public int check(String username) {
        if (userMapper.selectByUsername(username)==null){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public Result addUser(String username, String password, User user) {
        userMapper.insert(user);
        return null;
    }

    @Override
    public User selectUser(String username, String password) {
        return userMapper.selectUser(username,password);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> getUserLikeName(String username) {
        return userMapper.selectByUsernameLike(username);
    }

    @Override
    public List<User> getUserLikePhone(String phone) {
        return userMapper.selectByPhoneLike(phone);
    }

    @Override
    public void deleteUser(int userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public Travel_log getLogById(int logid) {
        return travelLogMapper.selectByPrimaryKey(logid);
    }

    @Override
    public Group_travel_activity getActivityById(int activityId) {
        return groupTravelActivityMapper.selectByPrimaryKey(activityId);
    }

    @Override
    public List<Log_comment> getCommentByLogId(int logid) {
        return logCommentMapper.selectByLogId(logid);
    }

    @Override
    public List<Travel_log> getThreeLog() {
        return travelLogMapper.selectRandom();
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public Result updateByUsername(User user, String username) {
        userMapper.updateByUsername(user);
        return null;
    }

    @Override
    public void changepwd(String username, String password) {
        userMapper.changePwdByUsername(username,password);
    }

    @Override
    public void addComment(Log_comment comment) {
        logCommentMapper.insert(comment);
    }

    @Override
    public void addLog(Travel_log log) {
        travelLogMapper.insert(log);
    }

    @Override
    public void addActivity(Group_travel_activity activity) {
        groupTravelActivityMapper.insert(activity);
    }

    @Override
    public void addParticipant(Activity_participant activityParticipant) {
        activityParticipantMapper.insert(activityParticipant);
    }

}
