package com.gezi.hdlw.service.sys.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.hdlw.example.sys.StudyDataExample;
import com.gezi.hdlw.service.AbstraceService;
import com.gezi.hdlw.service.sys.StudyDataService;
import com.gezi.hdlw.vo.sys.StudyData;
@Service
@Transactional
public class StudyDataServiceImpl extends AbstraceService implements StudyDataService {

	@Override
	public int addSD(StudyData studyData) {
		// TODO Auto-generated method stub2
		return studyDataMapper.insert(studyData);
	}

	@Override
	public int updateSD(StudyData studyData) {
		// TODO Auto-generated method stub
		StudyDataExample example=new StudyDataExample();
		StudyDataExample.Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(studyData.getId());
		return studyDataMapper.updateByExample(studyData, example);
	}

	@Override
	public int delectSD(int id) {
		// TODO Auto-generated method stub
		return studyDataMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<StudyData> selectALLSD() {
		// TODO Auto-generated method stub
		StudyDataExample example=new StudyDataExample();
		return studyDataMapper.selectByExample(example);
	}

}
