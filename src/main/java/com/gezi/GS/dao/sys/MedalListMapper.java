package com.gezi.GS.dao.sys;

import com.gezi.GS.vo.sys.MedalList;
import com.gezi.GS.example.sys.MedalListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MedalListMapper {
    long countByExample(MedalListExample example);

    int deleteByExample(MedalListExample example);

    int deleteByPrimaryKey(Integer madelId);

    int insert(MedalList record);

    int insertSelective(MedalList record);

    List<MedalList> selectByExample(MedalListExample example);

    MedalList selectByPrimaryKey(Integer madelId);

    int updateByExampleSelective(@Param("record") MedalList record, @Param("example") MedalListExample example);

    int updateByExample(@Param("record") MedalList record, @Param("example") MedalListExample example);

    int updateByPrimaryKeySelective(MedalList record);

    int updateByPrimaryKey(MedalList record);
}