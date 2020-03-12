/**
 * 
 */
package com.gezi.hdlw.service.sys.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.hdlw.dao.sys.LwMenusMapper;
import com.gezi.hdlw.dao.sys.LwRolesMenusMapper;
import com.gezi.hdlw.example.sys.LwMenusExample;
import com.gezi.hdlw.service.sys.LwMenusService;
import com.gezi.hdlw.util.MenuAdapterUtil;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwMenus;
import com.gezi.hdlw.vo.sys.LwRoles;
import com.gezi.hdlw.vo.sys.LwRolesMenusKey;
import com.github.pagehelper.PageInfo;

/**
 * 
 * <p>
 * Title: LwMenusServiceImpl
 * </p>
 * 
 * <p>
 * Description:菜单接口实现
 * </p>
 * 
 * @author lixinrong
 * 
 * @date 2019年3月29日
 * 
 */
@Service
public class LwMenusServiceImpl implements LwMenusService {
	@Resource
	private LwMenusMapper lwMenusMapper;
	@Resource
	private LwRolesMenusMapper lwRolesMenusMapper;

	@Override
	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public int deleteByPrimaryKey(Long menuId) {
		LwMenus lwMenus = getByPrimaryKey(menuId);
		if (lwMenus == null) {
			return 0;
		}
		LwMenusExample example = new LwMenusExample();
		LwMenusExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(menuId);
		long count = lwMenusMapper.countByExample(example);
		if(count>0) {
			return 0;
		}
		LwMenus oldMenus = lwRolesMenusMapper.selectByMenuId(menuId);
		if (oldMenus != null) {
			List<LwRolesMenusKey> list = new ArrayList<LwRolesMenusKey>();
			for (LwRoles role : oldMenus.getLwRolesList()) {
				list.add(new LwRolesMenusKey(role.getRoleId(), oldMenus.getMenuId()));
			}
			if (!list.isEmpty()) {
				lwRolesMenusMapper.deleteBatchByPrimaryKey(list);
			}
		}
		return lwMenusMapper.deleteByPrimaryKey(lwMenus.getMenuId());
	}

	@Override
	public ResultUtil listByExample(Integer page, Integer limit, LwMenus record) {
		LwMenusExample example = new LwMenusExample();
		List<LwMenus> list = lwMenusMapper.selectByExample(example);
		PageInfo<LwMenus> pageInfo = new PageInfo<LwMenus>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		resultUtil.setCode(0);
		return resultUtil;
	}

	@Override
	public List<LwMenus> listMenu() {
		return MenuAdapterUtil.adapterMenuList(lwMenusMapper.selectByExample(new LwMenusExample()));
	}

	@Override
	public LwMenus getByPrimaryKey(Long menuId) {
		return lwMenusMapper.selectByPrimaryKey(menuId);
	}

	@Override
	public int saveOrUpdate(LwMenus menu) {
		if (menu.getMenuId() == null) {
			menu.setSpread("false");
			return lwMenusMapper.insertSelective(menu);
		} else {
			return lwMenusMapper.updateByPrimaryKeySelective(menu);
		}
	}

}
