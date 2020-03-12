package com.gezi.GS.dao.sys;

import com.gezi.GS.vo.sys.TaskTypeList;
import com.gezi.GS.example.sys.TaskTypeListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskTypeListMapper {
    long countByExample(TaskTypeListExample example);

    int deleteByExample(TaskTypeListExample example);

    int deleteByPrimaryKey(Integer taskTypeId);

    int insert(TaskTypeList record);

    int insertSelective(TaskTypeList record);

    List<TaskTypeList> selectByExample(TaskTypeListExample example);

    TaskTypeList selectByPrimaryKey(Integer taskTypeId);

    int updateByExampleSelective(@Param("record") TaskTypeList record, @Param("example") TaskTypeListExample example);

    int updateByExample(@Param("record") TaskTypeList record, @Param("example") TaskTypeListExample example);

    int updateByPrimaryKeySelective(TaskTypeList record);

    int updateByPrimaryKey(TaskTypeList record);
}