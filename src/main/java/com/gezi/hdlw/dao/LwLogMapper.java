package com.gezi.hdlw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gezi.hdlw.example.LwLogExample;
import com.gezi.hdlw.vo.LwLog;

public interface LwLogMapper {
    long countByExample(LwLogExample example);

    int deleteByExample(LwLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LwLog record);

    int insertSelective(LwLog record);

    List<LwLog> selectByExample(LwLogExample example);

    LwLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LwLog record, @Param("example") LwLogExample example);

    int updateByExample(@Param("record") LwLog record, @Param("example") LwLogExample example);

    int updateByPrimaryKeySelective(LwLog record);

    int updateByPrimaryKey(LwLog record);
}