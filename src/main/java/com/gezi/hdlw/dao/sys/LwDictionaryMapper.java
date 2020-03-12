package com.gezi.hdlw.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gezi.hdlw.example.sys.LwDictionaryExample;
import com.gezi.hdlw.vo.sys.LwDictionary;

public interface LwDictionaryMapper {
    long countByExample(LwDictionaryExample example);

    int deleteByExample(LwDictionaryExample example);

    int deleteByPrimaryKey(Integer dkId);

    int insert(LwDictionary record);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertSelective(LwDictionary record);

    /**
     * 查询 or 条件查询
     * @param example
     * @return
     */
    List<LwDictionary> selectByExample(LwDictionaryExample example);

    /**
     * 根据id查询
     * @param dkId
     * @return
     */
    LwDictionary selectByPrimaryKey(Integer dkId);

    int updateByExampleSelective(@Param("record") LwDictionary record, @Param("example") LwDictionaryExample example);

    int updateByExample(@Param("record") LwDictionary record, @Param("example") LwDictionaryExample example);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(LwDictionary record);

    int updateByPrimaryKey(LwDictionary record);
}