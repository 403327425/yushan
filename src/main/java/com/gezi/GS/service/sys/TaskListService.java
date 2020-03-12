package com.gezi.GS.service.sys;

import java.util.List;

import com.gezi.GS.vo.sys.TaskList;
import com.gezi.GS.vo.sys.TaskTypeList;

public interface TaskListService {

	int addTask(TaskList taskList);

	List<TaskList> getTypeTask(Integer taskTypeId);
	List<TaskList> getTypeTask2(Integer taskTypeId);

	int updateTaskList(TaskList taskList, String msg);

	TaskList getTaskById(Integer taskId);

	List<TaskList> getAllTask();

	

}
