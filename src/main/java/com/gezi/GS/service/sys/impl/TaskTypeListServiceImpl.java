package com.gezi.GS.service.sys.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.GS.example.sys.TaskTypeListExample;
import com.gezi.GS.service.AbstraceService;
import com.gezi.GS.service.sys.TaskTypeListService;
import com.gezi.GS.vo.sys.TaskTypeList;
@Service
@Transactional
public class TaskTypeListServiceImpl extends AbstraceService implements TaskTypeListService {

	@Override
	public int addType(TaskTypeList taskTypeList) {
		// TODO Auto-generated method stub
		
		return taskTypeListMapper.insert(taskTypeList);
	}
	@Override
	public List<TaskTypeList> showType() {
		// TODO Auto-generated method stub
		TaskTypeListExample example =new TaskTypeListExample();
		TaskTypeListExample.Criteria criteria=example.createCriteria();
		criteria.andStateEqualTo(1);
		return taskTypeListMapper.selectByExample(example);
	}
	@Override
	public int updateTaskTypeList(TaskTypeList taskTypeList, String msg) {
		// TODO Auto-generated method stub
		Date date =new Date();
		if(msg.equals("del")){
			TaskTypeListExample example =new TaskTypeListExample();
			TaskTypeListExample.Criteria criteria=example.createCriteria();
			criteria.andTaskTypeIdEqualTo(taskTypeList.getTaskTypeId());
			TaskTypeList taskTypeList2=taskTypeListMapper.selectByPrimaryKey(taskTypeList.getTaskTypeId());
			taskTypeList2.setCreateTime(date);
			taskTypeList2.setState(0);
			return taskTypeListMapper.updateByExample(taskTypeList2, example);
		}else if(msg.equals("upd")){
			TaskTypeListExample example =new TaskTypeListExample();
			TaskTypeListExample.Criteria criteria=example.createCriteria();
			criteria.andTaskTypeIdEqualTo(taskTypeList.getTaskTypeId());
			TaskTypeList taskTypeList2=taskTypeListMapper.selectByPrimaryKey(taskTypeList.getTaskTypeId());
			taskTypeList2.setTaskTypeName(taskTypeList.getTaskTypeName());
			taskTypeList2.setCreateTime(date);
			return taskTypeListMapper.updateByExample(taskTypeList2, example);
		}
		return 0;
	}
	@Override
	public int updateImage(Integer taskTypeId, String src) {
		// TODO Auto-generated method stub
		TaskTypeListExample example =new TaskTypeListExample();
		TaskTypeListExample.Criteria criteria=example.createCriteria();
		criteria.andTaskTypeIdEqualTo(taskTypeId);
		TaskTypeList taskTypeList2=taskTypeListMapper.selectByPrimaryKey(taskTypeId);
		taskTypeList2.setReservedFields(src);
		return taskTypeListMapper.updateByExample(taskTypeList2, example);
	}
}
