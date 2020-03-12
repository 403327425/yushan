package com.gezi.GS.service.sys;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gezi.GS.vo.sys.PerformList;

public interface PerformListService {

	int addPerform(PerformList performList);

	int selectPerformByUserIdAndTaskId(Long openid, Integer taskTypeId);

	PerformList selectPerformByUserIdAndTaskId2(Long userId, Integer taskId);

	int update(PerformList performList);

	PerformList getExamineDetail();

	int updByMsg(Long performId, String msg);

	Map getMyTaskSize(Long userId);

	

}
