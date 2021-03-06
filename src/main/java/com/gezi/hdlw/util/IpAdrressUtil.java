package com.gezi.hdlw.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;



@Service
public class IpAdrressUtil {
	public  String getIpAdrress(HttpServletRequest request) {
		  String Xip = request.getHeader("X-Real-IP");
		  String XFor = request.getHeader("X-Forwarded-For");
		  if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
		   int index = XFor.indexOf(",");
		   if(index != -1){
		    return XFor.substring(0,index);
		   }else{
		    return XFor;
		   }
		  }
		  XFor = Xip;
		  if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
		   return XFor;
		  }
		  if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
		   XFor = request.getHeader("Proxy-Client-IP");
		  }
		  if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
		   XFor = request.getHeader("WL-Proxy-Client-IP");
		  }
		  if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
		   XFor = request.getHeader("HTTP_CLIENT_IP");
		  }
		  if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
		   XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
		  }
		  if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
		   XFor = request.getRemoteAddr();
		  }
		  return XFor;
		 }
}
