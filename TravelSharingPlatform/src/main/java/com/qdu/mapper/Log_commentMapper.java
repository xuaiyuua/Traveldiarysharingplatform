package com.qdu.mapper;

import com.qdu.pojo.Log_comment;
import java.util.List;

public interface Log_commentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Log_comment row);

    Log_comment selectByPrimaryKey(Integer commentId);

    List<Log_comment> selectAll();

    int updateByPrimaryKey(Log_comment row);

    List<Log_comment> selectByLogId(int logid);
}