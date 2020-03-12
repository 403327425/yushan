package com.gezi.GS.service.sys.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.GS.example.sys.ScoreListExample;
import com.gezi.GS.service.AbstraceService;
import com.gezi.GS.service.sys.ScoreListService;
import com.gezi.GS.vo.sys.ScoreList;
import com.thoughtworks.xstream.mapper.Mapper.Null;
@Service
@Transactional
public class ScoreListServiceImpl extends AbstraceService implements ScoreListService {

	@Override
	public Long getMyScore(Long userId) {
		// TODO Auto-generated method stub
		ScoreListExample example=new ScoreListExample();
		ScoreListExample.Criteria criteria=example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andReservedFieldsEqualTo("new");
		List<ScoreList>list=scoreListMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0).getScore();
		}
		return (long) 0;
		
	}

	@Override
	public int updScoreList(ScoreList scoreList) {
		// TODO Auto-generated method stub
		ScoreListExample example=new ScoreListExample();
		ScoreListExample.Criteria criteria=example.createCriteria();
		criteria.andUserIdEqualTo(scoreList.getUserId());
		criteria.andReservedFieldsEqualTo("new");
		List<ScoreList>list=scoreListMapper.selectByExample(example);
		if(list.size()>0){
			list.get(0).setReservedFields("old");
			scoreListMapper.updateByPrimaryKey(list.get(0));
			
			scoreList.setScore(scoreList.getScore()+list.get(0).getScore());
			scoreList.setCreateTime(new Date());
			return scoreListMapper.insert(scoreList);
		}else{
			scoreList.setCreateTime(new Date());
			return scoreListMapper.insert(scoreList);
		}
	}
	

	
}
