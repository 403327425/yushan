package com.gezi.hdlw.dao.sys;

import com.gezi.hdlw.vo.sys.StudyData;
import com.gezi.hdlw.example.sys.StudyDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudyDataMapper {
    long countByExample(StudyDataExample example);

    int deleteByExample(StudyDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudyData record);

    int insertSelective(StudyData record);

    List<StudyData> selectByExample(StudyDataExample example);

    StudyData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudyData record, @Param("example") StudyDataExample example);

    int updateByExample(@Param("record") StudyData record, @Param("example") StudyDataExample example);

    int updateByPrimaryKeySelective(StudyData record);

    int updateByPrimaryKey(StudyData record);
}