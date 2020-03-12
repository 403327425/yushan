package com.gezi.GS.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.GS.example.sys.PerformListExample;
import com.gezi.GS.service.AbstraceService;
import com.gezi.GS.service.sys.PerformListService;
import com.gezi.GS.vo.sys.PerformList;

import net.coobird.thumbnailator.geometry.Size;
@Service
@Transactional
public class PerformListServiceImpl extends AbstraceService implements PerformListService {

	@Override
	public int addPerform(PerformList performList) {
		// TODO Auto-generated method stub
		return performListMapper.insert(performList);
	}

	@Override
	public int selectPerformByUserIdAndTaskId(Long userId, Integer taskId) {
		// TODO Auto-generated method stub
		PerformListExample example=new PerformListExample();
		PerformListExample.Criteria criteria=example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andTaskIdEqualTo(taskId);
		if(performListMapper.selectByExample(example).size()<=0){
			return -1;
		}else{
			return performListMapper.selectByExample(example).get(0).getState();
		}
		
	}

	@Override
	public PerformList selectPerformByUserIdAndTaskId2(Long userId, Integer taskId) {
		// TODO Auto-generated method stub
		PerformListExample example=new PerformListExample();
		PerformListExample.Criteria criteria=example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andTaskIdEqualTo(taskId);
		criteria.andStateNotEqualTo(0);
		criteria.andStateNotEqualTo(2);
		List<PerformList> list=performListMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		
	}

	@Override
	public int update(PerformList performList) {
		// TODO Auto-generated method stub
		return performListMapper.updateByPrimaryKey(performList);
	}

	@Override
	public PerformList getExamineDetail() {
		// TODO Auto-generated method stub
		PerformListExample example=new PerformListExample();
		PerformListExample.Criteria criteria=example.createCriteria();
		criteria.andStateEqualTo(2);
		List<PerformList> list=performListMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		
	}

	@Override
	public int updByMsg(Long performId, String msg) {
		// TODO Auto-generated method stub
		PerformList performList=performListMapper.selectByPrimaryKey(performId);
		if(performList.getState()!=2){
			return 0;
		}else{
			if(msg.equals("noPass")){
				performList.setState(4);
				return performListMapper.updateByPrimaryKey(performList);
			}else if(msg.equals("pass")){
				performList.setState(3);
				return performListMapper.updateByPrimaryKey(performList);
			}else{
				return -1;
			}
		}
		
	}

	@Override
	public Map getMyTaskSize(Long userId) {
		// TODO Auto-generated method stub
		Map map=new HashMap<String, Object>();
		PerformListExample example=new PerformListExample();
		PerformListExample.Criteria criteria=example.createCriteria();
		criteria.andStateEqualTo(1);
		criteria.andUserIdEqualTo(userId);
		map.put("state1", performListMapper.selectByExample(example).size());
		PerformListExample example2=new PerformListExample();
		PerformListExample.Criteria criteria2=example2.createCriteria();
		criteria2.andStateEqualTo(2);
		criteria2.andUserIdEqualTo(userId);
		map.put("state2", performListMapper.selectByExample(example2).size());
		PerformListExample example3=new PerformListExample();
		PerformListExample.Criteria criteria3=example3.createCriteria();
		criteria3.andStateEqualTo(5);
		criteria3.andUserIdEqualTo(userId);
		map.put("state5", performListMapper.selectByExample(example3).size());
		return map;
	}
	
	
}
