package com.gezi.hdlw.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gezi.hdlw.example.sys.LwAdminExample;
import com.gezi.hdlw.vo.sys.LwAdmin;

public interface LwAdminMapper {
	long countByExample(LwAdminExample example);

	int deleteByExample(LwAdminExample example);

	int deleteByPrimaryKey(Long id);

	int insert(LwAdmin record);

	int insertSelective(LwAdmin record);

	List<LwAdmin> selectByExample(LwAdminExample example);

	List<LwAdmin> customizationSelectByExample(LwAdminExample example);

	LwAdmin selectByPrimaryKey(Long id);

	LwAdmin customizationSelectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") LwAdmin record, @Param("example") LwAdminExample example);

	int updateByExample(@Param("record") LwAdmin record, @Param("example") LwAdminExample example);

	int updateByPrimaryKeySelective(LwAdmin record);

	int updateByPrimaryKey(LwAdmin record);
}