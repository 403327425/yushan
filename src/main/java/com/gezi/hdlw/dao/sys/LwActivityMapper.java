package com.gezi.hdlw.dao.sys;

import com.gezi.hdlw.vo.sys.LwActivity;
import com.gezi.hdlw.example.sys.LwActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LwActivityMapper {
    long countByExample(LwActivityExample example);

    int deleteByExample(LwActivityExample example);

    int deleteByPrimaryKey(Long activityId);

    int insert(LwActivity record);

    int insertSelective(LwActivity record);

    List<LwActivity> selectByExample(LwActivityExample example);

    LwActivity selectByPrimaryKey(Long activityId);

    int updateByExampleSelective(@Param("record") LwActivity record, @Param("example") LwActivityExample example);

    int updateByExample(@Param("record") LwActivity record, @Param("example") LwActivityExample example);

    int updateByPrimaryKeySelective(LwActivity record);

    int updateByPrimaryKey(LwActivity record);
}