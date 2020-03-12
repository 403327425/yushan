package com.gezi.hdlw.service.sys;

import java.util.List;

import com.gezi.hdlw.search.sys.LwDictionaryTypeSearch;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwDictionaryType;

/**
 * 
 * @version:1.0
 * @Description:字典类型的接口类
 * @author:李云飞
 * @date: 2019年3月29日上午11:46:32
 */
public interface LwDictionaryTypeService {

	/**
	 * 新增
	 * @param lwDictionaryType
	 * @return
	 */
	public int insert(LwDictionaryType lwDictionaryType);
	
	/**
	 * 修改
	 * @param lwDictionaryType
	 * @return
	 */
	public int updateSelective(LwDictionaryType lwDictionaryType);
	
	/**
	 * 查询所有表（只查询表类型的）
	 * @return
	 */
	public List<LwDictionaryType> ListByTable();
	
	/**
	 * 查询 or 条件查询
	 * @param lwDictionaryTypeSearch
	 * @return
	 */
	public ResultUtil ListByPage(LwDictionaryTypeSearch lwDictionaryTypeSearch);
	
	/**
	 * 根据id查询
	 * @param dtkId
	 * @return
	 */
	public LwDictionaryType getById(Integer dtkId);

	/**
	 * 根据父ID查询
	 * @param dtParentId
	 * @return
	 */
  	public List<LwDictionaryType> ListByParentId(Integer dtParentId);
	
}
