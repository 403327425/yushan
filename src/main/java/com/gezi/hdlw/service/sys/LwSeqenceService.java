package com.gezi.hdlw.service.sys;

/**
 * 单号
 * @author Administrator
 *
 */
public interface LwSeqenceService {
	
	/**
	 * 根据序号类型获取单号
	 * @param seqType
	 * @return
	 */
	public String getSeqNoByType(Integer seqType);
	
	/**
	 * 根绝类型重置序号
	 * @param seqType
	 */
	public void resetCrtvalue(Integer seqType);
}
