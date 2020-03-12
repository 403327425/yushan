package com.gezi.hdlw.service.sys;

import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwAdmin;

/**
 * 
 * 
 * <p>
 * Title: LwAdminService
 * </p>
 * 
 * <p>
 * Description: 管理员业务
 * </p>
 * 
 * @author lixinrong
 * 
 * @date 2019年4月4日
 */
public interface LwAdminService {

	/**
	 * 
	 * 
	 * <p>
	 * Title: deleteByPrimaryKey
	 * </p>
	 * 
	 * <p>
	 * Description:按主键删除单个
	 * </p>
	 * 
	 * @param adminId
	 * @return
	 */
	int deleteByPrimaryKey(Long adminId);

	/**
	 * 
	 * 
	 * <p>
	 * Title: listOrByWhere
	 * </p>
	 * 
	 * <p>
	 * Description:分页获取列表
	 * </p>
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @param record
	 * @return
	 */
	ResultUtil listOrByWhere(Integer pageIndex, Integer pageSize, LwAdmin record);

	/**
	 * 
	 * 
	 * <p>
	 * Title: getAdminByPrimaryKey
	 * </p>
	 * 
	 * <p>
	 * Description:按主键获取单个
	 * </p>
	 * 
	 * @param adminId
	 * @return
	 */
	LwAdmin getAdminByPrimaryKey(Long adminId);

	/**
	 * 
	 * 
	 * <p>
	 * Title: getAdminByWhere
	 * </p>
	 * 
	 * <p>
	 * Description:按唯一条件获取单个
	 * </p>
	 * 
	 * @param record
	 * @return
	 */
	LwAdmin getAdminByWhere(LwAdmin record);

	/**
	 * 
	 * 
	 * <p>
	 * Title: saveOrUpdate
	 * </p>
	 * 
	 * <p>
	 * Description:新增或更新
	 * </p>
	 * 
	 * @param admin
	 * @param fkId
	 * @param skId
	 * @return
	 */
	int saveOrUpdate(LwAdmin admin);

}