package com.gezi.hdlw.service.sys;

import java.util.List;

import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwActivity;
import com.gezi.hdlw.vo.sys.LwCandidate;

public interface LwCandidateService {
	public int signUp(LwCandidate lwCandidate);
	public List<LwCandidate> selectBy(LwCandidate lwCandidate);
	public List<LwCandidate> selectBy2(LwCandidate lwCandidate);
	public List<LwCandidate> selectByActivityId(long activityId);
	public List<LwCandidate> selectLikeByActivityId(LwCandidate lwCandidate);
	public LwCandidate selectAllById(long candidateId);
	
	public ResultUtil listOrByWhere(Integer page, Integer limit,String candidateSelectName,List<LwActivity> list);
	public int deleteById(long candidateId);
	public int update(LwCandidate lwCandidate);
	//验证SelectId唯一
	public boolean selectBySelectId(String selectId);
	//搜索
	public List<LwCandidate> selectLikeByActivityIdAndName(LwCandidate lwCandidate);
	//根据openid获取
	public List<LwCandidate> selectByOpenid(String openid);
	//根据activityid获取方式2
	public ResultUtil selectByActivityId(Integer page, Integer limit,long activityId);
	//输入select_id获取信息
	public LwCandidate infoBySelectId(String selectId);
	
}
