package com.gezi.GS.util;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	public String getOpenidByCookie(HttpServletRequest request,HttpServletResponse response){
		try{
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
	    Cookie[] cookies=request.getCookies();
	    String openid="";
	    if(cookies!=null){
	    	for (Cookie cookie : cookies) {
		    	System.out.println(cookie.getName()+"====>"+cookie.getValue());
		    	if(cookie.getName().equals("openid")){
		    		openid=cookie.getValue();
		    		System.out.println("我们来看看cookie上的openid："+openid);
		    		
		    	}
		    }
	    }
	    return openid;
	}
}
