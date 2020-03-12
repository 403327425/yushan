package com.gezi.GS.dao.sys;

import com.gezi.GS.vo.sys.MyPlanList;
import com.gezi.GS.example.sys.MyPlanListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyPlanListMapper {
    long countByExample(MyPlanListExample example);

    int deleteByExample(MyPlanListExample example);

    int deleteByPrimaryKey(Integer myPlanId);

    int insert(MyPlanList record);

    int insertSelective(MyPlanList record);

    List<MyPlanList> selectByExample(MyPlanListExample example);

    MyPlanList selectByPrimaryKey(Integer myPlanId);

    int updateByExampleSelective(@Param("record") MyPlanList record, @Param("example") MyPlanListExample example);

    int updateByExample(@Param("record") MyPlanList record, @Param("example") MyPlanListExample example);

    int updateByPrimaryKeySelective(MyPlanList record);

    int updateByPrimaryKey(MyPlanList record);
}