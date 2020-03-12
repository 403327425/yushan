package com.gezi.hdlw.service.sys;

import java.util.List;

import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwRoles;
/**
 * 

* <p>Title: LwRolesService</p>  

* <p>Description:角色接口 </p>  

* @author lixinrong 

* @date 2019年4月3日
 */
public interface LwRolesService {

	/**
	 * 
	
	 * <p>Title: deleteByPrimaryKey</p>  
	
	 * <p>Description:按主键删除 </p>  
	
	 * @param roleId
	 * @return
	 */
    int deleteByPrimaryKey(Long roleId);

    /**
     * 
    
     * <p>Title: listByExample</p>  
    
     * <p>Description:分页获取列表 </p>  
    
     * @param pageIndex
     * @param pageSize
     * @param record
     * @return
     */
    ResultUtil listByExample(Integer pageIndex, Integer pageSize,LwRoles record);
    
    /**
     * 
    
     * <p>Title: list</p>  
    
     * <p>Description:获取全部角色 </p>  
    
     * @return
     */
    List<LwRoles> list();

    /**
     * 
    
     * <p>Title: saveOrUpdate</p>  
    
     * <p>Description:更新单个 </p>  
    
     * @param role
     * @return
     */
    int saveOrUpdate(LwRoles role);
    
}