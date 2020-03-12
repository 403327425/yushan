package com.gezi.hdlw.dao.common;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gezi.hdlw.example.common.LwEmployeeExample;
import com.gezi.hdlw.vo.common.LwEmployee;

public interface LwEmployeeMapper {
    long countByExample(LwEmployeeExample example);

    int deleteByExample(LwEmployeeExample example);

    /**
     * 删除
     * @param ekId
     * @return
     */
    int deleteByPrimaryKey(Integer ekId);

    int insert(LwEmployee record);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertSelective(LwEmployee record);

    /**
     * 查询 or 条件查询
     * @param example
     * @return
     */
    List<LwEmployee> selectByExample(LwEmployeeExample example);

    /**
     * 根据id查询
     * @param ekId
     * @return
     */
    LwEmployee selectByPrimaryKey(Integer ekId);

    int updateByExampleSelective(@Param("record") LwEmployee record, @Param("example") LwEmployeeExample example);

    int updateByExample(@Param("record") LwEmployee record, @Param("example") LwEmployeeExample example);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(LwEmployee record);

    int updateByPrimaryKey(LwEmployee record);
}