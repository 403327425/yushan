package com.gezi.hdlw.service.sys.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.hdlw.example.sys.LwDictionaryExample;
import com.gezi.hdlw.example.sys.LwDictionaryExample.Criteria;
import com.gezi.hdlw.search.sys.LwDictionarySearch;
import com.gezi.hdlw.service.AbstraceService;
import com.gezi.hdlw.service.sys.LwDictionaryService;
import com.gezi.hdlw.util.MyUtil;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwDictionary;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @version:1.0
 * @Description:字典的接口实现类
 * @author:李云飞
 * @date: 2019年3月29日上午11:47:01
 */
@Service
@Transactional
public class LwDictionaryServiceImpl extends AbstraceService implements LwDictionaryService {
	
	/**
	 * 新增
	 */
	@Override
	public int insert(LwDictionary lwDictionary) {
		// TODO Auto-generated method stub
		return lwDictionaryMapper.insertSelective(lwDictionary);
	}

	/**
	 * 修改
	 */
	@Override
	public int updateSelective(LwDictionary lwDictionary) {
		// TODO Auto-generated method stub
		return lwDictionaryMapper.updateByPrimaryKeySelective(lwDictionary);
	}

	/**
	 * 根据id查询
	 */
	@Override
	public LwDictionary getById(Integer dkId) {
		// TODO Auto-generated method stub
		return lwDictionaryMapper.selectByPrimaryKey(dkId);
	}
	
	/**
	 * 查询 or 条件查询
	 */
	@Override
	public ResultUtil ListByPage(LwDictionarySearch lwDictionarySearch) {
		// TODO Auto-generated method stub
		PageHelper.startPage(lwDictionarySearch.getPage(), lwDictionarySearch.getLimit());
		LwDictionaryExample example = new LwDictionaryExample();
		Criteria criteria = example.createCriteria();
		
		if(null != lwDictionarySearch.getDictionaryTable() && !"".equals(lwDictionarySearch.getDictionaryTable())){
			criteria.andDictionaryTableEqualTo(lwDictionarySearch.getDictionaryTable());
		}
		
		if(null != lwDictionarySearch.getDictionaryColum() && !"".equals(lwDictionarySearch.getDictionaryColum())){
			criteria.andDictionaryColumEqualTo(lwDictionarySearch.getDictionaryColum());
		}
		
		if(null != lwDictionarySearch.getBeginDate() && !"".equals(lwDictionarySearch.getBeginDate())){
			criteria.andDCreationTimeGreaterThanOrEqualTo(MyUtil.getDateByString2(lwDictionarySearch.getBeginDate()));
		}
		if(null != lwDictionarySearch.getEndDate() && !"".equals(lwDictionarySearch.getEndDate())){
			criteria.andDCreationTimeLessThanOrEqualTo(MyUtil.getDateByString2(lwDictionarySearch.getEndDate()));
		}
		
		List<LwDictionary> logs = lwDictionaryMapper.selectByExample(example);
		PageInfo<LwDictionary> pageInfo = new PageInfo<LwDictionary>(logs);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCode(0);
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		return resultUtil;
	}

	/**
	 * 根据字典表名称和字段名称查询字典
	 */
	@Override
	public List<LwDictionary> ListByTableAndColum(LwDictionary lwDictionary) {
		// TODO Auto-generated method stub
		LwDictionaryExample example = new LwDictionaryExample();
		Criteria criteria = example.createCriteria();
		criteria.andDictionaryTableEqualTo(lwDictionary.getDictionaryTable());
		criteria.andDictionaryColumEqualTo(lwDictionary.getDictionaryColum());
		criteria.andDictionaryStatusEqualTo(lwDictionary.getDictionaryStatus());
		return lwDictionaryMapper.selectByExample(example);
	}
	
	
}
