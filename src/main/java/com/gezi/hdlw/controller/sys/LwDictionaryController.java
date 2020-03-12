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

import com.gezi.hdlw.search.sys.LwDictionarySearch;
import com.gezi.hdlw.service.sys.LwDictionaryService;
import com.gezi.hdlw.service.sys.LwDictionaryTypeService;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwAdmin;
import com.gezi.hdlw.vo.sys.LwDictionary;
import com.gezi.hdlw.vo.sys.LwDictionaryType;

/**
 * 
 * @version:1.0
 * @Description:字典
 * @author:李云飞
 * @date: 2019年3月29日上午11:49:53
 */
@Controller
@RequestMapping("/dictionary")
public class LwDictionaryController {
	
	@Resource
	private LwDictionaryService lwDictionaryService;
	
	@Resource
	private LwDictionaryTypeService lwDictionaryTypeService;
	
	/**
	 * 打开页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		List<LwDictionaryType> dictionaryTypeList = lwDictionaryTypeService.ListByTable();
		model.addAttribute("dictionaryTypeList", dictionaryTypeList);
		model.addAttribute("titleName", "数据字典");
		return "/sys/dictionary/dictionaryList";
	}
	
	/**
	 * 查询 or 条件查询
	 * @param lwDictionarySearch
	 * @return
	 */
	@RequestMapping("getData")
	@ResponseBody
	public ResultUtil getData(LwDictionarySearch lwDictionarySearch){
		return lwDictionaryService.ListByPage(lwDictionarySearch);
	}
	
	/**
	 *  进入新增或修改页面
	 * @param model
	 * @param method
	 * @param dkId
	 * @return
	 */
	@RequestMapping(value = "/toInsertOrupdate")
	public String toInsertOrupdate(Model model, String method,Integer dkId) {
		List<LwDictionaryType> dictionaryTypeList = lwDictionaryTypeService.ListByTable();
		model.addAttribute("dictionaryTypeList", dictionaryTypeList);
		if (method.equals("ADD")) {
			model.addAttribute("titleName", "添加");
		} else if (method.equals("EDIT")) {
			LwDictionary dictionary = lwDictionaryService.getById(dkId);
			model.addAttribute("titleName", "编辑");
			model.addAttribute("data", dictionary);
		}
		return "/sys/dictionary/dictionaryEdit";
	}
	
	/**
	 * 执行新增或修改保存
	 * @param lwDictionary
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insertOrupdate")
	@ResponseBody
	public Map<String, Object> insertOrupdate(LwDictionary lwDictionary,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		if (null != lwDictionary.getDkId() && lwDictionary.getDkId() != 0) {// 修改
			lwDictionary.setdModificationTime(new Date());
			if (lwDictionaryService.updateSelective(lwDictionary) > 0) {
				result.put("STATE", "SUCCESS");
			} else {
				result.put("STATE", "FAIL");
			}
		} else {// 新增
			lwDictionary.setdCreationTime(new Date());
			LwAdmin admin = (LwAdmin) SecurityUtils.getSubject().getPrincipal();
			lwDictionary.setdOperator(admin.getId().intValue());
			if(lwDictionaryService.insert(lwDictionary) > 0){
				result.put("STATE", "SUCCESS");
			}else{
				result.put("STATE", "FAIL");
			}
		}
		return result;
	}
	
	/**
	 * 级联查询（根据表id查询别对应的字段）
	 * @param dtParentId
	 * @return
	 */
	@RequestMapping(value = "/selectByValue")
	@ResponseBody
	public Map<String, Object> selectByValue(Integer dtParentId) {
		Map<String, Object> result = new HashMap<>();
		List<LwDictionaryType> dictionaryTypeList = lwDictionaryTypeService.ListByParentId(dtParentId);
		result.put("data", dictionaryTypeList);
		return result;
	}
	
	/**
	 * 启用 or 停用
	 * @param lwDictionary
	 * @return
	 */
	@RequestMapping(value = "/alterStatus")
	@ResponseBody
	public Map<String, Object> alterStatus(LwDictionary lwDictionary) {
		Map<String, Object> result = new HashMap<>();
		if (lwDictionary.getDkId() != 0 && null != lwDictionary.getDictionaryStatus() && !lwDictionary.getDictionaryStatus().equals("")) {
			if (lwDictionaryService.updateSelective(lwDictionary) > 0) {
				result.put("STATE", "SUCCESS");
				result.put("MSG", "改变状态成功");
			} else {
				result.put("STATE", "FAIL");
				result.put("MSG", "改变状态失败");
			}
		} else {
			result.put("STATE", "FAIL");
			result.put("MSG", "数据异常");
		}
		return result;
	}

}
