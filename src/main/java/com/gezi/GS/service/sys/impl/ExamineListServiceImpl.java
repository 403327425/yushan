package com.gezi.GS.service.sys.impl;

import org.springframework.stereotype.Service;

import com.gezi.GS.example.sys.ExamineListExample;
import com.gezi.GS.service.AbstraceService;
import com.gezi.GS.service.sys.ExamineListService;
import com.gezi.GS.vo.sys.ExamineList;
@Service
public class ExamineListServiceImpl extends AbstraceService implements ExamineListService {

	@Override
	public int add(ExamineList examineList) {
		// TODO Auto-generated method stub
		return examineListMapper.insert(examineList);
	}

	@Override
	public ExamineList selectByUrl(String examineUrl) {
		// TODO Auto-generated method stub
		ExamineListExample example =new ExamineListExample();
		ExamineListExample.Criteria criteria=example.createCriteria();
		criteria.andExamineUrlEqualTo(examineUrl);
		
		return examineListMapper.selectByExample(example).get(0);
	}

	@Override
	public ExamineList getById(Integer examineId) {
		// TODO Auto-generated method stub
		return examineListMapper.selectByPrimaryKey(examineId);
	}

	@Override
	public int updByMsg(Integer examineId, String msg) {
		// TODO Auto-generated method stub
		
		ExamineList examineList=examineListMapper.selectByPrimaryKey(examineId);
		if(msg.equals("noPass")){
			examineList.setState(4);
			return examineListMapper.updateByPrimaryKey(examineList);
		}else if(msg.equals("pass")){
			examineList.setState(3);
			return examineListMapper.updateByPrimaryKey(examineList);
		}else{
			return 0;
		}
	}
}
