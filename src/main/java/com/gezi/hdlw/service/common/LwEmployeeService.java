package com.gezi.hdlw.service.common;

import java.util.List;

import com.gezi.hdlw.search.common.LwEmployeeSearch;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.common.LwEmployee;

/**
 * 
 * @version:1.0
 * @Description:员工的接口类
 * @author:李云飞
 * @date: 2019年4月2日上午10:57:00
 */
public interface LwEmployeeService {
	
	/**
	 * 新增
	 * @param lwEmployee
	 * @return
	 */
	public int insert(LwEmployee lwEmployee);
	
	/**
	 * 修改
	 * @param lwEmployee
	 * @return
	 */
	public int updateSelective(LwEmployee lwEmployee);
	
	/**
	 * 删除
	 * @param ekId
	 * @return
	 */
	public int deleteById(Integer ekId);
	
	/**
	 * 查询 or 条件查询
	 * @param lwEmployeeSearch
	 * @return
	 */
	public ResultUtil ListByPage(LwEmployeeSearch lwEmployeeSearch);
	
	/**
	 * 根据id查询
	 * @param ekId
	 * @return
	 */
	public LwEmployee getById(Integer ekId);
	
	/**
	 * 查询所有
	 * @param eStatus
	 * @return
	 */
	public List<LwEmployee> getList(Integer eStatus);

}
