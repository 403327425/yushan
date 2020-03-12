/**
 * 
 */
package com.gezi.hdlw.service.sys.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.hdlw.dao.sys.LwAdminMapper;
import com.gezi.hdlw.dao.sys.LwUserBelongsMapper;
import com.gezi.hdlw.example.sys.LwAdminExample;
import com.gezi.hdlw.example.sys.LwUserBelongsExample;
import com.gezi.hdlw.example.sys.LwUserBelongsExample.Criteria;
import com.gezi.hdlw.service.sys.LwAdminService;
import com.gezi.hdlw.util.MyUtil;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwAdmin;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * <p>
 * Title: LwAdminServiceImpl
 * </p>
 * 
 * <p>
 * Description:超级管理员不允许查询修改删除
 * </p>
 * 
 * @author lixinrong
 * 
 * @date 2019年3月29日
 * 
 */
@Service
public class LwAdminServiceImpl implements LwAdminService {

	@Resource
	private LwAdminMapper lwAdminMapper;

	@Resource
	protected LwUserBelongsMapper lwUserBelongsMapper;

	@Override
	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public int deleteByPrimaryKey(Long adminId) {
		if (adminId == 1L) {
			return 0;
		}
		LwAdmin lwAdmin = getAdminByPrimaryKey(adminId);
		if (lwAdmin == null) {
			return 0;
		}
		LwUserBelongsExample example = new LwUserBelongsExample();
		Criteria criteria = example.createCriteria();
		criteria.andAkIdEqualTo(adminId.intValue());
		lwUserBelongsMapper.deleteByExample(example);
		return lwAdminMapper.deleteByPrimaryKey(adminId);
	}

	@Override
	public ResultUtil listOrByWhere(Integer pageIndex, Integer pageSize, LwAdmin record) {
		PageHelper.startPage(pageIndex, pageSize);
		LwAdminExample example = new LwAdminExample();
		LwAdminExample.Criteria criteria = example.createCriteria();
		// 不显示超级管理员
		criteria.andIdNotEqualTo(1L);
		// 不显示自己
		criteria.andIdNotEqualTo(record.getId());
		List<LwAdmin> list = lwAdminMapper.customizationSelectByExample(example);
		PageInfo<LwAdmin> pageInfo = new PageInfo<LwAdmin>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		resultUtil.setCode(0);
		return resultUtil;
	}

	@Override
	public LwAdmin getAdminByPrimaryKey(Long adminId) {
		if (adminId == 1L) {
			return null;
		}
		return lwAdminMapper.customizationSelectByPrimaryKey(adminId);
	}

	@Override
	public LwAdmin getAdminByWhere(LwAdmin record) {
		LwAdminExample example = new LwAdminExample();
		LwAdminExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(record.getUsername());
		List<LwAdmin> list = lwAdminMapper.customizationSelectByExample(example);
		if (list.isEmpty() || list.size() > 1) {
			return null;
		}
		return list.get(0);
	}

	@Override
	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public int saveOrUpdate(LwAdmin admin) {
		if (admin.getId() == null) {
			admin.setFullname(MyUtil.getRandomNickName());
			return lwAdminMapper.insertSelective(admin);
		} else {
			if (admin.getRoleId() == 1L) {
				return 0;
			}
			if (admin.getFullname() == null) {
				admin.setFullname(MyUtil.getRandomNickName());
			}
			return lwAdminMapper.updateByPrimaryKeySelective(admin);
		}
	}

}
