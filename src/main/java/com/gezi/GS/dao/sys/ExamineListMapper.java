package com.gezi.GS.dao.sys;

import com.gezi.GS.vo.sys.ExamineList;
import com.gezi.GS.example.sys.ExamineListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamineListMapper {
    long countByExample(ExamineListExample example);

    int deleteByExample(ExamineListExample example);

    int deleteByPrimaryKey(Integer examineId);

    int insert(ExamineList record);

    int insertSelective(ExamineList record);

    List<ExamineList> selectByExample(ExamineListExample example);

    ExamineList selectByPrimaryKey(Integer examineId);

    int updateByExampleSelective(@Param("record") ExamineList record, @Param("example") ExamineListExample example);

    int updateByExample(@Param("record") ExamineList record, @Param("example") ExamineListExample example);

    int updateByPrimaryKeySelective(ExamineList record);

    int updateByPrimaryKey(ExamineList record);
}