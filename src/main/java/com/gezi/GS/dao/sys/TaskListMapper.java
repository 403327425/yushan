package com.gezi.GS.dao.sys;

import com.gezi.GS.vo.sys.TaskList;
import com.gezi.GS.example.sys.TaskListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskListMapper {
    long countByExample(TaskListExample example);

    int deleteByExample(TaskListExample example);

    int deleteByPrimaryKey(Integer taskId);

    int insert(TaskList record);

    int insertSelective(TaskList record);

    List<TaskList> selectByExample(TaskListExample example);

    TaskList selectByPrimaryKey(Integer taskId);

    int updateByExampleSelective(@Param("record") TaskList record, @Param("example") TaskListExample example);

    int updateByExample(@Param("record") TaskList record, @Param("example") TaskListExample example);

    int updateByPrimaryKeySelective(TaskList record);

    int updateByPrimaryKey(TaskList record);
}