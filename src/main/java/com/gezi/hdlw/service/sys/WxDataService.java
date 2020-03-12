package com.gezi.hdlw.service.sys;

import java.util.List;

import com.gezi.hdlw.vo.sys.WxData;
import com.sun.org.apache.bcel.internal.generic.Select;

public interface WxDataService {
	//添加 token
	public int addWxData(WxData wxData);
	//查询是否有该用户了
	public List<WxData> selectWxDataByOpenid(String openid);
	//更新数据
	public int updataWxData(WxData wxData);
}
