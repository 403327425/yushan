package com.gezi.hdlw.service.sys;

import java.util.List;

import com.gezi.hdlw.search.sys.LwDictionarySearch;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwDictionary;

/**
 * 
 * @version:1.0
 * @Description:字典的接口类
 * @author:李云飞
 * @date: 2019年3月29日上午11:46:32
 */
public interface LwDictionaryService {
	
	/**
	 * 新增
	 * @param lwDictionary
	 * @return
	 */
	public int insert(LwDictionary lwDictionary);
	
	/**
	 * 修改
	 * @param lwDictionary
	 * @return
	 */
	public int updateSelective(LwDictionary lwDictionary);
	
	/**
	 * 根据id查询
	 * @param dkId
	 * @return
	 */
	public LwDictionary getById(Integer dkId);
	
	/**
	 * 查询 or 条件查询
	 * @param lwDictionarySearch
	 * @return
	 */
	public ResultUtil ListByPage(LwDictionarySearch lwDictionarySearch);
	
	/**
	 * 根据字典表名称和字段名称查询字典
	 * @param lwDictionary
	 * @return
	 */
	public List<LwDictionary> ListByTableAndColum(LwDictionary lwDictionary);

}
