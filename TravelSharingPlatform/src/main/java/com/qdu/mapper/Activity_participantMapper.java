package com.qdu.mapper;

import com.qdu.pojo.Activity_participant;
import java.util.List;

public interface Activity_participantMapper {
    int deleteByPrimaryKey(Integer participantId);

    int insert(Activity_participant row);

    Activity_participant selectByPrimaryKey(Integer participantId);

    List<Activity_participant> selectAll();

    int updateByPrimaryKey(Activity_participant row);
}