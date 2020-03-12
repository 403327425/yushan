package com.gezi.hdlw.controller.sys;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gezi.hdlw.search.sys.LwDictionaryTypeSearch;
import com.gezi.hdlw.service.sys.LwDictionaryTypeService;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwAdmin;
import com.gezi.hdlw.vo.sys.LwDictionaryType;

/**
 * 
 * @version:1.0
 * @Description:字典类型
 * @author:李云飞
 * @date: 2019年3月29日上午11:49:53
 */
@Controller
@RequestMapping("/dictionaryType")
public class LwDictionaryTypeController {
	
	@Resource
	private LwDictionaryTypeService lwDictionaryTypeService;
	
	/**
	 * 打开页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		return "/sys/dictionary/dictionaryTcList";
	}
	
	/**
	 * 查询 or 条件查询
	 * @param lwDictionaryTypeSearch
	 * @return
	 */
	@RequestMapping("getData")
	@ResponseBody
	public ResultUtil getData(LwDictionaryTypeSearch lwDictionaryTypeSearch){
		return lwDictionaryTypeService.ListByPage(lwDictionaryTypeSearch);
	}
	
	/**
	 * 进入新增或修改页面
	 * @param id
	 * @param model
	 * @param method
	 * @return
	 */
	@RequestMapping(value = "/toInsertOrupdate")
	public String toInsertOrupdate(Model model, String method,Integer dtkId) {
		List<LwDictionaryType> dictionaryTypeList = lwDictionaryTypeService.ListByTable();
		model.addAttribute("dictionaryTypeList", dictionaryTypeList);
		if (method.equals("ADD")) {
			model.addAttribute("titleName", "添加");
		} else if (method.equals("EDIT")) {
			LwDictionaryType dictionary = lwDictionaryTypeService.getById(dtkId);
			model.addAttribute("titleName", "编辑");
			model.addAttribute("data", dictionary);
		}
		return "/sys/dictionary/dictionaryTcEdit";
	}
	
	/**
	 *  执行新增或修改保存
	 * @param lwDictionaryType
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insertOrupdate")
	@ResponseBody
	public Map<String, Object> insertOrupdate(LwDictionaryType lwDictionaryType,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		if (null != lwDictionaryType.getDtkId() && lwDictionaryType.getDtkId() != 0) {// 修改
			lwDictionaryType.setDtModificationTime(new Date());
			if (lwDictionaryTypeService.updateSelective(lwDictionaryType) > 0) {
				result.put("STATE", "SUCCESS");
			} else {
				result.put("STATE", "FAIL");
			}
		} else {// 新增
			lwDictionaryType.setDtCreationTime(new Date());
			LwAdmin admin = (LwAdmin) SecurityUtils.getSubject().getPrincipal();
			lwDictionaryType.setDtOperator(admin.getId().intValue());
			if(lwDictionaryTypeService.insert(lwDictionaryType) > 0){
				result.put("STATE", "SUCCESS");
			}else{
				result.put("STATE", "FAIL");
			}
		}
		return result;
	}


}
