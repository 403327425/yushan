package com.gezi.GS.dao.sys;

import com.gezi.GS.vo.sys.PerformList;
import com.gezi.GS.example.sys.PerformListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PerformListMapper {
    long countByExample(PerformListExample example);

    int deleteByExample(PerformListExample example);

    int deleteByPrimaryKey(Long performId);

    int insert(PerformList record);

    int insertSelective(PerformList record);

    List<PerformList> selectByExample(PerformListExample example);

    PerformList selectByPrimaryKey(Long performId);

    int updateByExampleSelective(@Param("record") PerformList record, @Param("example") PerformListExample example);

    int updateByExample(@Param("record") PerformList record, @Param("example") PerformListExample example);

    int updateByPrimaryKeySelective(PerformList record);

    int updateByPrimaryKey(PerformList record);
}