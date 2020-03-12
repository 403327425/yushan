package com.gezi.hdlw.dao.sys;

import com.gezi.hdlw.vo.sys.LwCandidate;
import com.gezi.hdlw.example.sys.LwCandidateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LwCandidateMapper {
    long countByExample(LwCandidateExample example);

    int deleteByExample(LwCandidateExample example);

    int deleteByPrimaryKey(Long candidateId);

    int insert(LwCandidate record);

    int insertSelective(LwCandidate record);

    List<LwCandidate> selectByExample(LwCandidateExample example);
    
    List<Object> selectPersonActivityCandidateList (Long activityId);

    LwCandidate selectByPrimaryKey(Long candidateId);

    int updateByExampleSelective(@Param("record") LwCandidate record, @Param("example") LwCandidateExample example);

    int updateByExample(@Param("record") LwCandidate record, @Param("example") LwCandidateExample example);

    int updateByPrimaryKeySelective(LwCandidate record);

    int updateByPrimaryKey(LwCandidate record);
}