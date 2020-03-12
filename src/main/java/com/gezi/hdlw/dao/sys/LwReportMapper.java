package com.gezi.hdlw.dao.sys;

import com.gezi.hdlw.vo.sys.LwReport;
import com.gezi.hdlw.example.sys.LwReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LwReportMapper {
    long countByExample(LwReportExample example);

    int deleteByExample(LwReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LwReport record);

    int insertSelective(LwReport record);

    List<LwReport> selectByExample(LwReportExample example);

    LwReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LwReport record, @Param("example") LwReportExample example);

    int updateByExample(@Param("record") LwReport record, @Param("example") LwReportExample example);

    int updateByPrimaryKeySelective(LwReport record);

    int updateByPrimaryKey(LwReport record);
}