package com.gezi.GS.service;

import javax.annotation.Resource;

import com.gezi.GS.dao.sys.ExamineListMapper;
import com.gezi.GS.dao.sys.MedalListMapper;
import com.gezi.GS.dao.sys.MyPlanListMapper;
import com.gezi.GS.dao.sys.PerformListMapper;
import com.gezi.GS.dao.sys.ScoreListMapper;
import com.gezi.GS.dao.sys.TaskListMapper;
import com.gezi.GS.dao.sys.TaskTypeListMapper;
import com.gezi.GS.dao.sys.UserListMapper;

public class AbstraceService {
	@Resource
	protected MedalListMapper medalListMapper;
	@Resource
	protected PerformListMapper performListMapper;
	@Resource
	protected TaskListMapper taskListMapper;
	@Resource
	protected TaskTypeListMapper taskTypeListMapper;
	@Resource
	protected UserListMapper userListMapper;
	@Resource
	protected MyPlanListMapper myPlanListMapper;
	@Resource
	protected ExamineListMapper examineListMapper;
	@Resource
	protected ScoreListMapper scoreListMapper;
}
