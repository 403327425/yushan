package com.gezi.GS.service.sys;

import com.gezi.GS.vo.sys.ExamineList;

public interface ExamineListService {

	int add(ExamineList examineList);

	ExamineList selectByUrl(String examineUrl);

	ExamineList getById(Integer examineId);

	int updByMsg(Integer examineId, String msg);

}
