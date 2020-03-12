package com.gezi.hdlw.dao.sys;

import com.gezi.hdlw.vo.sys.LwRecord;
import com.gezi.hdlw.example.sys.LwRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LwRecordMapper {
    long countByExample(LwRecordExample example);

    int deleteByExample(LwRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LwRecord record);

    int insertSelective(LwRecord record);

    List<LwRecord> selectByExample(LwRecordExample example);

    LwRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LwRecord record, @Param("example") LwRecordExample example);

    int updateByExample(@Param("record") LwRecord record, @Param("example") LwRecordExample example);

    int updateByPrimaryKeySelective(LwRecord record);

    int updateByPrimaryKey(LwRecord record);
}