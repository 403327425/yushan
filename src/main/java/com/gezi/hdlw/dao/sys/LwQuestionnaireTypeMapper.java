package com.gezi.hdlw.dao.sys;

import com.gezi.hdlw.vo.sys.LwQuestionnaireType;
import com.gezi.hdlw.example.sys.LwQuestionnaireTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LwQuestionnaireTypeMapper {
    long countByExample(LwQuestionnaireTypeExample example);

    int deleteByExample(LwQuestionnaireTypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(LwQuestionnaireType record);

    int insertSelective(LwQuestionnaireType record);

    List<LwQuestionnaireType> selectByExample(LwQuestionnaireTypeExample example);

    LwQuestionnaireType selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") LwQuestionnaireType record, @Param("example") LwQuestionnaireTypeExample example);

    int updateByExample(@Param("record") LwQuestionnaireType record, @Param("example") LwQuestionnaireTypeExample example);

    int updateByPrimaryKeySelective(LwQuestionnaireType record);

    int updateByPrimaryKey(LwQuestionnaireType record);
}