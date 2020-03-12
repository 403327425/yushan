/**
 * 
 */
package com.gezi.hdlw.service.sys.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.hdlw.dao.sys.LwMenusMapper;
import com.gezi.hdlw.dao.sys.LwRolesMapper;
import com.gezi.hdlw.dao.sys.LwRolesMenusMapper;
import com.gezi.hdlw.example.sys.LwMenusExample;
import com.gezi.hdlw.service.sys.LwRolesMenusService;
import com.gezi.hdlw.util.MenuAdapterUtil;
import com.gezi.hdlw.vo.sys.LwMenus;
import com.gezi.hdlw.vo.sys.LwRoles;
import com.gezi.hdlw.vo.sys.LwRolesMenusKey;

/**
 * 
 * <p>
 * Title: LwRolesMenusServiceImpl
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * @author lixinrong
 * 
 * @date 2019年3月29日
 * 
 */
@Service
public class LwRolesMenusServiceImpl implements LwRolesMenusService {
	@Resource
	private LwRolesMenusMapper lwRolesMenusMapper;
	@Resource
	private LwRolesMapper lwRolesMapper;
	@Resource
	private LwMenusMapper lwMenusMapper;

	@Override
	public LwRoles getRoleNoTree(LwRolesMenusKey record) {
		return lwRolesMenusMapper.selectByExample(record.getRole().getRoleId());
	}

	@Override
	public LwRoles getRole(LwRolesMenusKey record) {
		LwRoles roles = null;
		if (record.getRole().getRoleId() == 1L) {
			// 超级管理拥有所有权限
			roles = lwRolesMapper.selectByPrimaryKey(record.getRole().getRoleId());
			List<LwMenus> list = lwMenusMapper.selectByExample(new LwMenusExample());
			roles.setLwMenuList(list);
		} else {
			roles = lwRolesMenusMapper.selectByExample(record.getRole().getRoleId());
		}
		List<LwMenus> list = roles.getLwMenuList();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPerms() != null && !"".equals(list.get(i).getPerms())) {
				roles.getPermsSet().add(list.get(i).getPerms());
			}
		}
		roles.setLwMenuList(MenuAdapterUtil.adapterMenuList(list));
		return roles;
	}

}
