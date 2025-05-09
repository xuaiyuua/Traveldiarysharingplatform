package com.qdu.service;

import com.qdu.pojo.Admin;
import com.qdu.pojo.Log_comment;
import com.qdu.pojo.Travel_log;
import com.qdu.pojo.User;

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

    List<Log_comment> getCommentByLogId(int logid);

    List<Travel_log> getThreeLog();

    User getUserByUsername(String username);

    Result updateByUsername(User user,String username);

    void changepwd(String username, String password);


}
