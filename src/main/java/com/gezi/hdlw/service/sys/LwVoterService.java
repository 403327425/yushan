package com.gezi.hdlw.service.sys;

import java.util.List;

import com.gezi.hdlw.util.ResultUtil;

import com.gezi.hdlw.vo.sys.LwVoter;

public interface LwVoterService {
	public int insert(LwVoter lwVoter);
	public int selectCount(LwVoter lwVoter);
	public List<LwVoter> check(LwVoter lwVoter);
	public int getAllCountById(long activityId);
	
	public List<LwVoter> getAllVoter();
	public LwVoter getById(long id);
	public ResultUtil listOrByWhere(Integer page, Integer limit,Long activityId);
	public int deleteById(long id);
	public int update(LwVoter lwVoter);
	//根据Openid获取
	public List<LwVoter> selectByOpenid(String openid);
	//投票判断返回成功或失败
	public String systemVote(Long activityId,Long candidateId,int voteMode,int limitMode,int limitNumber,String openid);
	

}
