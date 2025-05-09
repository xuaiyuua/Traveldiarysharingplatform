package com.qdu.mapper;

import com.qdu.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin row);

    Admin selectByPrimaryKey(Integer adminId);

    List<Admin> selectAll();

    int updateByPrimaryKey(Admin row);

    Admin selectAdmin(@Param("adminname") String adminname, @Param("password") String password);
}