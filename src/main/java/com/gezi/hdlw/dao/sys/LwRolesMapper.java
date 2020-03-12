package com.gezi.hdlw.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gezi.hdlw.example.sys.LwRolesExample;
import com.gezi.hdlw.vo.sys.LwRoles;

public interface LwRolesMapper {
    long countByExample(LwRolesExample example);

    int deleteByExample(LwRolesExample example);

    int deleteByPrimaryKey(Long roleId);

    int insert(LwRoles record);

    int insertSelective(LwRoles record);

    List<LwRoles> selectByExample(LwRolesExample example);

    LwRoles selectByPrimaryKey(Long roleId);

    int updateByExampleSelective(@Param("record") LwRoles record, @Param("example") LwRolesExample example);

    int updateByExample(@Param("record") LwRoles record, @Param("example") LwRolesExample example);

    int updateByPrimaryKeySelective(LwRoles record);

    int updateByPrimaryKey(LwRoles record);
}