package com.gezi.GS.util;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * 通证JSON数据帮助类
 * @Author weixiong
 * @Time 2019年12月17日 下午3:53:07
 * @Version 1.0
 * <p>Description:</p>
 */
@Service
public class DataHelpUtil {
	public static void addData(String unionid,int corn,String des){
		String url="https://ystzapi.light-umbrella.com/gezi-wx-api/wxapi/user/urcrSumOrSub";
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("corn",corn);
		jsonObject.put("des",des);
		jsonObject.put("unionid", unionid);
		String Data=jsonObject.toJSONString();
		AesUtils aesUtils=new AesUtils();
		try {
			Data=aesUtils.encode(Data,HttpConstant.APP_KEY, AesUtils.APP_IV, AesUtils.PADDING);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jsonObject2=new JSONObject();
		jsonObject2.put("data", Data);
		System.out.println(jsonObject2.toJSONString());
		ToInterfaceUtil toInterfaceUtil=new ToInterfaceUtil();
		toInterfaceUtil.interfaceUtil(url, jsonObject2.toJSONString());
	}
	public boolean getFlag(String interfaceId,String unionid,Date date){
		String url="https://xx.light-umbrella.com/InterfaceManage/InterfaceLibrary/addInterFaceRecordEvent";
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("interfaceId", interfaceId);
		jsonObject.put("userName", unionid);
		jsonObject.put("createTime",date.getTime());
		ToInterfaceUtil toInterfaceUtil=new ToInterfaceUtil();
		String data=toInterfaceUtil.interfaceUtil(url, jsonObject.toJSONString());
		if(data.equals("true")){
			return true;
		}else if(data.equals("false")){
			return false;
		}else{
			return false;
		}
	}
	public static void main(String[] args){
		/*addData("oeRRy59XZzOY-6Jg-OOfxszBj9tY",5,"生成简历");*/
	}
}
