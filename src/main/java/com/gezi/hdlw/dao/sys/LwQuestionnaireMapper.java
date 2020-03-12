package com.gezi.hdlw.dao.sys;

import com.gezi.hdlw.vo.sys.LwQuestionnaire;
import com.gezi.hdlw.example.sys.LwQuestionnaireExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LwQuestionnaireMapper {
    long countByExample(LwQuestionnaireExample example);

    int deleteByExample(LwQuestionnaireExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LwQuestionnaire record);

    int insertSelective(LwQuestionnaire record);

    List<LwQuestionnaire> selectByExample(LwQuestionnaireExample example);

    LwQuestionnaire selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LwQuestionnaire record, @Param("example") LwQuestionnaireExample example);

    int updateByExample(@Param("record") LwQuestionnaire record, @Param("example") LwQuestionnaireExample example);

    int updateByPrimaryKeySelective(LwQuestionnaire record);

    int updateByPrimaryKey(LwQuestionnaire record);
}