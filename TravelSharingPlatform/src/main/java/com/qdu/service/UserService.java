package com.qdu.service;

import com.qdu.pojo.*;

import javax.xml.transform.Result;
import java.util.List;

public interface UserService {

    int check(String username);

    Result addUser(String username, String password, User user);

    User selectUser(String username, String password);

    List<User> getAllUser();

    List<User> getUserLikeName(String username);

    //根据手机号模糊查询
    List<User> getUserLikePhone(String phone);

    void deleteUser(int userId);

    Travel_log getLogById(int logid);

    Group_travel_activity getActivityById(int activityId);

    List<Log_comment> getCommentByLogId(int logid);

    List<Travel_log> getThreeLog();

    User getUserByUsername(String username);

    Result updateByUsername(User user,String username);

    void changepwd(String username, String password);

    void addComment(Log_comment comment);

    void addLog(Travel_log log);

    void addActivity(Group_travel_activity activity);

    void addParticipant(Activity_participant activityParticipant);


}
