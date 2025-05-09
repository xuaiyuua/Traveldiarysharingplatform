package com.qdu.mapper;

import com.qdu.pojo.Group_travel_activity;
import com.qdu.pojo.Travel_log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Travel_logMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(Travel_log row);

    Travel_log selectByPrimaryKey(Integer logId);

    List<Travel_log> selectAll();

    int updateByPrimaryKey(Travel_log row);

    List<Travel_log> selectByUseridLike(@Param("user_id") String userid);

    List<Travel_log> selectByTitleLike(@Param("log_title") String logtitle);

    List<Travel_log> selectRandom();

}