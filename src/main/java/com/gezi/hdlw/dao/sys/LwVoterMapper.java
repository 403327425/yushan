package com.gezi.hdlw.dao.sys;

import com.gezi.hdlw.vo.sys.LwVoter;
import com.gezi.hdlw.example.sys.LwVoterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LwVoterMapper {
    long countByExample(LwVoterExample example);

    int deleteByExample(LwVoterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LwVoter record);

    int insertSelective(LwVoter record);

    List<LwVoter> selectByExample(LwVoterExample example);

    LwVoter selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LwVoter record, @Param("example") LwVoterExample example);

    int updateByExample(@Param("record") LwVoter record, @Param("example") LwVoterExample example);

    int updateByPrimaryKeySelective(LwVoter record);

    int updateByPrimaryKey(LwVoter record);
}