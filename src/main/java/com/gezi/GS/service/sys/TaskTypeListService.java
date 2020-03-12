package com.gezi.GS.service.sys;

import java.util.List;

import com.gezi.GS.vo.sys.TaskTypeList;

public interface TaskTypeListService {

	int addType(TaskTypeList taskTypeList);
	List<TaskTypeList> showType();
	int updateTaskTypeList(TaskTypeList taskTypeList, String msg);
	int updateImage(Integer taskTypeId, String src);

}
