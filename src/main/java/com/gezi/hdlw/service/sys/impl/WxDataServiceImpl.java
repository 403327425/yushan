package com.gezi.hdlw.service.sys.impl;



import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezi.hdlw.example.sys.WxDataExample;
import com.gezi.hdlw.service.AbstraceService;
import com.gezi.hdlw.service.sys.WxDataService;
import com.gezi.hdlw.vo.sys.WxData;
@Service
@Transactional
public class WxDataServiceImpl extends AbstraceService implements WxDataService {

	@Override
	public int addWxData(WxData wxData) {
		// TODO Auto-generated method stub
		return wxDataMapper.insert(wxData);
	}

	@Override
	public List<WxData> selectWxDataByOpenid(String openid){
		// TODO Auto-generated method stub
		WxDataExample example =new WxDataExample();
		WxDataExample.Criteria criteria=example.createCriteria();
		criteria.andOpenidEqualTo(openid);
		return wxDataMapper.selectByExample(example);
	}

	@Override
	public int updataWxData(WxData wxData) {
		// TODO Auto-generated method stub
		WxDataExample example =new WxDataExample();
		WxDataExample.Criteria criteria=example.createCriteria();
		criteria.andOpenidEqualTo(wxData.getOpenid());
		return wxDataMapper.updateByExample(wxData, example);
	}
	
	
	

}
