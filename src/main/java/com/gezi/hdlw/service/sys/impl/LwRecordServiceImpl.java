package com.gezi.hdlw.service.sys.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gezi.hdlw.dao.sys.LwRecordMapper;
import com.gezi.hdlw.service.AbstraceService;
import com.gezi.hdlw.service.sys.LwRecordService;
import com.gezi.hdlw.vo.sys.LwRecord;
import com.hazelcast.com.eclipsesource.json.JsonArray;
@Service
@Transactional
public class LwRecordServiceImpl extends AbstraceService implements LwRecordService {

	@Override
	public int insert(LwRecord lwRecord) {
		// TODO Auto-generated method stub
		double score=0;
		System.out.println(lwRecord.getRecordAnswer());
		JSONArray jsonArray = JSON.parseArray(lwRecord.getRecordAnswer());
		for(int i=0;i<jsonArray.size();i++){
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			score=score+(double)jsonObject.getByteValue("score");
		}
		lwRecord.setScore(score);
		return lwRecordMapper.insertSelective(lwRecord);
	}

}
