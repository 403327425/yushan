package com.gezi.hdlw.service.sys.impl;

import java.util.List;

import org.apache.poi.poifs.dev.POIFSHeaderDumper;
import org.apache.poi.ss.formula.functions.PPMT;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.hdlw.dao.sys.LwQuestionnaireMapper;
import com.gezi.hdlw.example.sys.LwQuestionnaireExample;
import com.gezi.hdlw.example.sys.LwQuestionnaireExample.Criteria;
import com.gezi.hdlw.search.sys.LwQuestionnaireSearch;
import com.gezi.hdlw.service.AbstraceService;
import com.gezi.hdlw.service.sys.LwQuestionnaireService;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwDictionary;
import com.gezi.hdlw.vo.sys.LwQuestionnaire;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class LwQuestionnaireServiceImpl extends AbstraceService implements LwQuestionnaireService {
	
	
	@Override
	public int insert(LwQuestionnaire lwQuestionnaire) {
		// TODO Auto-generated method stub
		System.out.println(lwQuestionnaire.toString());
		return lwQuestionnaireMapper.insertSelective(lwQuestionnaire);
	}

	@Override
	public ResultUtil getQuestionnaire(LwQuestionnaireSearch lwQuestionnaireSearch) {
		PageHelper.startPage(lwQuestionnaireSearch.getPage(),lwQuestionnaireSearch.getLimit());
		// TODO Auto-generated method stub
		LwQuestionnaireExample example =new LwQuestionnaireExample();
		
		Criteria criteria =example.createCriteria();
		if(null != lwQuestionnaireSearch.getQnType() && !"".equals(lwQuestionnaireSearch.getQnType())){
			criteria.andTypeIdEqualTo(lwQuestionnaireSearch.getQnType());
		}

		List<LwQuestionnaire> logs=lwQuestionnaireMapper.selectByExample(example);
		PageInfo<LwQuestionnaire> pageInfo = new PageInfo<LwQuestionnaire>(logs);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCode(0);
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		return resultUtil;
	}

	@Override
	public int deleteById(Integer qnId) {
		// TODO Auto-generated method stub
		LwQuestionnaire lwQuestionnaire=getById(qnId);
		if(lwQuestionnaire==null){
			return -1;
		}
		return lwQuestionnaireMapper.deleteByPrimaryKey(qnId);
		
	}

	@Override
	public LwQuestionnaire getById(Integer qnId) {
		// TODO Auto-generated method stub
		return lwQuestionnaireMapper.selectByPrimaryKey(qnId);
	}

	@Override
	public int updataQuestionnaire(LwQuestionnaire lwQuestionnaire) {
		// TODO Auto-generated method stub
		return lwQuestionnaireMapper.updateByPrimaryKeySelective(lwQuestionnaire);
	}
	
	

}
