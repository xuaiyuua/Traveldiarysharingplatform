package com.qdu.mapper;

import com.qdu.pojo.Admin;
import com.qdu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User selectByUsername(String username);

    int deleteByPrimaryKey(Integer userId);

    int insert(User row);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User row);

    List<User> selectByUsernameLike(@Param("username") String username);
    //根据手机号模糊查询用户

    List<User> selectByPhoneLike(@Param("phone_number") String phoneNumber);

    User selectUser(@Param("username") String username, @Param("password") String password);

    int updateByUsername(User user);

    void changePwdByUsername(@Param("username") String username,@Param("password") String password);

}