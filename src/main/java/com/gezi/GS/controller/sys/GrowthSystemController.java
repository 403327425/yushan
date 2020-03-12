package com.gezi.GS.controller.sys;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.gezi.GS.example.sys.MedalListExample;
import com.gezi.GS.example.sys.PerformListExample;
import com.gezi.GS.example.sys.TaskListExample;
import com.gezi.GS.example.sys.TaskTypeListExample;
import com.gezi.GS.example.sys.UserListExample;
import com.gezi.GS.service.sys.ExamineListService;
import com.gezi.GS.service.sys.MedalListService;
import com.gezi.GS.service.sys.PerformListService;
import com.gezi.GS.service.sys.ScoreListService;
import com.gezi.GS.service.sys.TaskListService;
import com.gezi.GS.service.sys.TaskTypeListService;
import com.gezi.GS.service.sys.UserListService;
import com.gezi.GS.vo.sys.ExamineList;
import com.gezi.GS.vo.sys.PerformList;
import com.gezi.GS.vo.sys.ScoreList;
import com.gezi.GS.vo.sys.TaskList;
import com.gezi.GS.vo.sys.TaskTypeList;

import com.gezi.hdlw.util.ResultBean;
import com.gezi.hdlw.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("/growthSystem")
public class GrowthSystemController {
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
	public ScoreListService scoreListService;
	@Resource
	public ExamineListService examineListService;
	
	
	//跳转到任务列表页
	@RequestMapping("/taskListWeb")
	public String taskListWeb(){
		return "growthsystem/sys/taskList";
	}
	//跳转到任务列表页
	@RequestMapping("/taskTypeListWeb")
	public String taskTypeListWeb(){
		return "growthsystem/sys/taskTypeList";
	}
	//跳转的审核页
	@RequestMapping("/examineWeb")
	public String examineWeb(){
		return "growthsystem/sys/examine";
	}
	
	//系统内显示任务列表
	@RequestMapping("/showTaskListEvent")
	@ResponseBody
	public ResultUtil showTaskListEvent(Integer page, Integer limit,Integer taskTypeId){
		List<TaskList> list =taskListService.getTypeTask(taskTypeId);
		PageHelper.startPage(page, limit);
		PageInfo<TaskList> pageInfo=new PageInfo<TaskList>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		resultUtil.setCode(0);
		return resultUtil;
	}
	//系统内显示任务类型列表
	@RequestMapping("/showTaskTypeListEvent")
	@ResponseBody
	public ResultUtil showTaskTypeListEvent(Integer page, Integer limit){
		List<TaskTypeList>list=taskTypeListService.showType();
		PageHelper.startPage(page, limit);
		PageInfo<TaskTypeList> pageInfo=new PageInfo<TaskTypeList>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		resultUtil.setCode(0);
		return resultUtil;
	}
	//获取全部任务类型
	@RequestMapping("/getTaskTypeListEvent")
	@ResponseBody
	public String getTaskTypeListEvent(){
		List<TaskTypeList> list=taskTypeListService.showType();
		return JSON.toJSONString(list);
	}
	//添加任务类型
	@RequestMapping("/addTaskTypeListEvent")
	@ResponseBody
	public ResultBean addTaskTypeListEvent(TaskTypeList taskTypeList){
		Date date=new Date();
		taskTypeList.setCreateTime(date);
		taskTypeList.setState(1);
		if(taskTypeListService.addType(taskTypeList)>0){
			return new ResultBean(true);
		}else{
			return new ResultBean(false);
		}
	}
	//获得某类型的全部任务
	@RequestMapping("/getTypeTaskEvent")
	@ResponseBody
	public String getTypeTaskEvent(Integer taskTypeId){
		List<TaskList> list =taskListService.getTypeTask(taskTypeId);
		return JSON.toJSONString(list);
	}
	//添加任务
	@RequestMapping("/addTaskListEvent")
	@ResponseBody
	public ResultBean addTaskListEvent(TaskList taskList){
		Date date=new Date();
		taskList.setCreateTime(date);
		taskList.setState(2);
		taskList.setPeopleNumber(0);
		if(taskListService.addTask(taskList)>0){
			return new ResultBean(true);
		}else{
			return new ResultBean(false);
		}
	}
	//删除或更新任务类型
	@RequestMapping("/updateTaskTypeListEvent")
	@ResponseBody
	public ResultBean updateTaskTypeListEvent(TaskTypeList taskTypeList ,String msg){
		if (taskTypeListService.updateTaskTypeList(taskTypeList,msg)>0){
			return new ResultBean(true);
		}else{
			return new ResultBean(false);
		}
	}
	//删除或更新任务
	@RequestMapping("/updateTaskListEvent")
	@ResponseBody
	public ResultBean updateTaskListEvent(TaskList taskList,String msg){
		if (taskListService.updateTaskList(taskList,msg)>0){
			return new ResultBean(true);
		}else{
			return new ResultBean(false);
		}
	}
	
	//获取当前分值
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
			TaskList taskList=taskListService.getTaskById(performList.getTaskId());
			map.put("perform", performList);
			map.put("examineList", examineList);
			map.put("taskList", taskList);
			map.put("msg", "审核中");
		}else{
			map.put("msg", "已经全部审核完");
		}
		return JSON.toJSONString(map);
		
		
	}
	
	//修改审核状态
	@RequestMapping("/updAllEvent")
	@ResponseBody
	public String updAllEvent(String msg,Long performId,Integer examineId){
		System.out.println(msg+" "+performId+" "+examineId);
		if(performListService.updByMsg(performId,msg)>0){
			if(examineListService.updByMsg(examineId,msg)>0){
				return "修改成功";
			}else{
				return "修改失败";
			}
		}else{
			return "任务已审核";
		}
		
	}
	
	//保存图片返回json
	@RequestMapping("/savePhoto")
	@ResponseBody
	public String savePhoto(HttpServletRequest request,MultipartFile file){
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
		
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("code", 0);
		result.put("msg","success");
		result.put("data",saveName);
		System.out.println("3666"+JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	
	//更新任务类型图片
	@RequestMapping("/updateTypeImage")
	@ResponseBody
	public String updateTypeImage(Integer taskTypeId,String src){
		if(taskTypeListService.updateImage(taskTypeId,src)>0){
			return "修改成功";
		}else {
			return "修改失败";
		}
		
	}
	
	
}
