package com.gezi.GS.controller.sys;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.sql.visitor.functions.If;
import com.alibaba.fastjson.JSON;
import com.gezi.GS.service.sys.ExamineListService;
import com.gezi.GS.service.sys.MedalListService;
import com.gezi.GS.service.sys.MyPlanListService;
import com.gezi.GS.service.sys.PerformListService;
import com.gezi.GS.service.sys.ScoreListService;
import com.gezi.GS.service.sys.TaskListService;
import com.gezi.GS.service.sys.TaskTypeListService;
import com.gezi.GS.service.sys.UserListService;
import com.gezi.GS.vo.sys.ExamineList;
import com.gezi.GS.vo.sys.MyPlanList;
import com.gezi.GS.vo.sys.PerformList;
import com.gezi.GS.vo.sys.ScoreList;
import com.gezi.GS.vo.sys.TaskList;
import com.gezi.GS.vo.sys.UserList;
import com.gezi.hdlw.service.sys.WxDataService;
import com.gezi.hdlw.util.DateUtil;
import com.gezi.hdlw.util.ResultBean;
import com.gezi.hdlw.util.wxHelpUtil;
import com.hazelcast.nio.serialization.Data;
import com.mysql.fabric.xmlrpc.base.Array;
import com.gezi.GS.util.DataHelpUtil;

import net.coobird.thumbnailator.Thumbnails;
@Controller
@RequestMapping("/personGrowth")
public class GrowthSystemShowController {
	@Resource
	public UserListService userListService;
	@Resource
	public MedalListService medalListService;
	@Resource
	public PerformListService performListService;
	@Resource
	public TaskListService taskListService;
	@Resource
	public TaskTypeListService taskTypeListService;
	@Resource
	public MyPlanListService myPlanListService;
	@Resource
	public wxHelpUtil wxHelpUtil;
	@Resource
	public ExamineListService examineListService;
	@Resource
	public ScoreListService scoreListService;
	
	@Resource
	public DataHelpUtil dataHelpUtil;
	@Resource
	public WxDataService wxDataService;
	
	//跳转到主页
	@RequestMapping("/mainWeb")
	public String mainWeb(HttpServletRequest request,HttpServletResponse response){
		
		if(!wxHelpUtil.openidCookie(request, response)){
			
			return "redirect:https://jwc.light-umbrella.com/gz_api/?url=https%3A%2F%2Fxx.light-umbrella.com%2FGrowthSystem%2FwxInterface%2FgetOpenId";	
		}else{
			if(wxDataService.selectWxDataByOpenid(wxHelpUtil.getOpenidByCookie(request, response)).size()>0){
				return "growthsystem/show/main";
			}else{
				return "redirect:https://jwc.light-umbrella.com/gz_api/?url=https%3A%2F%2Fxx.light-umbrella.com%2FGrowthSystem%2FwxInterface%2FgetOpenId";	
			}
		}
		/*return "redirect:https://jwc.light-umbrella.com/gz_api/?url=https%3A%2F%2Fxx.light-umbrella.com%2FGrowthSystem%2FwxInterface%2FgetOpenId";	*/
	}
	
	@RequestMapping("/newMainWeb")
	public String newMainWeb(){
		return "growthsystem/show/main";
	}
	
	//跳到任务列表页
	@RequestMapping("/taskListWeb")
	public String taskListWeb(HttpServletRequest request,HttpServletResponse response){
		if(!wxHelpUtil.openidCookie(request, response)){
			return "redirect:https://jwc.light-umbrella.com/gz_api/?url=https%3A%2F%2Fxx.light-umbrella.com%2FGrowthSystem%2FwxInterface%2FgetOpenId";	
		}else{
			return "growthsystem/show/taskList";
		}
	}
	//跳到选修列表页
	@RequestMapping("/electiveWeb")
	public String electiveWeb(HttpServletRequest request,HttpServletResponse response){
		if(!wxHelpUtil.openidCookie(request, response)){
			return "redirect:https://jwc.light-umbrella.com/gz_api/?url=https%3A%2F%2Fxx.light-umbrella.com%2FGrowthSystem%2FwxInterface%2FgetOpenId";	
		}else{
			return "growthsystem/show/elective";
		}
	}
	//跳到个人页
	@RequestMapping("/personWeb")
	public String personWeb(HttpServletRequest request,HttpServletResponse response){
		if(!wxHelpUtil.openidCookie(request, response)){
			
	        return "redirect:https://jwc.light-umbrella.com/gz_api/?url=https%3A%2F%2Fxx.light-umbrella.com%2FGrowthSystem%2FwxInterface%2FgetOpenId";
		}else{
			return "growthsystem/show/person";
		}
		
	}
	//跳到个人任务已领取页
	@RequestMapping("/myTaskWeb")
	public String myTaskWeb(HttpServletRequest request,HttpServletResponse response){
		if(!wxHelpUtil.openidCookie(request, response)){
			return "redirect:https://jwc.light-umbrella.com/gz_api/?url=https%3A%2F%2Fxx.light-umbrella.com%2FGrowthSystem%2FwxInterface%2FgetOpenId";	
		}else{
			return "growthsystem/show/myTask";
		}
	}
	//跳到打卡页
	@RequestMapping("/finishTaskWeb")
	public String finishTaskWeb(HttpServletRequest request,HttpServletResponse response){
		if(!wxHelpUtil.openidCookie(request, response)){
			return "redirect:https://jwc.light-umbrella.com/gz_api/?url=https%3A%2F%2Fxx.light-umbrella.com%2FGrowthSystem%2FwxInterface%2FgetOpenId";	
		}else{
			return "growthsystem/show/finishTask";
		}
	}
	
	
	//获取打卡计划
	@RequestMapping("showPlanListEvent")
	@ResponseBody
	public String showPlanListEvent(){
		return JSON.toJSONString(taskTypeListService.showType());
	}
	//获取计划任务列表
	@RequestMapping("showTaskListEvent")
	@ResponseBody
	public String showTaskListEvent(Integer taskTypeId,String openid){
		UserList userList =userListService.getUserByOpenId(openid);	
		List<TaskList> Tasklist=taskListService.getTypeTask2(taskTypeId);
		for(int i=0;i<Tasklist.size();i++){
			TaskList taskList2=Tasklist.get(i);
			taskList2.setState(performListService.selectPerformByUserIdAndTaskId(userList.getUserId(),Tasklist.get(i).getTaskId()));
			Tasklist.set(i, taskList2);	
		}
		for(int j=0;j<Tasklist.size();j++){
			TaskList taskList2=Tasklist.get(j);
			if(taskList2.getFatherId()==0){
				
			}else{
				for(int k=0;k<Tasklist.size();k++){
					TaskList taskList3=Tasklist.get(k);
					if((long)taskList2.getFatherId()==taskList3.getTaskId()&&taskList3.getState()!=5){
						taskList2.setState(6);
						taskList2.setReservedFields("解锁条件：完成"+taskListService.getTaskById(taskList2.getFatherId().intValue()).getTaskName());
						Tasklist.set(j, taskList2);
					}
				}
			}
		}		
	    for(int n=0;n<Tasklist.size();n++){
	    	for(int m=0;m<Tasklist.size()-n-1;m++){
	    		if(Tasklist.get(m).getState()>Tasklist.get(m+1).getState()){
	    			TaskList temp=Tasklist.get(m+1);
	    			Tasklist.set(m+1,Tasklist.get(m));
	    			Tasklist.set(m,temp);
	    		}
	    	}
	    }
		return JSON.toJSONString(Tasklist);
	}
	//获取个人任务列表
	@RequestMapping("/showMyTaskListEvent")
	@ResponseBody
	public String showMyTaskListEvent(String openid){
		UserList userList =userListService.getUserByOpenId(openid);
		List<TaskList> taskLists=taskListService.getAllTask();
		for(int i=0;i<taskLists.size();i++){
			TaskList taskList2=taskLists.get(i);
			taskList2.setState(performListService.selectPerformByUserIdAndTaskId(userList.getUserId(),taskLists.get(i).getTaskId()));
			if(taskList2.getState()==1){
				DateUtil dateUtil=new DateUtil();
				taskList2.setReservedFields(dateUtil.getStringDate(performListService.selectPerformByUserIdAndTaskId2(userList.getUserId(),taskList2.getTaskId()).getDeadline(), dateUtil.DATEFORMAT2));
			}
			taskLists.set(i, taskList2);		
		}
		for(int j=0;j<taskLists.size();j++){
			TaskList taskList2=taskLists.get(j);
			if(taskList2.getFatherId()==0){
				
			}else{
				for(int k=0;k<taskLists.size();k++){
					TaskList taskList3=taskLists.get(k);
					if((long)taskList2.getFatherId()==taskList3.getTaskId()&&taskList3.getState()!=5){
						taskList2.setState(6);
						taskLists.set(j, taskList2);
					}
				}
			}
		}
		for(int n=0;n<taskLists.size();n++){
	    	for(int m=0;m<taskLists.size()-n-1;m++){
	    		if(taskLists.get(m).getState()>taskLists.get(m+1).getState()){
	    			TaskList temp=taskLists.get(m+1);
	    			taskLists.set(m+1,taskLists.get(m));
	    			taskLists.set(m,temp);
	    		}
	    	}
	    }
		return JSON.toJSONString(taskLists);
	}
	//添加计划
	@RequestMapping("/addMyPlanEvent")
	@ResponseBody
	public ResultBean addMyPlanEvent(MyPlanList myPlanList){
		Date date=new Date();
		myPlanList.setCreateTime(date);
		myPlanList.setState(1);
		
		if(myPlanListService.addMyPlanList(myPlanList)>0){
			return new ResultBean(true);
		}else {
			return new ResultBean(false);
		}
		
	}
	
	//领取个人任务
	@RequestMapping("/addPerformListEvent")
	@ResponseBody
	public ResultBean addPerformListEvent(Integer taskId,String openid){
		TaskList taskList=taskListService.getTaskById(taskId);
		UserList userList=userListService.getUserByOpenId(openid);
		PerformList performList=new PerformList();
		Date date=new Date();
		performList.setCreateTime(date);
		performList.setFinishNumber(taskList.getFinishNumber());
		performList.setState(1);
		performList.setTaskId(taskId);
		performList.setUserId(userList.getUserId());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);   
        cal.add(Calendar.DATE, taskList.getDuration());
        date = cal.getTime();
		performList.setDeadline(date);
		if(performListService.addPerform(performList)>0){
			if(dataHelpUtil.getFlag("GSAddPerform", userList.getAddress(), new Date())){
				dataHelpUtil.addData(userList.getAddress(), 5, "领取清单任务");
			}
			return new ResultBean(true);
		}else {
			return new ResultBean(false);
		}
		
	}
	
	//接收图片保存
	@RequestMapping("/savePictureEvent")
	@ResponseBody
	public String savePictureEvent(HttpServletRequest request,MultipartFile file){
		String filePath="";
		String filePath2="";
		String saveName="";
		if (!file.isEmpty()) { 	
			Random rand = new Random();
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
			String time = df.format(new Date());
			int randnum1 = rand.nextInt(10000);
			String fileName = file.getOriginalFilename();
			String lastname = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			
			filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"+randnum1+time+lastname;
			filePath2 = request.getSession().getServletContext().getRealPath("/") + "upload/"+"slt"+randnum1+time+lastname;
			saveName=randnum1+time+lastname;  
            // 转存文件  
			System.out.println(file.getOriginalFilename());
            try {
				file.transferTo(new File(filePath));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				Thumbnails.of(filePath)   
				.size(600, 600)  
				.toFile(filePath2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}else{
		}
		System.out.println(filePath);
		System.out.println("3666");
		return JSON.toJSONString(saveName);
	}
	
	//保存审核信息
	@RequestMapping("/saveExamineList")
	@ResponseBody
	public ResultBean saveExamineList(ExamineList examineList,Integer taskId,String openid){
		
		UserList userList=userListService.getUserByOpenId(openid);
		if(performListService.selectPerformByUserIdAndTaskId2(userList.getUserId(), taskId)!=null){
			PerformList performList=performListService.selectPerformByUserIdAndTaskId2(userList.getUserId(), taskId);
			Date date=new Date();
			examineList.setCreateTime(date);
			examineList.setState(2);
			if(examineListService.add(examineList)>0){
				ExamineList examineList2=examineListService.selectByUrl(examineList.getExamineUrl());
				performList.setReservedFields(examineList2.getExamineId()+"");
				performList.setState(2);
				int flag=performListService.update(performList);
				if(dataHelpUtil.getFlag("GSAddExamine", userList.getAddress(), new Date())){
					dataHelpUtil.addData(userList.getAddress(), 20, "清单打卡");
				}
				return new ResultBean(true);
			}else {
				return new ResultBean(false);
			}
		}else{
			return new ResultBean(false);
		}	
	}
/*	//获取当前分值
	@RequestMapping("/getMyScoreEvent")
	@ResponseBody
	public String getMyScoreEvent(Long userId){
		Long score=scoreListService.getMyScore(userId);
		return score+"";
	}
	
	//修改分数
	@RequestMapping("/updMyScoreEvent")
	@ResponseBody
	public ResultBean updMyScoreEvent(ScoreList scoreList){
		if(scoreListService.updScoreList(scoreList)>0){
			return  new ResultBean(true);
		}else{
			return  new ResultBean(false);
		}
	}
	
	//获取未通过审核的数据
	@RequestMapping("/getExamineDetailEvent")
	@ResponseBody
	public String getExamineDetailEvent(){
		Map map=new HashMap<String, Object>();
		if(performListService.getExamineDetail()!=null){
			PerformList performList=performListService.getExamineDetail();
			ExamineList examineList=examineListService.getById(Integer.parseInt(performList.getReservedFields()));
			map.put("perform", performList);
			map.put("msg", "审核中");
		}else{
			map.put("msg", "已经全部审核完");
		}
		return JSON.toJSONString(map);
		
		
	}*/
	
	//更新分数
	@RequestMapping("/updScoreEvent")
	@ResponseBody
	public String updScoreEvent(Integer taskId,String openid){
		TaskList taskList=taskListService.getTaskById(taskId);
		UserList userList=userListService.getUserByOpenId(openid);
		PerformList performList=performListService.selectPerformByUserIdAndTaskId2(userList.getUserId(), taskId);
		if(performList.getState()==4){
			performList.setState(1);
			performListService.update(performList);
			return "审核没通过，请重新打卡喔";
		}else if(performList.getState()==3){
			ScoreList scoreList=new ScoreList();
			scoreList.setUserId(userList.getUserId());
			scoreList.setTaskid(taskList.getTaskId());
			scoreList.setScore(taskList.getScore().longValue());
			scoreList.setReservedFields("new");
			scoreList.setScoreDetail("完成任务"+taskList.getTaskId()+":"+taskList.getTaskName()+";成长值+"+taskList.getScore());
			if(scoreListService.updScoreList(scoreList)>0){
				performList.setState(5);
				performListService.update(performList);
				
			};
			return "恭喜完成任务,成长值+"+taskList.getScore();		
		}else{
			return "你任务完成了么";
		}
		
	}
	//获取个人成长值等信息
	@RequestMapping("/showAllEvent")
	@ResponseBody
	public String showAllEvent(String openid){
		UserList userList=userListService.getUserByOpenId(openid);
		Map map=new HashMap<String,Object>();
		Long score=scoreListService.getMyScore(userList.getUserId());
		map.put("score", score);
		Map map2=performListService.getMyTaskSize(userList.getUserId());
		map.put("Msg", map2);
		return JSON.toJSONString(map);
	}
	
	
	
}
