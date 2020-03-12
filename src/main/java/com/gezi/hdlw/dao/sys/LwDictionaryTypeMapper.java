package com.gezi.hdlw.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gezi.hdlw.example.sys.LwDictionaryTypeExample;
import com.gezi.hdlw.vo.sys.LwDictionaryType;

public interface LwDictionaryTypeMapper {
    long countByExample(LwDictionaryTypeExample example);

    int deleteByExample(LwDictionaryTypeExample example);

    int deleteByPrimaryKey(Integer dtkId);

    int insert(LwDictionaryType record);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertSelective(LwDictionaryType record);

    /**
     * 查询 or 条件查询
     * @param example
     * @return
     */
    List<LwDictionaryType> selectByExample(LwDictionaryTypeExample example);

    /**
     * 根据id查询
     * @param dtkId
     * @return
     */
    LwDictionaryType selectByPrimaryKey(Integer dtkId);

    int updateByExampleSelective(@Param("record") LwDictionaryType record, @Param("example") LwDictionaryTypeExample example);

    int updateByExample(@Param("record") LwDictionaryType record, @Param("example") LwDictionaryTypeExample example);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(LwDictionaryType record);

    int updateByPrimaryKey(LwDictionaryType record);
}