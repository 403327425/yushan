package com.gezi.hdlw.dao.sys;

import com.gezi.hdlw.vo.sys.LwSeqence;

public interface LwSeqenceMapper {
	
	/**
	 * 根据序号类型获取序列对象
	 */
	public LwSeqence getSeqByType(Integer seqType);
	/**
	 * 更新序号对象
	 */
	public void updateSeqByType(LwSeqence seq);
	
	/**
	 * 重置序号
	 */
	public void resetCrtvalue(Integer seqType);
}
