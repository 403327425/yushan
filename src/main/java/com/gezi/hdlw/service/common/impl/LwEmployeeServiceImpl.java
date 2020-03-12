package com.gezi.hdlw.service.common.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.hdlw.example.common.LwEmployeeExample;
import com.gezi.hdlw.example.common.LwEmployeeExample.Criteria;
import com.gezi.hdlw.search.common.LwEmployeeSearch;
import com.gezi.hdlw.service.AbstraceService;
import com.gezi.hdlw.service.common.LwEmployeeService;
import com.gezi.hdlw.util.DateUtil;
import com.gezi.hdlw.util.MyUtil;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.common.LwEmployee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @version:1.0
 * @Description:员工的接口实现类
 * @author:李云飞
 * @date: 2019年4月2日上午10:59:01
 */
@Service
@Transactional
public class LwEmployeeServiceImpl extends AbstraceService implements LwEmployeeService{
	
	private SimpleDateFormat formatyyyymmdd = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 新增
	 */
	@Override
	public int insert(LwEmployee lwEmployee) {
		// TODO Auto-generated method stub
		return lwEmployeeMapper.insertSelective(lwEmployee);
	}

	/**
	 * 修改
	 */
	@Override
	public int updateSelective(LwEmployee lwEmployee) {
		// TODO Auto-generated method stub
		return lwEmployeeMapper.updateByPrimaryKeySelective(lwEmployee);
	}

	/**
	 * 删除
	 */
	@Override
	public int deleteById(Integer ekId) {
		// TODO Auto-generated method stub
		LwEmployee employee = getById(ekId);
		if (employee == null) {
			return -1;
		}
		return lwEmployeeMapper.deleteByPrimaryKey(ekId);
	}
	
	/**
	 * 查询 or 条件查询
	 */
	@Override
	public ResultUtil ListByPage(LwEmployeeSearch lwEmployeeSearch) {
		// TODO Auto-generated method stub
		PageHelper.startPage(lwEmployeeSearch.getPage(), lwEmployeeSearch.getLimit());
		LwEmployeeExample example = new LwEmployeeExample();
		//设置按状态降序排序
		example.setOrderByClause("lw_employee.e_status DESC");
		Criteria criteria = example.createCriteria();
		
		if(null != lwEmployeeSearch.getPost() && lwEmployeeSearch.getPost() != 0){
			criteria.andPostEqualTo(lwEmployeeSearch.getPost());
		}
		
		if(null != lwEmployeeSearch.getEmployeeName() && !"".equals(lwEmployeeSearch.getEmployeeName())){
			//注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
			criteria.andEmployeeNameLike("%"+lwEmployeeSearch.getEmployeeName()+"%");
		}
		
		if(null != lwEmployeeSearch.getBeginDate() && !"".equals(lwEmployeeSearch.getBeginDate())){
			criteria.andECreationTimeGreaterThanOrEqualTo(MyUtil.getDateByString2(lwEmployeeSearch.getBeginDate()));
		}
		if(null != lwEmployeeSearch.getEndDate() && !"".equals(lwEmployeeSearch.getEndDate())){
			try {
				criteria.andECreationTimeLessThan(DateUtil.getNextDay(formatyyyymmdd.parse(lwEmployeeSearch.getEndDate())));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		List<LwEmployee> logs = lwEmployeeMapper.selectByExample(example);
		PageInfo<LwEmployee> pageInfo = new PageInfo<LwEmployee>(logs);
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
	public LwEmployee getById(Integer ekId) {
		// TODO Auto-generated method stub
		return lwEmployeeMapper.selectByPrimaryKey(ekId);
	}

	/**
	 * 查询所有
	 */
	@Override
	public List<LwEmployee> getList(Integer eStatus) {
		// TODO Auto-generated method stub
		LwEmployeeExample example = new LwEmployeeExample();
		if(eStatus != null){
			Criteria criteria = example.createCriteria();
			criteria.andEStatusEqualTo(eStatus);
		}
		return lwEmployeeMapper.selectByExample(example);
	}

}
