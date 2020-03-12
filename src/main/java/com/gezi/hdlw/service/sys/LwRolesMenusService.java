package com.gezi.hdlw.service.sys;

import com.gezi.hdlw.vo.sys.LwRoles;
import com.gezi.hdlw.vo.sys.LwRolesMenusKey;

/**
 * 
 * 
 * <p>
 * Title: LwRolesMenusService
 * </p>
 * 
 * <p>
 * Description: 角色连接菜单中间表
 * </p>
 * 
 * @author lixinrong
 * 
 * @date 2019年3月29日
 */
public interface LwRolesMenusService {

	/**
	 * 带树状结构菜单
	 * 
	 * @param record
	 * @return
	 */
	LwRoles getRole(LwRolesMenusKey record);

	/**
	 * 带非树状结构菜单
	 * 
	 * @param record
	 * @return
	 */
	LwRoles getRoleNoTree(LwRolesMenusKey record);

}