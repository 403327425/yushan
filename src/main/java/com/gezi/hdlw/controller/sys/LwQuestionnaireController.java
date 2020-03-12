package com.gezi.hdlw.controller.sys;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gezi.hdlw.search.sys.LwQuestionnaireSearch;
import com.gezi.hdlw.service.sys.LwQuestionnaireService;
import com.gezi.hdlw.util.IpAdrressUtil;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwQuestionnaire;


@Controller
@RequestMapping("/questionnaire")
public class LwQuestionnaireController {
	@Resource
	private LwQuestionnaireService lwQuestionnaireService;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insertQusertionnaire(@RequestBody LwQuestionnaire lwQuestionnaire){
		
		String back;
		if(lwQuestionnaireService.insert(lwQuestionnaire)>0){
			back="sys/questionnaire/test";
		}else{
			back="sys/questionnaire/test2";
		}
		return back;
		
	}
	@RequestMapping("/getData")
	@ResponseBody
	public ResultUtil getQusertionnaire(@RequestBody LwQuestionnaireSearch lwQuestionnaireSearch){
		System.out.println(lwQuestionnaireSearch.getPage());
		return lwQuestionnaireService.getQuestionnaire(lwQuestionnaireSearch);
	}
	
	@RequestMapping("/delect")
	@ResponseBody
	public Map<String, Object> delectQusertionnaire(Integer qnId){
		Map<String, Object> result = new HashMap<>();
		if (qnId != null && qnId != 0) {
			if (lwQuestionnaireService.deleteById(qnId) > 0) {
				result.put("STATE", "SUCCESS");
				result.put("MSG", "删除成功");
			} else {
				result.put("STATE", "FAIL");
				result.put("MSG", "删除失败");
			}
		} else {
			result.put("STATE", "FAIL");
			result.put("MSG", "数据异常");
		}
		return result;
	}
	
	@RequestMapping("/updata")
	@ResponseBody
	public Map<String, Object> updataQusertionnaire(@RequestBody LwQuestionnaire lwQuestionnaire){
		Map<String, Object> result = new HashMap<>();
		if(lwQuestionnaireService.updataQuestionnaire(lwQuestionnaire)>0){
			result.put("STATE", "SUCCESS");
			result.put("MSG", "修改成功");
		}else {
			result.put("STATE", "FAIL");
			result.put("MSG", "修改失败");
		}
		
		
		return result;
	}
	
	@RequestMapping("/qnTypeListView")
	public String roleList() {
		return "sys/questionnaire/qnTypeList";
	}
	
	@RequestMapping("/testIp")
	@ResponseBody
	public String testIp(HttpServletRequest request){
		String IP="";
		IpAdrressUtil ipAdrressUtil=new IpAdrressUtil();
		IP=ipAdrressUtil.getIpAdrress(request);
		return IP;
	}
}


