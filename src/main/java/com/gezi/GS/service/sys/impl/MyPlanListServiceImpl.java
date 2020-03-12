package com.gezi.GS.service.sys.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.GS.example.sys.MyPlanListExample;
import com.gezi.GS.service.AbstraceService;
import com.gezi.GS.service.sys.MyPlanListService;
import com.gezi.GS.vo.sys.MyPlanList;
@Service
@Transactional
public class MyPlanListServiceImpl extends AbstraceService implements MyPlanListService {

	@Override
	public int addMyPlanList(MyPlanList myPlanList) {
		// TODO Auto-generated method stub
		MyPlanListExample example=new MyPlanListExample();
		MyPlanListExample.Criteria criteria=example.createCriteria();
		criteria.andOpenidEqualTo(myPlanList.getOpenid());
		criteria.andTaskTypeIdEqualTo(myPlanList.getTaskTypeId());
		criteria.andStateEqualTo(1);
		if(myPlanListMapper.selectByExample(example).size()<=0){
			return myPlanListMapper.insert(myPlanList);
		}else{
			return 0;
		}
	}

}
