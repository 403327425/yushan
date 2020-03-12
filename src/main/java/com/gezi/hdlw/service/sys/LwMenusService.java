package com.gezi.hdlw.service.sys;

import java.util.List;

import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwMenus;
/**
 * 

* <p>Title: LwMenusService</p>  

* <p>Description:菜单接口 </p>  

* @author lixinrong 

* @date 2019年3月29
 */
public interface LwMenusService {

	/**
	 * 
	
	 * <p>Title: deleteByPrimaryKey</p>  
	
	 * <p>Description:按主键删除 </p>  
	
	 * @param menuId
	 * @return
	 */
	int deleteByPrimaryKey(Long menuId);

	/**
	 * 
	
	 * <p>Title: listByExample</p>  
	
	 * <p>Description:获取全部菜单 </p>  
	
	 * @param page
	 * @param limit
	 * @param record
	 * @return
	 */
	ResultUtil listByExample(Integer page,Integer limit,LwMenus record);
	/**
	 * 查询需要权限的菜单
	 * @return List
	 */
	List<LwMenus> listMenu();

	/**
	 * 
	
	 * <p>Title: getByPrimaryKey</p>  
	
	 * <p>Description:按主键获取单个菜单 </p>  
	
	 * @param menuId
	 * @return
	 */
	LwMenus getByPrimaryKey(Long menuId);

	/**
	 * 
	
	 * <p>Title: saveOrUpdate</p>  
	
	 * <p>Description:新建或更新菜单 </p>  
	
	 * @param menu
	 * @return
	 */
	int saveOrUpdate(LwMenus menu);

}