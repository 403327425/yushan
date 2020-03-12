package com.gezi.GS.service.sys.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.GS.example.sys.TaskListExample;
import com.gezi.GS.example.sys.TaskTypeListExample;
import com.gezi.GS.service.AbstraceService;
import com.gezi.GS.service.sys.TaskListService;
import com.gezi.GS.vo.sys.TaskList;
import com.gezi.GS.vo.sys.TaskTypeList;
import com.hazelcast.nio.serialization.Data;
@Service
@Transactional
public class TaskListServiceImpl extends AbstraceService implements TaskListService {

	@Override
	public int addTask(TaskList taskList) {
		// TODO Auto-generated method stub
		return taskListMapper.insert(taskList);
	}

	@Override
	public List<TaskList> getTypeTask(Integer taskTypeId) {
		// TODO Auto-generated method stub
		TaskListExample example=new TaskListExample();
		TaskListExample.Criteria criteria=example.createCriteria();
		criteria.andStateNotEqualTo(0);
		criteria.andTaskTypeIdEqualTo(taskTypeId);
		return taskListMapper.selectByExample(example);
	}
	
	@Override
	public List<TaskList> getTypeTask2(Integer taskTypeId) {
		// TODO Auto-generated method stub
		TaskListExample example=new TaskListExample();
		TaskListExample.Criteria criteria=example.createCriteria();
		criteria.andStateEqualTo(1);
		criteria.andTaskTypeIdEqualTo(taskTypeId);
		return taskListMapper.selectByExample(example);
	}

	@Override
	public int updateTaskList(TaskList taskList, String msg) {
		// TODO Auto-generated method stub
		Date data =new Date();
		TaskListExample example =new TaskListExample();
		TaskListExample.Criteria criteria=example.createCriteria();
		criteria.andTaskIdEqualTo(taskList.getTaskId());
		TaskList taskList2=taskListMapper.selectByPrimaryKey(taskList.getTaskId());
		if(msg.equals("del")){
			taskList2.setState(0);
			taskList2.setCreateTime(data);
			return taskListMapper.updateByExample(taskList2, example);
		}else if(msg.equals("upd")){
			taskList2.setTaskName(taskList.getTaskName());
			taskList2.setTaskText(taskList.getTaskText());
			taskList2.setDuration(taskList.getDuration());
			taskList2.setScore(taskList.getScore());
			taskList2.setFinishNumber(taskList.getFinishNumber());
			taskList2.setFatherId(taskList.getFatherId());
			taskList2.setTaskTypeId(taskList.getTaskTypeId());
			taskList2.setCreateTime(data);
			return taskListMapper.updateByExample(taskList2, example);
		}else if(msg.equals("pub")){
			if(taskList2.getState()==1){
				taskList2.setState(2);
			}else if(taskList2.getState()==2){
				taskList2.setState(1);
			}
			
			taskList2.setCreateTime(data);
			return taskListMapper.updateByExample(taskList2, example);
		}
		return 0;
	}

	@Override
	public TaskList getTaskById(Integer taskId) {
		// TODO Auto-generated method stub
		return taskListMapper.selectByPrimaryKey(taskId);
	}

	@Override
	public List<TaskList> getAllTask() {
		// TODO Auto-generated method stub
		TaskListExample example=new TaskListExample();
		TaskListExample.Criteria criteria=example.createCriteria();
		criteria.andStateEqualTo(1);
		return taskListMapper.selectByExample(example);
	}

	

}
