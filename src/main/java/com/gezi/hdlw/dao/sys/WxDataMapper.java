package com.gezi.hdlw.dao.sys;

import com.gezi.hdlw.vo.sys.WxData;
import com.gezi.hdlw.example.sys.WxDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxDataMapper {
    long countByExample(WxDataExample example);

    int deleteByExample(WxDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxData record);

    int insertSelective(WxData record);

    List<WxData> selectByExample(WxDataExample example);

    WxData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxData record, @Param("example") WxDataExample example);

    int updateByExample(@Param("record") WxData record, @Param("example") WxDataExample example);

    int updateByPrimaryKeySelective(WxData record);

    int updateByPrimaryKey(WxData record);
}