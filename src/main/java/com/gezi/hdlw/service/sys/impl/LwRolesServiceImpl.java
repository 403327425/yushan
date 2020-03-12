/**
 * 
 */
package com.gezi.hdlw.service.sys.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.hdlw.dao.sys.LwRolesMapper;
import com.gezi.hdlw.dao.sys.LwRolesMenusMapper;
import com.gezi.hdlw.example.sys.LwRolesExample;
import com.gezi.hdlw.service.sys.LwRolesService;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwMenus;
import com.gezi.hdlw.vo.sys.LwRoles;
import com.gezi.hdlw.vo.sys.LwRolesMenusKey;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * <p>
 * Title: LwRolesServiceImpl
 * </p>
 * 
 * <p>
 * Description:超级管理员角色不允许查询修改删除
 * </p>
 * 
 * @author lixinrong
 * 
 * @date 2019年3月29日
 * 
 */
@Service
public class LwRolesServiceImpl implements LwRolesService {
	@Resource
	private LwRolesMapper lwRolesMapper;
	@Resource
	private LwRolesMenusMapper lwRolesMenusMapper;

	@Override
	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public int deleteByPrimaryKey(Long roleId) {
		if (roleId == 1L) {
			return 0;
		}
		LwRoles roles = lwRolesMapper.selectByPrimaryKey(roleId);
		if (roles == null) {
			return 0;
		}
		List<LwRolesMenusKey> rolesMenusKeys = adapterRolesMenusKeys(roleId);
		if (!rolesMenusKeys.isEmpty()) {
			lwRolesMenusMapper.deleteBatchByPrimaryKey(rolesMenusKeys);
		}
		return lwRolesMapper.deleteByPrimaryKey(roleId);
	}

	private int insertSelective(LwRoles record) {
		int i = lwRolesMapper.insertSelective(record);
		List<LwRolesMenusKey> list = new ArrayList<LwRolesMenusKey>();
		for (LwMenus menu : record.getLwMenuList()) {
			list.add(new LwRolesMenusKey(record.getRoleId(), menu.getMenuId()));
		}
		lwRolesMenusMapper.insertBatch(list);
		return i;
	}

	@Override
	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public int saveOrUpdate(LwRoles role) {
		if (role.getRoleId() == null) {
			return insertSelective(role);
		} else {
			List<LwRolesMenusKey> rolesMenusKeys = adapterRolesMenusKeys(role.getRoleId());
			if (!rolesMenusKeys.isEmpty()) {
				lwRolesMenusMapper.deleteBatchByPrimaryKey(rolesMenusKeys);
			}
			List<LwMenus> menuList = role.getLwMenuList();
			if (!menuList.isEmpty()) {
				List<LwRolesMenusKey> list = new ArrayList<LwRolesMenusKey>();
				for (LwMenus menu : menuList) {
					list.add(new LwRolesMenusKey(role.getRoleId(), menu.getMenuId()));
				}
				lwRolesMenusMapper.insertBatch(list);
			}
			return lwRolesMapper.updateByPrimaryKeySelective(role);
		}
	}

	@Override
	public ResultUtil listByExample(Integer pageIndex, Integer pageSize, LwRoles record) {
		PageHelper.startPage(pageIndex, pageSize);
		LwRolesExample example = new LwRolesExample();
		LwRolesExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdNotEqualTo(1L);
		List<LwRoles> list = lwRolesMapper.selectByExample(example);
		PageInfo<LwRoles> pageInfo = new PageInfo<LwRoles>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		resultUtil.setCode(0);
		return resultUtil;
	}

	@Override
	public List<LwRoles> list() {
		LwRolesExample example = new LwRolesExample();
		LwRolesExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdNotEqualTo(1L);
		return lwRolesMapper.selectByExample(example);
	}

	private List<LwRolesMenusKey> adapterRolesMenusKeys(Long roleId) {
		List<LwRolesMenusKey> list = new ArrayList<LwRolesMenusKey>();
		LwRoles roles = lwRolesMenusMapper.selectByExample(roleId);
		if (roles != null) {
			List<LwMenus> menuList = roles.getLwMenuList();
			for (LwMenus menu : menuList) {
				list.add(new LwRolesMenusKey(roleId, menu.getMenuId()));
			}
		}
		return list;
	}

}
