package com.gezi.GS.dao.sys;

import com.gezi.GS.vo.sys.ScoreList;
import com.gezi.GS.example.sys.ScoreListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreListMapper {
    long countByExample(ScoreListExample example);

    int deleteByExample(ScoreListExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ScoreList record);

    int insertSelective(ScoreList record);

    List<ScoreList> selectByExample(ScoreListExample example);

    ScoreList selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ScoreList record, @Param("example") ScoreListExample example);

    int updateByExample(@Param("record") ScoreList record, @Param("example") ScoreListExample example);

    int updateByPrimaryKeySelective(ScoreList record);

    int updateByPrimaryKey(ScoreList record);
}