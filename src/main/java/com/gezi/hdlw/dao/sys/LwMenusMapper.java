package com.gezi.hdlw.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gezi.hdlw.example.sys.LwMenusExample;
import com.gezi.hdlw.vo.sys.LwMenus;

public interface LwMenusMapper {
    long countByExample(LwMenusExample example);

    int deleteByExample(LwMenusExample example);

    int deleteByPrimaryKey(Long menuId);

    int insert(LwMenus record);

    int insertSelective(LwMenus record);

    List<LwMenus> selectByExample(LwMenusExample example);

    LwMenus selectByPrimaryKey(Long menuId);

    int updateByExampleSelective(@Param("record") LwMenus record, @Param("example") LwMenusExample example);

    int updateByExample(@Param("record") LwMenus record, @Param("example") LwMenusExample example);

    int updateByPrimaryKeySelective(LwMenus record);

    int updateByPrimaryKey(LwMenus record);
}