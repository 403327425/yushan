package com.gezi.hdlw.service.sys;

import java.util.List;


import com.gezi.hdlw.vo.sys.StudyData;

public interface StudyDataService {
	//添加
		public int addSD(StudyData studyData);
		//修改
		public int updateSD(StudyData studyData);
		//删除
		public int delectSD(int id);
		//查
		public List<StudyData> selectALLSD();
}
