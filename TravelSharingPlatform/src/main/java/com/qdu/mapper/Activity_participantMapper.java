package com.qdu.mapper;

import com.qdu.pojo.Activity_participant;
import com.qdu.pojo.Group_travel_activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Activity_participantMapper {
    int deleteByPrimaryKey(Integer participantId);

    int insert(Activity_participant row);

    Activity_participant selectByPrimaryKey(Integer participantId);

    List<Activity_participant> selectAll();

    int updateByPrimaryKey(Activity_participant row);

    List<Activity_participant> selectByUseridLike(@Param("user_id") String userid);
}