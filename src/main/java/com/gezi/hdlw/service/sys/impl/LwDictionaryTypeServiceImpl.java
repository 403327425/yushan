package com.gezi.hdlw.service.sys.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.hdlw.example.sys.LwDictionaryTypeExample;
import com.gezi.hdlw.example.sys.LwDictionaryTypeExample.Criteria;
import com.gezi.hdlw.search.sys.LwDictionaryTypeSearch;
import com.gezi.hdlw.service.AbstraceService;
import com.gezi.hdlw.service.sys.LwDictionaryTypeService;
import com.gezi.hdlw.util.DateUtil;
import com.gezi.hdlw.util.MyUtil;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwDictionaryType;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @version:1.0
 * @Description:字典类型的接口实现类
 * @author:李云飞
 * @date: 2019年3月29日上午11:47:01
 */
@Service
@Transactional
public class LwDictionaryTypeServiceImpl extends AbstraceService implements LwDictionaryTypeService {
	
	private SimpleDateFormat formatyyyymmdd = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 新增
	 */
	@Override
	public int insert(LwDictionaryType lwDictionaryType) {
		// TODO Auto-generated method stub
		return lwDictionaryTypeMapper.insertSelective(lwDictionaryType);
	}

	/**
	 * 修改
	 */
	@Override
	public int updateSelective(LwDictionaryType lwDictionaryType) {
		// TODO Auto-generated method stub
		return lwDictionaryTypeMapper.updateByPrimaryKeySelective(lwDictionaryType);
	}

	/**
	 * 查询所有表（只查询表类型的）
	 * @return
	 */
	public List<LwDictionaryType> ListByTable(){
		LwDictionaryTypeExample example = new LwDictionaryTypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andDictionaryTypeTypeEqualTo_alias("1");
		return lwDictionaryTypeMapper.selectByExample(example);
	}
	
	/**
	 * 查询 or 条件查询
	 */
	@Override
	public ResultUtil ListByPage(LwDictionaryTypeSearch lwDictionaryTypeSearch) {
		// TODO Auto-generated method stub
		PageHelper.startPage(lwDictionaryTypeSearch.getPage(), lwDictionaryTypeSearch.getLimit());
		LwDictionaryTypeExample example = new LwDictionaryTypeExample();
		//设置按创建时间降序排序
		example.setOrderByClause("dictionary_type1.dt_creation_time DESC");
		Criteria criteria = example.createCriteria();
		
		if(null != lwDictionaryTypeSearch.getDictionaryTypeName() && !"".equals(lwDictionaryTypeSearch.getDictionaryTypeName())){
			//注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
			criteria.andDictionaryTypeNameLike_alias("%"+lwDictionaryTypeSearch.getDictionaryTypeName()+"%");
		}
		
		if(null != lwDictionaryTypeSearch.getDictionaryTypeValue() && !"".equals(lwDictionaryTypeSearch.getDictionaryTypeValue())){
			//注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
			criteria.andDictionaryTypeValueLike_alias("%"+lwDictionaryTypeSearch.getDictionaryTypeValue()+"%");
		}
		
		if(null != lwDictionaryTypeSearch.getDictionaryTypeType() && !"".equals(lwDictionaryTypeSearch.getDictionaryTypeType())){
			//注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
			criteria.andDictionaryTypeTypeEqualTo_alias(lwDictionaryTypeSearch.getDictionaryTypeType());
		}
		
		if(null != lwDictionaryTypeSearch.getDtOperator() && !"".equals(lwDictionaryTypeSearch.getDtOperator())){
			//注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
			criteria.andDtOperatorEqualTo_alias(lwDictionaryTypeSearch.getDtOperator());
		}
		
		if(null != lwDictionaryTypeSearch.getBeginDate() && !"".equals(lwDictionaryTypeSearch.getBeginDate())){
			criteria.andDtCreationTimeGreaterThanOrEqualTo_alias(MyUtil.getDateByString2(lwDictionaryTypeSearch.getBeginDate()));
		}
		if(null != lwDictionaryTypeSearch.getEndDate() && !"".equals(lwDictionaryTypeSearch.getEndDate())){
			try {
				criteria.andDtCreationTimeLessThan_alias(DateUtil.getNextDay(formatyyyymmdd.parse(lwDictionaryTypeSearch.getEndDate())));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		List<LwDictionaryType> logs = lwDictionaryTypeMapper.selectByExample(example);
		PageInfo<LwDictionaryType> pageInfo = new PageInfo<LwDictionaryType>(logs);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCode(0);
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		return resultUtil;
	}

	/**
	 * 根据id查询
	 */
	@Override
	public LwDictionaryType getById(Integer dtkId) {
		// TODO Auto-generated method stub
		return lwDictionaryTypeMapper.selectByPrimaryKey(dtkId);
	}

	/**
	 * 根据父ID查询
	 */
	@Override
	public List<LwDictionaryType> ListByParentId(Integer dtParentId) {
		// TODO Auto-generated method stub
		LwDictionaryTypeExample example = new LwDictionaryTypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andDtParentIdEqualTo_alias(dtParentId);
		return lwDictionaryTypeMapper.selectByExample(example);
	}

}
