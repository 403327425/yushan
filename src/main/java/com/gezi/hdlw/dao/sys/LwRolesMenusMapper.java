package com.gezi.hdlw.dao.sys;

import java.util.List;

import com.gezi.hdlw.vo.sys.LwMenus;
import com.gezi.hdlw.vo.sys.LwRoles;
import com.gezi.hdlw.vo.sys.LwRolesMenusKey;

public interface LwRolesMenusMapper {

	int deleteByPrimaryKey(LwRolesMenusKey key);

	int insert(LwRolesMenusKey record);

	/** 角色一对多菜单 */
	LwRoles selectByExample(Long roleId);
	
	int insertBatch(List<LwRolesMenusKey> lwRolesMenusKeyList);
	
	int deleteBatchByPrimaryKey(List<LwRolesMenusKey> lwRolesMenusKeyList);
	
	/** 菜单一对多角色 */
	LwMenus selectByMenuId(Long menuId);

}