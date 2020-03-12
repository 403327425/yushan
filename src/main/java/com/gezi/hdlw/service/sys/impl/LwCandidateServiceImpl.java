package com.gezi.hdlw.service.sys.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.hdlw.example.sys.LwActivityExample;
import com.gezi.hdlw.example.sys.LwCandidateExample;
import com.gezi.hdlw.service.AbstraceService;
import com.gezi.hdlw.service.sys.LwCandidateService;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwActivity;
import com.gezi.hdlw.vo.sys.LwCandidate;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class LwCandidateServiceImpl extends AbstraceService implements LwCandidateService {

	@Override
	public int signUp(LwCandidate lwCandidate) {
		// TODO Auto-generated method stub
		
		return lwCandidateMapper.insertSelective(lwCandidate);
	}

	@Override
	public List<LwCandidate> selectBy(LwCandidate lwCandidate) {
		// TODO Auto-generated method stub
		LwCandidateExample example=new LwCandidateExample();
		LwCandidateExample.Criteria criteria=example.createCriteria();
		criteria.andIphoneEqualTo(lwCandidate.getIphone());
		criteria.andActivityIdEqualTo(lwCandidate.getActivityId());
		return lwCandidateMapper.selectByExample(example);
	}
	
	@Override
	public List<LwCandidate> selectBy2(LwCandidate lwCandidate) {
		// TODO Auto-generated method stub
		LwCandidateExample example=new LwCandidateExample();
		LwCandidateExample.Criteria criteria=example.createCriteria();
		criteria.andOpenidEqualTo(lwCandidate.getOpenid());
		criteria.andActivityIdEqualTo(lwCandidate.getActivityId());
		return lwCandidateMapper.selectByExample(example);
	}

	@Override
	public List<LwCandidate> selectByActivityId(long activityId) {
		LwCandidateExample example=new LwCandidateExample();
		LwCandidateExample.Criteria criteria=example.createCriteria();
		criteria.andActivityIdEqualTo(activityId);
		return lwCandidateMapper.selectByExample(example);
	}

	@Override
	public List<LwCandidate> selectLikeByActivityId(LwCandidate lwCandidate) {
		// TODO Auto-generated method stub
		LwCandidateExample example=new LwCandidateExample();
		LwCandidateExample.Criteria criteria=example.createCriteria();
		criteria.andCandidateNameLike("%"+lwCandidate.getCandidateName()+"%");
		criteria.andActivityIdEqualTo(lwCandidate.getActivityId());
		example.or().andCandidateIdEqualTo(lwCandidate.getCandidateId()).andActivityIdEqualTo(lwCandidate.getActivityId());
		return lwCandidateMapper.selectByExample(example);
	}

	@Override
	public LwCandidate selectAllById(long candidateId) {
		// TODO Auto-generated method stub
		
		return lwCandidateMapper.selectByPrimaryKey(candidateId);
	}

	@Override
	public ResultUtil listOrByWhere(Integer page, Integer limit,String candidateSelectName,List<LwActivity> ActivityList) {
		// TODO Auto-generated method stub
		
		LwCandidateExample example=new LwCandidateExample();
		LwCandidateExample.Criteria criteria=example.createCriteria();
		
		
		
		
		
		if(ActivityList!=null){
			for(int i=0;i<ActivityList.size();i++){
				if(candidateSelectName!=null){
					example.or().andActivityIdEqualTo(ActivityList.get(i).getActivityId()).andCandidateNameLike("%"+candidateSelectName+"%");;
					
				}
				
			}
		}else{
			if(candidateSelectName!=""||candidateSelectName==null){
				criteria.andCandidateNameLike("%"+candidateSelectName+"%");;
				
			}
		}
		
		
		PageHelper.startPage(page, limit);
		List<LwCandidate>list=lwCandidateMapper.selectByExample(example);
		PageInfo<LwCandidate> pageInfo = new PageInfo<LwCandidate>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		resultUtil.setCode(0);
		return resultUtil;
	}

	@Override
	public int deleteById(long candidateId) {
		// TODO Auto-generated method stub
		return lwCandidateMapper.deleteByPrimaryKey(candidateId);
	}

	@Override
	public int update(LwCandidate lwCandidate) {
		// TODO Auto-generated method stub
		LwCandidateExample example=new LwCandidateExample();
		LwCandidateExample.Criteria criteria=example.createCriteria();
		criteria.andCandidateIdEqualTo(lwCandidate.getCandidateId());
		
		return lwCandidateMapper.updateByExampleSelective(lwCandidate, example);
	}

	@Override
	public boolean selectBySelectId(String selectId) {
		// TODO Auto-generated method stub
		LwCandidateExample example=new LwCandidateExample();
		LwCandidateExample.Criteria criteria=example.createCriteria();
		criteria.andSelectIdEqualTo(selectId);
		List<LwCandidate>list=lwCandidateMapper.selectByExample(example);
		if(list.size()>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<LwCandidate> selectLikeByActivityIdAndName(LwCandidate lwCandidate) {
		// TODO Auto-generated method stub
		LwCandidateExample example=new LwCandidateExample();
		LwCandidateExample.Criteria criteria=example.createCriteria();
		criteria.andActivityIdEqualTo(lwCandidate.getActivityId());
		criteria.andCandidateNameLike("%"+lwCandidate.getCandidateName()+"%");
		example.or().andSelectIdLike("%"+lwCandidate.getCandidateName()+"%").andActivityIdEqualTo(lwCandidate.getActivityId());
		
		return lwCandidateMapper.selectByExample(example);
	}

	@Override
	public List<LwCandidate> selectByOpenid(String openid) {
		LwCandidateExample example=new LwCandidateExample();
		LwCandidateExample.Criteria criteria=example.createCriteria();
		criteria.andOpenidEqualTo(openid);
		return lwCandidateMapper.selectByExample(example);
	}

	@Override
	public ResultUtil selectByActivityId(Integer page, Integer limit, long activityId) {
		LwCandidateExample example=new LwCandidateExample();
		LwCandidateExample.Criteria criteria=example.createCriteria();
		criteria.andActivityIdEqualTo(activityId);
		PageHelper.startPage(page, limit);
		List<Object>list=lwCandidateMapper.selectPersonActivityCandidateList(activityId);
		PageInfo<Object> pageInfo = new PageInfo<Object>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		resultUtil.setCode(0);
		
		return resultUtil;
	}

	@Override
	public LwCandidate infoBySelectId(String selectId) {
		LwCandidateExample example=new LwCandidateExample();
		LwCandidateExample.Criteria criteria=example.createCriteria();
		criteria.andSelectIdEqualTo(selectId);
		LwCandidate lwCandidate=lwCandidateMapper.selectByExample(example).get(0);
		return lwCandidate;
	}
	
	

}
