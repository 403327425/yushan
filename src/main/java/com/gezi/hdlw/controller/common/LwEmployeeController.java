package com.gezi.hdlw.controller.common;

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

import com.gezi.hdlw.search.common.LwEmployeeSearch;
import com.gezi.hdlw.service.common.LwEmployeeService;
import com.gezi.hdlw.service.sys.LwDictionaryService;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.common.LwEmployee;
import com.gezi.hdlw.vo.sys.LwAdmin;
import com.gezi.hdlw.vo.sys.LwDictionary;

/**
 * 
 * @version:1.0
 * @Description:员工
 * @author:李云飞
 * @date: 2019年4月2日上午11:07:04
 */
@Controller
@RequestMapping("/employee")
public class LwEmployeeController {
	
	@Resource
	private LwEmployeeService lwEmployeeService;
	
	@Resource
	private LwDictionaryService lwDictionaryService;
	
	/**
	 * 打开页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		//获取数据字典职业
		LwDictionary lwDictionary = new LwDictionary();
		lwDictionary.setDictionaryTable("lw_staff");
		lwDictionary.setDictionaryColum("staff_post");
		lwDictionary.setDictionaryStatus(1);
		List<LwDictionary> postList = lwDictionaryService.ListByTableAndColum(lwDictionary);
		model.addAttribute("postList", postList);
		model.addAttribute("titleName", "员工信息");
		return "/employee/employeeList";
	}
	
	/**
	 * 查询 or 条件查询
	 * @param lwEmployeeSearch
	 * @return
	 */
	@RequestMapping("getData")
	@ResponseBody
	public ResultUtil getData(LwEmployeeSearch lwEmployeeSearch){
		return lwEmployeeService.ListByPage(lwEmployeeSearch);
	}
	
	/**
	 *  进入新增或修改页面
	 * @param model
	 * @param method
	 * @param ekId
	 * @return
	 */
	@RequestMapping(value = "/toInsertOrupdate")
	public String toInsertOrupdate(Model model, String method,Integer ekId) {
		//获取数据字典职业
		LwDictionary lwDictionary = new LwDictionary();
		lwDictionary.setDictionaryTable("lw_staff");
		lwDictionary.setDictionaryColum("staff_post");
		lwDictionary.setDictionaryStatus(1);
		List<LwDictionary> postList = lwDictionaryService.ListByTableAndColum(lwDictionary);
		lwDictionary.setDictionaryColum("staff_sex");
		List<LwDictionary> sexList = lwDictionaryService.ListByTableAndColum(lwDictionary);
		model.addAttribute("postList", postList);
		model.addAttribute("sexList", sexList);
		if (method.equals("ADD")) {
			model.addAttribute("titleName", "添加");
		} else if (method.equals("EDIT")) {
			LwEmployee employee = lwEmployeeService.getById(ekId);
			model.addAttribute("titleName", "编辑");
			model.addAttribute("data", employee);
		}
		return "/employee/employeeEdit";
	}
	
	/**
	 * 执行新增或修改保存
	 * @param request
	 * @param lwEmployee
	 * @return
	 */
	@RequestMapping(value = "/insertOrupdate")
	@ResponseBody
	public Map<String, Object> insertOrupdate(HttpServletRequest request,LwEmployee lwEmployee) {
		Map<String, Object> result = new HashMap<>();
		if (null != lwEmployee.getEkId() && lwEmployee.getEkId() != 0) {// 修改
			lwEmployee.seteModificationTime(new Date());
			if (lwEmployeeService.updateSelective(lwEmployee) > 0) {
				result.put("STATE", "SUCCESS");
			} else {
				result.put("STATE", "FAIL");
			}
		} else {// 新增
			lwEmployee.seteCreationTime(new Date());
			LwAdmin admin = (LwAdmin) SecurityUtils.getSubject().getPrincipal();
			lwEmployee.seteOperator(admin.getId().intValue());
			if(lwEmployeeService.insert(lwEmployee) > 0){
				result.put("STATE", "SUCCESS");
			}else{
				result.put("STATE", "FAIL");
			}
		}
		return result;
	}

	/**
	 * 启用 or 停用
	 * @param lwEmployee
	 * @return
	 */
	@RequestMapping(value = "/alterStatus")
	@ResponseBody
	public Map<String, Object> alterStatus(LwEmployee lwEmployee) {
		Map<String, Object> result = new HashMap<>();
		if (lwEmployee.getEkId() != 0 && null != lwEmployee.geteStatus() && !lwEmployee.geteStatus().equals("")) {
			if (lwEmployeeService.updateSelective(lwEmployee) > 0) {
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
	
	/**
	 * 真删除
	 * @param ekId
	 * @return
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Map<String, Object> delete(Integer ekId) {
		Map<String, Object> result = new HashMap<>();
		if (ekId != null && ekId != 0) {
			if (lwEmployeeService.deleteById(ekId) > 0) {
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
	
}
