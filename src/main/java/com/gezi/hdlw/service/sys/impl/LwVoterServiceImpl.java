package com.gezi.hdlw.service.sys.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.iterators.LoopingIterator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.hdlw.example.sys.LwActivityExample;
import com.gezi.hdlw.example.sys.LwVoterExample;
import com.gezi.hdlw.service.AbstraceService;
import com.gezi.hdlw.service.sys.LwVoterService;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwActivity;
import com.gezi.hdlw.vo.sys.LwVoter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
@Transactional
public class LwVoterServiceImpl extends AbstraceService implements LwVoterService {

	@Override
	public int insert(LwVoter lwVoter) {
		// TODO Auto-generated method stub
		
		return lwVoterMapper.insert(lwVoter);
	}

	@Override
	public int selectCount(LwVoter lwVoter) {
		// TODO Auto-generated method stub
		LwVoterExample example=new LwVoterExample();
		LwVoterExample.Criteria criteria=example.createCriteria();
		criteria.andActivityIdEqualTo(lwVoter.getActivityId());
		criteria.andCandidateIdEqualTo(lwVoter.getCandidateId());
		List<LwVoter> list=lwVoterMapper.selectByExample(example);
		int count=list.size();
		return count;
	}

	@Override
	public List<LwVoter> check(LwVoter lwVoter) {
		// TODO Auto-generated method stub
		LwVoterExample example=new LwVoterExample();
		LwVoterExample.Criteria criteria=example.createCriteria();
		criteria.andIpEqualTo(lwVoter.getIp());
		criteria.andActivityIdEqualTo(lwVoter.getActivityId());
		return lwVoterMapper.selectByExample(example);
	}

	@Override
	public int getAllCountById(long activityId) {
		// TODO Auto-generated method stub
		LwVoterExample example=new LwVoterExample();
		LwVoterExample.Criteria criteria=example.createCriteria();
		criteria.andActivityIdEqualTo(activityId);
		List<LwVoter> list=lwVoterMapper.selectByExample(example);
		
		return list.size();
	}

	@Override
	public List<LwVoter> getAllVoter() {
		// TODO Auto-generated method stub
		LwVoterExample example=new LwVoterExample();
		
		return lwVoterMapper.selectByExample(example);
	}

	@Override
	public LwVoter getById(long id) {
		// TODO Auto-generated method stub
		
		return lwVoterMapper.selectByPrimaryKey(id);
	}

	@Override
	public ResultUtil listOrByWhere(Integer page, Integer limit,Long activityId) {
		// TODO Auto-generated method stub
		
		LwVoterExample example=new LwVoterExample();
		LwVoterExample.Criteria criteria=example.createCriteria();
		if(activityId!=null&&activityId!=-2){
			criteria.andActivityIdEqualTo(activityId);
		}
		PageHelper.startPage(page, limit);
		List<LwVoter>list=lwVoterMapper.selectByExample(example);
		PageInfo<LwVoter> pageInfo = new PageInfo<LwVoter>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		resultUtil.setCode(0);
		return resultUtil;
	}

	@Override
	public int deleteById(long id) {
		// TODO Auto-generated method stub
		
		
		return lwVoterMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(LwVoter lwVoter) {
		// TODO Auto-generated method stub
		LwVoterExample example=new LwVoterExample();
		LwVoterExample.Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(lwVoter.getId());
		return lwVoterMapper.updateByExampleSelective(lwVoter, example);
	}

	@Override
	public List<LwVoter> selectByOpenid(String openid) {
		// TODO Auto-generated method stub
		LwVoterExample example=new LwVoterExample();
		LwVoterExample.Criteria criteria=example.createCriteria();
		criteria.andIpEqualTo(openid);
		return lwVoterMapper.selectByExample(example);
	}

	@Override
	public String systemVote(Long activityId,Long candidateId,int voteMode, int limitMode, int limitNumber, String openid) {
		// TODO Auto-generated method stub
		String text="";
		Date voteTime=new Date();
		LwVoter lwVoter=new LwVoter();
		lwVoter.setActivityId(activityId);
		lwVoter.setCandidateId(candidateId);
		lwVoter.setIp(openid);
		lwVoter.setVoteTime(voteTime);
		LwVoterExample example=new LwVoterExample();
		LwVoterExample.Criteria criteria=example.createCriteria();
		criteria.andActivityIdEqualTo(activityId);
		criteria.andIpEqualTo(openid);
		List<LwVoter> list=lwVoterMapper.selectByExample(example);
		if(voteMode==1){
			if(list.size()<limitNumber){
				if(limitMode==1){
					Boolean flag=true;
					for(int i=0;i<list.size();i++){
						if(candidateId==list.get(i).getCandidateId()){
							flag=false;
						}
					}
					if(flag){
						lwVoterMapper.insert(lwVoter);
						text="助力成功，人气值+1，\n当前人气值"+countByCandidateId(candidateId)+"，\n剩余助力次数："+(limitNumber-list.size()-1)+"。";
					}else{
						text="助力失败，\n你已经助力过了，\n剩余助力次数："+(limitNumber-list.size())+"。";
					}
				}else{
					lwVoterMapper.insert(lwVoter);
					text="助力成功，人气值+1，\n当前人气值"+countByCandidateId(candidateId)+"，\n剩余助力次数："+(limitNumber-list.size()-1)+"。";
				}
				
			}else{
				text="助力失败，\n助力次数已用完。";
			}
		}else if(voteMode==2){
			int temp=0;
			for(int i=0;i<list.size();i++){
				if(isSameDay(voteTime, list.get(i).getVoteTime())){
					temp++;
				}
			}
			if(temp<limitNumber){
				if(limitMode==1){
					Boolean flag=true;
					for(int i=0;i<list.size();i++){
						if(candidateId==list.get(i).getCandidateId()){
							flag=false;
						}
					}
					if(flag){
						lwVoterMapper.insert(lwVoter);
						text="助力成功，人气值+1，\n当前人气值"+countByCandidateId(candidateId)+"，\n今日剩余助力次数："+(limitNumber-temp-1)+"。";
					}else{
						text="助力失败，\n你已经助力过了，\n今日剩余助力次数："+(limitNumber-list.size())+"。";
					}
				}else{
					lwVoterMapper.insert(lwVoter);
					text="助力成功，人气值+1，\n当前人气值"+countByCandidateId(candidateId)+"，\n今日剩余助力次数："+(limitNumber-temp-1)+"。";
				}
			}else{
				text="助力失败，\n今日你的助力次数已用完。";
			}
		}
		return text;
	}
	public int countByCandidateId(Long candidateId){
		LwVoterExample example=new LwVoterExample();
		LwVoterExample.Criteria criteria=example.createCriteria();
		criteria.andCandidateIdEqualTo(candidateId);
		List<LwVoter>list=lwVoterMapper.selectByExample(example);
		return list.size();
	}
	//判断同一天
	public boolean isSameDay(Date day1, Date day2) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String ds1 = sdf.format(day1);
	    String ds2 = sdf.format(day2);
	    if (ds1.equals(ds2)) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
}
