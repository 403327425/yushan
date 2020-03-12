package com.gezi.hdlw.service.sys.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.hdlw.example.sys.LwActivityExample;
import com.gezi.hdlw.service.AbstraceService;
import com.gezi.hdlw.service.sys.LwActivityService;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwActivity;
import com.gezi.hdlw.vo.sys.LwAdmin;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class LwActivityServiceImpl extends AbstraceService implements LwActivityService {

	@Override
	public int insert(LwActivity lwActivity) {
		// TODO Auto-generated method stub
		return lwActivityMapper.insert(lwActivity);
	}

	@Override
	public List<LwActivity> selectAll() {
		// TODO Auto-generated method stub
		LwActivityExample example=new LwActivityExample();
		return lwActivityMapper.selectByExample(example);
	}

	@Override
	public long getActivityId(LwActivity lwActivity) {
		// TODO Auto-generated method stub
		LwActivityExample example=new LwActivityExample();
		LwActivityExample.Criteria criteria=example.createCriteria();
		criteria.andPictureEqualTo(lwActivity.getPicture());
		List<LwActivity> list=lwActivityMapper.selectByExample(example);
		long ActivityId=list.get(0).getActivityId();
		return ActivityId;
	}

	@Override
	public LwActivity selectAllById(long activityId) {
		// TODO Auto-generated method stub
		return lwActivityMapper.selectByPrimaryKey(activityId);
	}

	@Override
	public void addVisitCount(long activityId) {
		// TODO Auto-generated method stub
		LwActivityExample example=new LwActivityExample();
		LwActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityIdEqualTo(activityId);
		LwActivity lwActivity=lwActivityMapper.selectByPrimaryKey(activityId);
		long count=lwActivity.getVisitCount();
		count=count+1;
		lwActivity.setVisitCount(count);
		lwActivityMapper.updateByExample(lwActivity, example);
		
	}

	@Override
	public ResultUtil listOrByWhere(Integer page, Integer limit) {
		// TODO Auto-generated method stub
		LwActivityExample example=new LwActivityExample();
		PageHelper.startPage(page, limit);
		List<LwActivity>list=lwActivityMapper.selectByExample(example);
		PageInfo<LwActivity> pageInfo = new PageInfo<LwActivity>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		resultUtil.setCode(0);
		return resultUtil;
	}

	@Override
	public int deleteById(long activityId) {
		// TODO Auto-generated method stub
		
		return lwActivityMapper.deleteByPrimaryKey(activityId);
	}

	@Override
	public int update(LwActivity lwActivity) {
		// TODO Auto-generated method stub
		LwActivityExample example=new LwActivityExample();
		LwActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityIdEqualTo(lwActivity.getActivityId());
		return lwActivityMapper.updateByExampleSelective(lwActivity, example);
	}

	@Override
	public ResultUtil selectListOrWhere(Integer page, Integer limit, String activityName, Date beginDate,
			Date endDate) {
		LwActivityExample example=new LwActivityExample();
		LwActivityExample.Criteria criteria=example.createCriteria();
		if(activityName!=null){
			criteria.andActivityNameLike("%"+activityName+"%");
		}
		if(beginDate!=null&&endDate!=null){
			criteria.andEndTimeBetween(beginDate, endDate);
		}
		
		try {
			DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date Date1 = dateFormat2.parse("0000-00-00 00:00:00");
			Date Date2 = dateFormat2.parse("9999-12-30 23:59:59");		
			if(beginDate!=null&&endDate==null){
				criteria.andEndTimeBetween(beginDate, Date2);
			}
			if(beginDate==null&&endDate!=null){
				criteria.andEndTimeBetween(Date1, endDate);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PageHelper.startPage(page, limit);
		List<LwActivity>list=lwActivityMapper.selectByExample(example);
		PageInfo<LwActivity> pageInfo = new PageInfo<LwActivity>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		resultUtil.setCode(0);
		return resultUtil;
	}

	@Override
	public List<LwActivity> selectByName(String activityName) {
		// TODO Auto-generated method stub
		LwActivityExample example=new LwActivityExample();
		LwActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityNameLike("%"+activityName+"%");
		return lwActivityMapper.selectByExample(example);
	}

	@Override
	public boolean selectPreFix(String prefix) {
		// TODO Auto-generated method stub
		LwActivityExample example=new LwActivityExample();
		LwActivityExample.Criteria criteria=example.createCriteria();
		criteria.andPrefixEqualTo(prefix);
		List<LwActivity> list=lwActivityMapper.selectByExample(example);
		if(list.size()>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String findPreFix(long id) {
		// TODO Auto-generated method stub
		LwActivityExample example=new LwActivityExample();
		LwActivityExample.Criteria criteria=example.createCriteria();
		criteria.andActivityIdEqualTo(id);
		String prefix=lwActivityMapper.selectByPrimaryKey(id).getPrefix();
		
		return prefix;
	}

	@Override
	public List<LwActivity> selectByOpenid(String openid) {
		// TODO Auto-generated method stub
		LwActivityExample example=new LwActivityExample();
		LwActivityExample.Criteria criteria=example.createCriteria();
		criteria.andOpenidEqualTo(openid);
		return lwActivityMapper.selectByExample(example);
	}
	
	@Override
	
	public ResultUtil selectByOpenid2(Integer page, Integer limit,String openid) {
		// TODO Auto-generated method stub
		LwActivityExample example=new LwActivityExample();
		LwActivityExample.Criteria criteria=example.createCriteria();
		criteria.andOpenidEqualTo(openid);
		
		PageHelper.startPage(page, limit);
		List<LwActivity>list=lwActivityMapper.selectByExample(example);
		PageInfo<LwActivity> pageInfo = new PageInfo<LwActivity>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		resultUtil.setCode(0);
		return resultUtil;
	}

	
	

}
