package com.gezi.hdlw.controller.sys;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gezi.hdlw.service.sys.LwRecordService;

import com.gezi.hdlw.vo.sys.LwRecord;

@Controller
@RequestMapping("/record")
public class LwRecordController {
	
	@Resource
	private LwRecordService lwRecordService;
	
	@RequestMapping("/insert")
	@ResponseBody
	public Map<String, Object> insertQusertionnaire(@RequestBody LwRecord lwRecord){
		Map<String, Object> result = new HashMap<>();
		if(lwRecordService.insert(lwRecord)>0){
			result.put("STATE", "SUCCESS");
		} else {
			result.put("STATE", "FAIL");
		}
		return result;
	}
}
