package com.gezi.hdlw.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gezi.hdlw.example.sys.LwUserBelongsExample;
import com.gezi.hdlw.vo.sys.LwUserBelongs;

public interface LwUserBelongsMapper {
    long countByExample(LwUserBelongsExample example);

    int deleteByExample(LwUserBelongsExample example);

    int deleteByPrimaryKey(Integer ubkId);

    int insert(LwUserBelongs record);

    int insertSelective(LwUserBelongs record);

    List<LwUserBelongs> selectByExample(LwUserBelongsExample example);

    LwUserBelongs selectByPrimaryKey(Integer ubkId);

    int updateByExampleSelective(@Param("record") LwUserBelongs record, @Param("example") LwUserBelongsExample example);

    int updateByExample(@Param("record") LwUserBelongs record, @Param("example") LwUserBelongsExample example);

    int updateByPrimaryKeySelective(LwUserBelongs record);
    
    /**
     * 根据外键修改
     * @param record
     * @return
     */
    int updateByOuterKeySelective(LwUserBelongs record);

    int updateByPrimaryKey(LwUserBelongs record);
}