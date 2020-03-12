package com.gezi.hdlw.controller.sys;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.gezi.hdlw.service.sys.ChatGroupService;
import com.gezi.hdlw.service.sys.LwActivityService;
import com.gezi.hdlw.service.sys.LwCandidateService;
import com.gezi.hdlw.service.sys.LwVoterService;
import com.gezi.hdlw.service.sys.StudyDataService;
import com.gezi.hdlw.service.sys.WxDataService;
import com.gezi.hdlw.service.sys.impl.StudyDataServiceImpl;

import com.gezi.hdlw.util.IpAdrressUtil;
import com.gezi.hdlw.util.QRCodeUtil;
import com.gezi.hdlw.util.ResultBean;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.util.wxHelpUtil;
import com.gezi.hdlw.vo.sys.ChatGroup;
import com.gezi.hdlw.vo.sys.LwActivity;
import com.gezi.hdlw.vo.sys.LwAdmin;
import com.gezi.hdlw.vo.sys.LwCandidate;
import com.gezi.hdlw.vo.sys.LwVoter;
import com.gezi.hdlw.vo.sys.StudyData;
import com.gezi.hdlw.vo.sys.WxData;
import com.mysql.fabric.xmlrpc.base.Array;

import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("/vote")
public class LwVoteController {
	@Resource
	public LwCandidateService lwCandidateService;
	@Resource
	public LwActivityService lwActivityService;
	@Resource
	public LwVoterService lwVoterService;
	@Resource
	public IpAdrressUtil ipAdrressUtil;
	@Resource
	public wxHelpUtil wxHelpUtil;
	@Resource
	public ChatGroupService chatGroupService;
	@Resource
	public StudyDataService studyDataService;
	@Resource
	public WxDataService wxDataService;
	
	
	//系统活动编辑页
	@RequestMapping("/sysActivityEditWeb")
	public String sysActivityEditWeb(HttpServletRequest req ,Long activityId){
		if(activityId != null){
			req.setAttribute("activity",lwActivityService.selectAllById(activityId));
		}
		return "sys/system/activityEdit";
	}
	//系统活动列表页
	@RequestMapping("/sysActivityListWeb")
	public String sysActivityListWeb(){
		return "sys/system/activityList";
	}
	
	//系统参赛者编辑页
	@RequestMapping("/sysCandidateEditWeb")
	public String sysCandidateEditWeb(HttpServletRequest req ,Long candidateId){
		if(candidateId != null){
			req.setAttribute("candidate",lwCandidateService.selectAllById(candidateId));
			
		}
		req.setAttribute("activityList", lwActivityService.selectAll());
		return "sys/system/candidateEdit";
	}
	//系统参赛者列表页
	@RequestMapping("/sysCandidateListWeb")
	public String sysCandidateListWeb(){
		return "sys/system/candidateList";
	}
	//系统投票编辑页
	@RequestMapping("/sysVoterEditWeb")
	public String sysVoterEditWeb(HttpServletRequest req ,Long id){
		if(id != null){
			req.setAttribute("voter",lwVoterService.getById(id));
		}
		req.setAttribute("activityList", lwActivityService.selectAll());
		return "sys/system/voterEdit";
	}
	//系统投票列表页
	@RequestMapping("/sysVoterListWeb")
	public String sysVoterListWeb(){
		return "sys/system/voterList";
	}
    //活动主页
	@RequestMapping("/voteIndex")
	public String voteIndex(long activityId){
		lwActivityService.addVisitCount(activityId);
		return "vote/voteIndex";
	}
	//活动主页
	@RequestMapping("/voteIndex2")
	public String voteIndex2(long activityId,String openid,RedirectAttributes redirectAttributes){
		lwActivityService.addVisitCount(activityId);
		redirectAttributes.addFlashAttribute("openid", openid);
		redirectAttributes.addAttribute("activityId",activityId);
		return "redirect:/vote/voteIndex";
	}
	
	//报名页
	@RequestMapping("/signUpWeb")
	public String signUpWeb(HttpServletRequest request,HttpServletResponse response){
		

		return "vote/signUp";
	}
	//报名页
	@RequestMapping("/signUpWeb2")
	public String signUpWeb2(long activityId,String openid,RedirectAttributes redirectAttributes){
		
		redirectAttributes.addFlashAttribute("openid", openid);
		redirectAttributes.addAttribute("activityId",activityId);
		return "redirect:/vote/signUpWeb";
	}
	
	@RequestMapping("/activityWeb")
	public String activityWeb(){
		return "vote/activityIndex";
	}
	
	@RequestMapping("/activityListWeb")
	public String activityListWeb(){
		return "vote/activityList";
	}
	
	@RequestMapping("/voteRuleWeb")
	public String voteRuleWeb(){
		return "vote/voteRule";
	}
	
	@RequestMapping("/voteRankingWeb")
	public String voteRankingWeb(){
		return "vote/voteRanking";
	}
	
	@RequestMapping("/voteContentWeb")
	public String voteContentWeb(){
		return "vote/voteContent";
	}
	
	//保存图片
	@RequestMapping(value="/saveImage",method=RequestMethod.POST)
	@ResponseBody
	public String signUp(HttpServletRequest request, MultipartFile file){
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
	
	//系统保存图片
	@RequestMapping(value="/sysSaveImage",method=RequestMethod.POST)
	@ResponseBody
	public ResultBean sysSignUp(HttpServletRequest request, MultipartFile file){
		String filePath="";
		String saveName="";
		if (!file.isEmpty()) { 
			
			Random rand = new Random();
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
			String time = df.format(new Date());
			int randnum1 = rand.nextInt(10000);
			String fileName = file.getOriginalFilename();
			String lastname = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			
			filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"+randnum1+time+lastname;  
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
		}else{
		}
		 
		System.out.println(filePath);
		System.out.println("3666");
		return new ResultBean(true,saveName);
	}
	
	@RequestMapping("/sysGetAllActivity")
	@ResponseBody
	public ResultUtil sysGetAllActivity(Integer page, Integer limit,String activityName,Date beginDate,Date endDate) {
		System.out.println(activityName+"8855544"+beginDate+" "+endDate);
		if(activityName==null&&beginDate==null&&endDate==null){
			return lwActivityService.listOrByWhere(page, limit);
		}else{
			return lwActivityService.selectListOrWhere(page, limit, activityName, beginDate, endDate);
		}
	}
	
	@RequestMapping("/sysActivityDel")
	@ResponseBody
	public ResultBean sysActivityDel(Long activityId){
		if(lwActivityService.deleteById(activityId)>0){
			return new ResultBean(true);
		}else{
			return new ResultBean(false);
		}
	}
	
	@RequestMapping("/sysActivityUpdate")
	@ResponseBody
	public ResultBean sysActivityUpdate(LwActivity lwActivity){	
		if(lwActivityService.update(lwActivity)> 0){  
			return new ResultBean(true);
		}else{
			return new ResultBean(false);
			}
	}
	
	
	@RequestMapping("/sysActivityInsert")
	@ResponseBody
	public ResultBean sysActivityInsert(LwActivity lwActivity){
		long temp =0;
		lwActivity.setVisitCount(temp);
		if(lwActivityService.insert(lwActivity)> 0){  
			return new ResultBean(true);
		}else{
			return new ResultBean(false);
			}
	}
	//
	@RequestMapping("/sysGetAllCandidate")
	@ResponseBody
	public ResultUtil sysGetAllCandidate(Integer page, Integer limit,String activitySelectName,String candidateSelectName) {
		
		
		
		
		System.out.println(activitySelectName+"852852"+candidateSelectName);
		List<LwActivity> list=null;
		if(activitySelectName!=""||activitySelectName!=null){
			list=lwActivityService.selectByName(activitySelectName);
			System.out.println(list);
			if(list.size()==0){
				LwActivity lwActivity=new LwActivity();
				long i=-1;
				lwActivity.setActivityId(i);
				list.add(lwActivity);
			}
		}
		
		
			
		
			return lwCandidateService.listOrByWhere(page, limit, candidateSelectName,list);
		
		
	}
	@RequestMapping("/sysGetCandidateById")
	@ResponseBody
	public String sysGetCandidateById(String candidateId) {
		long l = Long.parseLong(candidateId);
		
		return JSON.toJSONString(lwCandidateService.selectAllById(l));
	}
	
	@RequestMapping("/sysCandidateDel")
	@ResponseBody
	public ResultBean sysCandidateDel(Long candidateId){
		System.out.println(candidateId+"测试数据");
		if(lwCandidateService.deleteById(candidateId)>0){
			return new ResultBean(true);
		}else{
			return new ResultBean(false);
		}
	}
	
	@RequestMapping("/sysCandidateUpdate")
	@ResponseBody
	public ResultBean sysCandidateUpdate(LwCandidate lwCandidate){	
		if(lwCandidateService.update(lwCandidate)> 0){  
			return new ResultBean(true);
		}else{
			return new ResultBean(false);
			}
	}
	
	
	@RequestMapping("/sysCandidateInsert")
	@ResponseBody
	public ResultBean sysCandidateInsert(LwCandidate lwCandidate){
		
		if(lwCandidateService.signUp(lwCandidate)> 0){  
			return new ResultBean(true);
		}else{
			return new ResultBean(false);
			}
	}
	//
	@RequestMapping("/sysGetAllVoter")
	@ResponseBody
	public ResultUtil sysGetAllVoter(Integer page, Integer limit,Long activityId) {
		System.out.print(activityId);
		return lwVoterService.listOrByWhere(page, limit,activityId);
	}
	
	@RequestMapping("/sysVoterDel")
	@ResponseBody
	public ResultBean sysVoterDel(Long id){
		System.out.println(id+"测试数据");
		if(lwVoterService.deleteById(id)>0){
			return new ResultBean(true);
		}else{
			return new ResultBean(false);
		}
	}
	
	@RequestMapping("/sysVoterUpdate")
	@ResponseBody
	public ResultBean sysVoterUpdate(LwVoter lwVoter){	
		if(lwVoterService.update(lwVoter)> 0){  
			return new ResultBean(true);
		}else{
			return new ResultBean(false);
			}
	}
	
	
	@RequestMapping("/sysVoterInsert")
	@ResponseBody
	public ResultBean sysVoterInsert(LwVoter lwVoter){
		
		if(lwVoterService.insert(lwVoter)> 0){  
			return new ResultBean(true);
		}else{
			return new ResultBean(false);
			}
	}
	
	
	//报名活动
	@RequestMapping("/signUp")
	public String signUp(LwCandidate lwCandidate){
		String result="";
		String temp=lwActivityService.findPreFix(lwCandidate.getActivityId());
	    int temp2=1;
	    String temp3="00"+temp2;
	    String temp4=temp3.substring(temp3.length()-3,temp3.length());
	    String selectId=temp+temp4;
	    while (lwCandidateService.selectBySelectId(selectId)) {
			temp2++;
			temp3="00"+temp2;
		    temp4=temp3.substring(temp3.length()-3,temp3.length());
		    selectId=temp+temp4;
			System.out.println(selectId+"+++++++++++++++++++");
		}
	    lwCandidate.setSelectId(selectId);
		if(lwCandidateService.signUp(lwCandidate)> 0){
			result="redirect:/vote/voteIndex?activityId="+lwCandidate.getActivityId()+"";
		}else{
			result="redirect:/vote/signUp";
			}
		return result;
		
	}
	
	@RequestMapping("/testOnly")
	@ResponseBody
	public String  testOnly(LwCandidate lwCandidate){
		String result = "";
		if(lwCandidateService.selectBy(lwCandidate).isEmpty()){
			result="";
		}else{
			result="该手机已经被注册";
		}
		return JSON.toJSONString(result);
	}
	
	@RequestMapping("/testOnly2")
	@ResponseBody
	public String  testOnly2(LwCandidate lwCandidate){
		String result = "";
		if(lwCandidateService.selectBy2(lwCandidate).isEmpty()){
			result="";
		}else{
			result="该微信账号已经在本活动报名";
		}
		return JSON.toJSONString(result);
	}
	
	//发布投票活动
	@RequestMapping("/publish")
	public String  publish(HttpServletRequest request,HttpSession session,LwActivity lwActivity){
		
		long temp =0;
		lwActivity.setVisitCount(temp);
		String temp2="AA";
		while (lwActivityService.selectPreFix(temp2)) {
			char[] c=temp2.toCharArray();
			if(c.length==2){
				int A=(int)c[0];
				int B=(int)c[1];
				
				if(B==90){
					if(A==90){
					   temp2="AAA";
					}else{
						A++;
						B=65;
						StringBuffer sbu = new StringBuffer(); 
						sbu.append((char)A); 
						sbu.append((char)B);
						temp2=sbu.toString();
						
					}
				}else{
					B++;
					System.out.println(A +"++++++++++++++++++++++"+B);
					StringBuffer sbu = new StringBuffer(); 
					sbu.append((char)A); 
					sbu.append((char)B);
					temp2=sbu.toString();
					System.out.println("++++++++++++++++++++++"+temp2);
				}
			}
			if(c.length==3){
				int A=(int)c[0];
				int B=(int)c[1];
				int C=(int)c[2];
				if(C==90){
					if(B==90){
						if(A==90){
							temp2="AAAA";
						}else{
							A++;
							B=65;
							C=65;
							StringBuffer sbu = new StringBuffer(); 
							sbu.append((char)A); 
							sbu.append((char)B);
							sbu.append((char)C);
							temp2=sbu.toString();
						}
					}else{
						B++;
						C=65;
						StringBuffer sbu = new StringBuffer(); 
						sbu.append((char)A); 
						sbu.append((char)B);
						sbu.append((char)C);
						temp2=sbu.toString();
					}
				}else{
					C++;
					StringBuffer sbu = new StringBuffer(); 
					sbu.append((char)A); 
					sbu.append((char)B);
					sbu.append((char)C);
					temp2=sbu.toString();
				}
			}
		}
		lwActivity.setPrefix(temp2);
		
		
		if(lwActivityService.insert(lwActivity)> 0){
			 long activityId = lwActivityService.getActivityId(lwActivity);
				String text = "http://xx.light-umbrella.com/votePro/vote/voteIndex?activityId="+activityId;
				// 嵌入二维码的图片路径
				String imgPath =  request.getSession().getServletContext().getRealPath("/") +"upload/logo1.png";
				// 生成的二维码的路径及名称
				Random rand = new Random();
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
				String time = df.format(new Date());
				int randnum1 = rand.nextInt(10000);
				String destPath =  request.getSession().getServletContext().getRealPath("/") +"upload/"+time+""+randnum1+".jpg";
				//生成二维码
				System.out.println(destPath);
				try {
					QRCodeUtil.encode(text, imgPath, destPath, true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lwActivity.setActivityId(activityId);
				lwActivity.setQrCode(time+randnum1+".jpg");
				lwActivityService.update(lwActivity);


			/*return "redirect:/vote/voteIndex?activityId="+activityId+"";*/
				return "redirect:/upload/"+time+""+randnum1+".jpg";
		}else{
			return "vote/activityIndex"; 
		}
	}
	//获取活动列表
	@RequestMapping("/getAllActivity")
	@ResponseBody
	public String  getAllActivity(){
		
		List<LwActivity> list=lwActivityService.selectAll();
		return JSON.toJSONString(list);
	}
	
	

	
	//获取活动信息
	@RequestMapping("/getAllActivityById")
	@ResponseBody
	public String  getAllActivityById(String activityId){
		long l = Long.parseLong(activityId);
		LwActivity lwActivity=lwActivityService.selectAllById(l);
		return JSON.toJSONString(lwActivity);
	}
	//获取参赛者列表
	@RequestMapping("/getAllCandidateByActivityId")
	@ResponseBody
	public String  getAllCandidateByActivityId(String activityId){
		System.out.print(activityId);
		long l = Long.parseLong(activityId);
		LwActivity lwActivity=lwActivityService.selectAllById(l);
		List<LwCandidate> list=lwCandidateService.selectByActivityId(l);
		for(int i=0;i<list.size();i++){
			LwVoter lwVoter= new LwVoter();
			lwVoter.setActivityId(l);
			lwVoter.setCandidateId(list.get(i).getCandidateId());
			int count=lwVoterService.selectCount(lwVoter);
			String count2=count+"";
			list.get(i).setIphone(count2);
		}
		if(lwActivity.getSortMode()==1){
			for(int i=0;i<list.size()/2;i++){
				LwCandidate TempCandidate=new LwCandidate();
				TempCandidate=list.get(i);
				list.set(i, list.get(list.size()-i-1));
				list.set(list.size()-i-1, TempCandidate);
			}
		}else if(lwActivity.getSortMode()==2){
			 for(int i=0 ;i<list.size();i++){
				 for(int j=0;j<list.size()-i-1;j++){
					 if( Integer.parseInt(list.get(j).getIphone())< Integer.parseInt(list.get(j+1).getIphone())){
						 LwCandidate TempCandidate=new LwCandidate();
						 TempCandidate=list.get(j);
						 list.set(j, list.get(j+1));
						 list.set(j+1, TempCandidate);
					 }
				 }
			 }
		}
		return JSON.toJSONString(list);
	}
	//投票
	@RequestMapping("/voteMark")
	@ResponseBody
	public String  voteMark(HttpServletRequest request,LwVoter lwVoter){
		System.out.print(lwVoter.getActivityId());
		System.out.print(lwVoter.getCandidateId());
		String result="";
		Date nowDate = new Date();
		lwVoter.setVoteTime(nowDate);
/*		String Ip=ipAdrressUtil.getIpAdrress(request);
		lwVoter.setIp(Ip);*/
		LwActivity lwActivity=lwActivityService.selectAllById(lwVoter.getActivityId());
		Boolean boolean1=true;
		
		if(lwActivity.getVoteMode()==1){
			List<LwVoter> list=lwVoterService.check(lwVoter);
			if(list.size()>=lwActivity.getLimitNumber()){
				boolean1=false;
				result="投票次数上限";
			}else if(lwActivity.getLimitMode()==1){
				for(int i=0;i<list.size();i++){
					if(lwVoter.getCandidateId()==list.get(i).getCandidateId()){
						boolean1=false;
						result="不能重复投票";
					}
				}
			}			
		}else if(lwActivity.getVoteMode()==2){
			List<LwVoter> list=lwVoterService.check(lwVoter);
			int temp=0;
			for(int i=0;i<list.size();i++){
				if(isSameDay(nowDate,list.get(i).getVoteTime())){
					temp=temp+1;
				}
			}
			if(temp>=lwActivity.getLimitNumber()){
				boolean1=false;
				result="今天投票次数上限";
			}else if(lwActivity.getLimitMode()==1){
				for(int i=0;i<list.size();i++){
					if(lwVoter.getCandidateId()==list.get(i).getCandidateId()){
						boolean1=false;
						result="不能重复投票";
					}
				}
			}
		}
		
		
		if(boolean1){
			if(lwVoterService.insert(lwVoter)>0){
				result="投票成功";
			}else{
				result="投票失败";
			}
		}else{
			
		}
		
		int count=lwVoterService.selectCount(lwVoter);
		String count2=count+"";
		String[] result2={result,count2};
		return JSON.toJSONString(result2);
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
	//根据名字和id搜索
	@RequestMapping("/getLikeCandidateByActivityId")
	@ResponseBody
	public String  getLikeCandidateByActivityId(LwCandidate lwCandidate){
		
		long l = lwCandidate.getActivityId();
		List<LwCandidate> list=lwCandidateService.selectLikeByActivityId(lwCandidate);
		for(int i=0;i<list.size();i++){
			LwVoter lwVoter= new LwVoter();
			lwVoter.setActivityId(l);
			lwVoter.setCandidateId(list.get(i).getCandidateId());
			
			int count=lwVoterService.selectCount(lwVoter);
			String count2=count+"";
			list.get(i).setIphone(count2);
		}
		return JSON.toJSONString(list);
	}
	//根据名字和选择编号搜索
	@RequestMapping("/getLikeCandidateByActivityId2")
	@ResponseBody
	public String  getLikeCandidateByActivityId2(LwCandidate lwCandidate){
		
		long l = lwCandidate.getActivityId();
		List<LwCandidate> list=lwCandidateService.selectLikeByActivityIdAndName(lwCandidate);
		for(int i=0;i<list.size();i++){
			LwVoter lwVoter= new LwVoter();
			lwVoter.setActivityId(l);
			lwVoter.setCandidateId(list.get(i).getCandidateId());
			
			int count=lwVoterService.selectCount(lwVoter);
			String count2=count+"";
			list.get(i).setIphone(count2);
		}
		return JSON.toJSONString(list);
	}
	
	
	
	@RequestMapping("/getAllVoteCount")
	@ResponseBody
	public String  getAllVoteCount(Long activityId){
		return JSON.toJSONString(lwVoterService.getAllCountById(activityId));
	}
	
	
	
	//跳转页面到雨伞投票列表页面
	@RequestMapping("/voteIndex2Web")
	public String voteIndex2(HttpServletRequest request,HttpServletResponse response){
		if(!wxHelpUtil.openidCookie(request, response)){
			
			return "redirect:http://jwc.light-umbrella.com/gz_api/?url=http%3A%2F%2Fxx.light-umbrella.com%2FvotePro%2FwxInterface%2FgetOpenId";
		}else {
			List<WxData> list=wxDataService.selectWxDataByOpenid(wxHelpUtil.getOpenidByCookie(request, response));
			Date date2 =list.get(0).getJsapiTicketTime();
	        Calendar cal2 = Calendar.getInstance();   
	        cal2.setTime(date2);   
	        cal2.add(Calendar.DATE, 30);//30天
	        date2 = cal2.getTime();
	        Date date3=new Date();
	        if(date2.after(date3)){
	    		
	    	}else{
	    		return "redirect:http://jwc.light-umbrella.com/gz_api/?url=http%3A%2F%2Fxx.light-umbrella.com%2FvotePro%2FwxInterface%2FgetOpenId";
	    	}
			
		}
		return "vote/voteIndex2";
	}
	
	//跳转页面到雨伞活动生成页面
	@RequestMapping("/activityIndex2Web")
	public String activityIndex2(HttpServletRequest request,HttpServletResponse response){
		/*wxHelpUtil.openidCookie(request, response);*/
		if(!wxHelpUtil.openidCookie(request, response)){
			return "redirect:http://jwc.light-umbrella.com/gz_api/?url=http%3A%2F%2Fxx.light-umbrella.com%2FvotePro%2FwxInterface%2FgetOpenId";
		}
		return "vote/activityIndex2";
	}
	//跳转页面到雨伞个人中心页面
	@RequestMapping("/personalCenterWeb")
	public String personalCenter(HttpServletRequest request,HttpServletResponse response){
		/*wxHelpUtil.openidCookie(request, response);*/
		if(!wxHelpUtil.openidCookie(request, response)){
			return "redirect:http://jwc.light-umbrella.com/gz_api/?url=http%3A%2F%2Fxx.light-umbrella.com%2FvotePro%2FwxInterface%2FgetOpenId";
		}
		return "vote/personalCenter";
	}
	//获取个人参加的活动
	@RequestMapping("/findPersonJoin")
	@ResponseBody
	public String findPersonJoin(String openid){
		List<LwCandidate>list=lwCandidateService.selectByOpenid(openid);
		List<Object>list2=new ArrayList<Object>();
		List<Object>list3=new ArrayList<Object>();
		for(int i=0;i<list.size();i++){
			LwVoter lwVoter=new LwVoter();
			lwVoter.setActivityId(list.get(i).getActivityId());
			lwVoter.setCandidateId(list.get(i).getCandidateId());
			int count=lwVoterService.selectCount(lwVoter);
			list2.add(count);
			LwActivity lw1=lwActivityService.selectAllById(list.get(i).getActivityId());
			list3.add(lw1);
		}
		List<Object>list4=new ArrayList<Object>();
		list4.add(list);
		list4.add(list2);
		list4.add(list3);
		return JSON.toJSONString(list4);
	}
	//获取个人投票的活动
	@RequestMapping("/findPersonVote")
	@ResponseBody
	public String findPersonVote(String openid){
		List<LwVoter>list=lwVoterService.selectByOpenid(openid);
		List<Object>list2=new ArrayList<Object>();
		List<Object>list3=new ArrayList<Object>();
		for(int i=0;i<list.size();i++){
			LwActivity lw1=lwActivityService.selectAllById(list.get(i).getActivityId());
			LwCandidate lw2=lwCandidateService.selectAllById(list.get(i).getCandidateId());
			list2.add(lw1);
			list3.add(lw2);
		}
		List<Object>list4=new ArrayList<Object>();
		list4.add(list);
		list4.add(list2);
		list4.add(list3);
		return JSON.toJSONString(list4);
	}
	//获取个人发起的活动
	@RequestMapping("/findPersonPublish")
	@ResponseBody
	public String findPersonPublish(String openid){
		return JSON.toJSONString(lwActivityService.selectByOpenid(openid));
	}
	//获取个人发起的活动方式2
	@RequestMapping("/findPersonPublish2")
	@ResponseBody
	public ResultUtil findPersonPublish2(Integer page, Integer limit,String openid){
		return lwActivityService.selectByOpenid2(page,limit,openid);
	}
	//获取个人活动参赛者列表
	@RequestMapping("/getPersonActivityCandidateList")
	@ResponseBody
	public ResultUtil getPersonActivityCandidateList(Integer page, Integer limit,long activityId) {
		return lwCandidateService.selectByActivityId(page, limit, activityId);
	}
	//退出登录
	@RequestMapping("/outUser")
	public String outUser(HttpServletRequest request,HttpServletResponse response){
		wxHelpUtil.delectOpenidCookie(request, response);
		if(!wxHelpUtil.openidCookie(request, response)){
			return "redirect:http://jwc.light-umbrella.com/gz_api/?url=http%3A%2F%2Fxx.light-umbrella.com%2FvotePro%2FwxInterface%2FgetOpenId";
		}
		return "vote/voteIndex2";
	}
	
	@RequestMapping("voteBYHDX")
	public String voteBYHDX(String openid,String select_id){
		String result="";
		return result;
	}
	
	
	//上传群聊二维码页面
	@RequestMapping("/addQRCodeWeb")
	public String addQRCodeWeb(){
		return "chat/add";
	}
	//群二维码列表页面
	@RequestMapping("/showQRCodeWeb")
	public String showQRCodeWeb(){

		return "chat/list";
	}
	//更新群二维码列表页面
		@RequestMapping("/updateQRCodeWeb")
		public String updateQRCodeWeb(){

			return "chat/update";
		}
	//上传二维码
	@RequestMapping("saveQRImage")
	@ResponseBody
	public String saveQRImage(HttpServletRequest request, MultipartFile file){
		String filePath="";
		String saveName="";
		if (!file.isEmpty()) { 
			
			Random rand = new Random();
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
			String time = df.format(new Date());
			int randnum1 = rand.nextInt(10000);
			String fileName = file.getOriginalFilename();
			String lastname = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			
			filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"+randnum1+time+lastname;  
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
		}else{
		}
		 
		System.out.println(filePath);
		System.out.println("3666");
		Map data=new HashMap<>();
		data.put("src", saveName);
		Map map=new HashMap<>();
		map.put("code",0);
		map.put("msg", "success");
		map.put("data", data);
		
		System.out.println(JSON.toJSONString(map));
		return JSON.toJSONString(map);
	}
	
	//提交二维信息
	@RequestMapping("saveQRMsg")
	@ResponseBody
	public String saveQRMsg(ChatGroup chatGroup){
		Date nowDate = new Date();
		chatGroup.setStartTime(nowDate);
		int result = 0;
		if(chatGroup.getSchoolName().equals("-100")){
			String name0="东莞理工学院(松山湖)";
			String name1="东莞理工学院(莞城)";
			String name2="广东医科大学(东莞)";
			String name3="广东创新科技职业学院";
			String name4="东莞职业技术学院";
			String name5="广东科技学院";
			String name6="中山大学新华学院";
			String name7="广东酒店管理职业技术学院";
			List<String> list = new ArrayList<String>();
			list.add(name0);
			list.add(name1);
			list.add(name2);
			list.add(name3);
			list.add(name4);
			list.add(name5);
			list.add(name6);
			list.add(name7);
			for(int i=0;i<8;i++){
				chatGroup.setSchoolName(list.get(i));
				result =chatGroupService.addCG(chatGroup);
			}
		}else{
			result =chatGroupService.addCG(chatGroup);
		}
		
		
		
		
		Map data=new HashMap<>();
		data.put("msg", result);
		return JSON.toJSONString(data);
	}
	//获取二维码列表
	@RequestMapping("getQRList")
	@ResponseBody
	public String getQRList(){
		
		return JSON.toJSONString(chatGroupService.selectALLCG());
	}
	//更新二维码信息
	@RequestMapping("updateQRMsg")
	@ResponseBody
	public String updateQRMsg(ChatGroup chatGroup){
		Date nowDate = new Date();
		chatGroup.setStartTime(nowDate);
		int result =chatGroupService.updateCG(chatGroup);
		

		Map data=new HashMap<>();
		data.put("msg", result);
		return JSON.toJSONString(data);
	}
	//上传学习资料页面
	@RequestMapping("/addSDWeb")
	public String addSDWeb(){
		return "sd/add";
	}
	//学习质料列表页面
	@RequestMapping("/showSDWeb")
	public String showSDWeb(){

		return "sd/list";
	}
	//提交学习资料
	@RequestMapping("saveSDMsg")
	@ResponseBody
	public String saveSDMsg(StudyData studyData){
		Date nowDate = new Date();
		studyData.setStartTime(nowDate);
		int result =studyDataService.addSD(studyData);
		Map data=new HashMap<>();
		data.put("msg", result);
		return JSON.toJSONString(data);
	}
	//获取学习资料
	@RequestMapping("getSDList")
	@ResponseBody
	public String getSDList(){
		
		return JSON.toJSONString(studyDataService.selectALLSD());
	}
	//最新发起点赞页面
	@RequestMapping("addActivityWeb")
	public String addActivityWeb(HttpServletRequest request,HttpServletResponse response){
		/*if(!wxHelpUtil.openidCookie(request, response)){
			
			return "redirect:http://jwc.light-umbrella.com/gz_api/?url=http%3A%2F%2Fxx.light-umbrella.com%2FvotePro%2FwxInterface%2FgetOpenId";
		}else {
			List<WxData> list=wxDataService.selectWxDataByOpenid(wxHelpUtil.getOpenidByCookie(request, response));
			Date date2 =list.get(0).getJsapiTicketTime();
	        Calendar cal2 = Calendar.getInstance();   
	        cal2.setTime(date2);   
	        cal2.add(Calendar.DATE, 30);//30天
	        date2 = cal2.getTime();
	        Date date3=new Date();
	        if(date2.after(date3)){
	    		
	    	}else{
	    		return "redirect:http://jwc.light-umbrella.com/gz_api/?url=http%3A%2F%2Fxx.light-umbrella.com%2FvotePro%2FwxInterface%2FgetOpenId";
	    	}
			
		}*/
		return "vote/addActivity";
	}
	//最新活动列表页面
		@RequestMapping("activityListIndexWeb")
		public String activityListIndexWeb(HttpServletRequest request,HttpServletResponse response){
			/*if(!wxHelpUtil.openidCookie(request, response)){
				
				return "redirect:http://jwc.light-umbrella.com/gz_api/?url=http%3A%2F%2Fxx.light-umbrella.com%2FvotePro%2FwxInterface%2FgetOpenId";
			}else {
				List<WxData> list=wxDataService.selectWxDataByOpenid(wxHelpUtil.getOpenidByCookie(request, response));
				Date date2 =list.get(0).getJsapiTicketTime();
		        Calendar cal2 = Calendar.getInstance();   
		        cal2.setTime(date2);   
		        cal2.add(Calendar.DATE, 30);//30天
		        date2 = cal2.getTime();
		        Date date3=new Date();
		        if(date2.after(date3)){
		    		
		    	}else{
		    		return "redirect:http://jwc.light-umbrella.com/gz_api/?url=http%3A%2F%2Fxx.light-umbrella.com%2FvotePro%2FwxInterface%2FgetOpenId";
		    	}
				
			}*/
			return "vote/activityListIndex";
		}
	
	
	
}
