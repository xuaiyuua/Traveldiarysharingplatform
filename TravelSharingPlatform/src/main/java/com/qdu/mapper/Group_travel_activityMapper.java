package com.qdu.mapper;

import com.qdu.pojo.Group_travel_activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Group_travel_activityMapper {
    int deleteByPrimaryKey(Integer activityId);

    int insert(Group_travel_activity row);

    Group_travel_activity selectByPrimaryKey(Integer activityId);

    List<Group_travel_activity> selectAll();

    int updateByPrimaryKey(Group_travel_activity row);

    List<Group_travel_activity> selectByActivityUseridLike(@Param("user_id") String userid);

    List<Group_travel_activity> selectByActivityTitleidLike(@Param("activity_title") String activitytitle);
}