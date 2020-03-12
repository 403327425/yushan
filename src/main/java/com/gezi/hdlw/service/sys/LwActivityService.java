package com.gezi.hdlw.service.sys;

import java.util.Date;
import java.util.List;

import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwActivity;

public interface LwActivityService {
	public int insert(LwActivity lwActivity);
	public List<LwActivity> selectAll();
	public LwActivity selectAllById(long activityId);
	public long getActivityId(LwActivity lwActivity); 
	public void addVisitCount(long activityId);
	public ResultUtil listOrByWhere(Integer page, Integer limit);
	public int deleteById(long activityId);
	public int update(LwActivity lwActivity);
	public ResultUtil selectListOrWhere(Integer page, Integer limit,String activityName,Date beginDate,Date endDate);
	public List<LwActivity> selectByName(String activityName);
	//检测前缀是否存在
	public boolean selectPreFix(String prefix);
	//获取前缀
	public String findPreFix(long id);
	//根据openid获取
	public List<LwActivity> selectByOpenid(String openid);
	//根据openid获取方式2
	public ResultUtil selectByOpenid2(Integer page, Integer limit,String openid);
	
	
}
