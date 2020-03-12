package com.gezi.hdlw.controller.sys;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.utils.StringKeyDirtyFlagMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gezi.GS.service.sys.UserListService;
import com.gezi.GS.vo.sys.UserList;
import com.gezi.hdlw.service.sys.LwActivityService;
import com.gezi.hdlw.service.sys.LwCandidateService;
import com.gezi.hdlw.service.sys.LwVoterService;
import com.gezi.hdlw.service.sys.WxDataService;
import com.gezi.hdlw.util.CheckoutUtil;
import com.gezi.hdlw.util.JsSignUtil;
import com.gezi.hdlw.util.MessageUtil;
import com.gezi.hdlw.util.PdfReaderUtil;
import com.gezi.hdlw.util.wxHelpUtil;
import com.gezi.hdlw.vo.sys.Article;
import com.gezi.hdlw.vo.sys.Image;
import com.gezi.hdlw.vo.sys.ImageMessage;
import com.gezi.hdlw.vo.sys.LwActivity;
import com.gezi.hdlw.vo.sys.LwCandidate;
import com.gezi.hdlw.vo.sys.NewsMessage;
import com.gezi.hdlw.vo.sys.TextMessage;
import com.gezi.hdlw.vo.sys.WxData;
import com.mysql.fabric.xmlrpc.base.Array;
import com.mysql.fabric.xmlrpc.base.Data;

@Controller
@RequestMapping("/wxInterface")
public class wxController {
	@Resource
	public wxHelpUtil wxHelpUtil;
	@Resource 
	public PdfReaderUtil PdfReaderUtil;
	@Resource
	public WxDataService wxDataService;
	@Resource 
	public JsSignUtil JsSignUtil;
	@Resource
	public LwCandidateService lwCandidateService;
	@Resource
	public LwActivityService lwActivityService;
	@Resource
	public LwVoterService lwVoterService;
	
	@Resource
	public UserListService userListService;
	
/*	@RequestMapping("/tokenCheck")
	public void tokenCheck(Model model, HttpServletRequest request,HttpServletResponse response)throws IOException{
		System.out.println("验证");
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        PrintWriter print;
        if (isGet) {
            // 微信加密签名
            String signature = request.getParameter("signature");
            // 时间戳
            String timestamp = request.getParameter("timestamp");
            // 随机数
            String nonce = request.getParameter("nonce");
            // 随机字符串
            String echostr = request.getParameter("echostr");
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
            if (signature != null && CheckoutUtil.checkSignature(signature, timestamp, nonce)) {
                try {
                    print = response.getWriter();
                    print.write(echostr);
                    print.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	@RequestMapping("/wxCode")
	@ResponseBody
	public String wxCode(String temp){
		String url =wxHelpUtil.wxGetCode(temp);
		return JSON.toJSONString(url);
	}*/
	
	@RequestMapping("/tokenCheck")
	@ResponseBody
	public String getMsg(HttpServletRequest request){
		
		
		accessTokenUpdate();
		
		
		String respMessage = null;
        try {

            // xml请求解析
            Map<String, String> requestMap = MessageUtil.xmlToMap(request);

            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");
            // 消息内容
            String content = requestMap.get("Content");
            
            /*LOGGER.info("FromUserName is:" + fromUserName + ", ToUserName is:" + toUserName + ", MsgType is:" + msgType);*/

            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                //这里根据关键字执行相应的逻辑，只有你想不到的，没有做不到的
                if(lwCandidateService.selectBySelectId(content)){
                    LwCandidate lwCandidate=lwCandidateService.infoBySelectId(content);
                    LwActivity lwActivity=lwActivityService.selectAllById(lwCandidate.getActivityId());
                    Date date=new Date();
                    if(date.after(lwActivity.getStartTime2())&&date.before(lwActivity.getEndTime2())){
                    	NewsMessage newsMessage=new NewsMessage();
                    	newsMessage.setToUserName(fromUserName);
                    	newsMessage.setFromUserName(toUserName);
                    	newsMessage.setCreateTime(new Date().getTime() + "");
                    	newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                    	newsMessage.setArticleCount("1");
                    	Article article=new Article();
                        article.setDescription(lwCandidate.getCandidateName()+"，"+lwVoterService.systemVote(lwActivity.getActivityId(), lwCandidate.getCandidateId(), lwActivity.getVoteMode(), lwActivity.getLimitMode(), lwActivity.getLimitNumber(), fromUserName)); //图文消息的描述
                        article.setPicUrl("http://xx.light-umbrella.com/votePro/upload/logo3.png"); //图文消息图片地址
                        article.setTitle(lwActivity.getActivityName());  //图文消息标题
                        article.setUrl("http://xx.light-umbrella.com/votePro/vote/voteIndex?activityId="+lwActivity.getActivityId());  //图文url链接
                        List<Article> list=new ArrayList<Article>();
                        list.add(article); 
                        newsMessage.setArticles(list);
                        respMessage=MessageUtil.newsMessageToXml(newsMessage);
                    	
                    	//自动回复
                       /* TextMessage text = new TextMessage();
                        text.setContent("the text is" + content);
                        text.setContent(lwVoterService.systemVote(lwActivity.getActivityId(), lwCandidate.getCandidateId(), lwActivity.getVoteMode(), lwActivity.getLimitMode(), lwActivity.getLimitNumber(), fromUserName));
                        text.setToUserName(fromUserName);
                        text.setFromUserName(toUserName);
                        text.setCreateTime(new Date().getTime() + "");
                        text.setMsgType(msgType);
                        respMessage = MessageUtil.textMessageToXml(text);*/
                    }else{
                    	//自动回复
                        TextMessage text = new TextMessage();
                        /*text.setContent("the text is" + content);*/
                        text.setContent("不在助力时间内喔");
                        text.setToUserName(fromUserName);
                        text.setFromUserName(toUserName);
                        text.setCreateTime(new Date().getTime() + "");
                        text.setMsgType(msgType);
                        respMessage = MessageUtil.textMessageToXml(text);
                    }
                }else if(content.equals("资料")){
                    
                	
/*                	TextMessage text = new TextMessage();
                    text.setContent("Hello，不遗憾青年~\n"
                    		+ "①为了让更多同学一起进步，请转发推文 <a href=\'https://mp.weixin.qq.com/s/rQivs6YM0-GGQl-29VIbTQ'>不留遗憾，2030G资料包够你玩转整个大学</a> 到朋友圈（不能分组），或2个200人以上的同学群。\n"
                    		+ "②需要收集8个赞，并将截图发送到【公众号后台】，24小时内将2030G资料包发送给你！\n"
                    		+ "③【开学福利】给不遗憾青年们推荐优质学车小助手，扫码加好友备注“松山湖学车”可免费咨询松山湖片区学车价格~");
                    text.setToUserName(fromUserName);
                    text.setFromUserName(toUserName);
                    text.setCreateTime(new Date().getTime() + "");
                    text.setMsgType(msgType);
                    respMessage = MessageUtil.textMessageToXml(text);*/
                    
                    
                    
                    String accessToken=wxDataService.selectWxDataByOpenid("system").get(0).getAccessToken();
                    String imagetext="AGYesuj92cBvSryGwg-u9JDvyt80QGP5rDNqEK3jVwI";
                    String texttext="Hello，不遗憾青年~\n"
                    		+ "①为了让更多同学一起进步，请转发推文 <a href=\'https://mp.weixin.qq.com/s/rQivs6YM0-GGQl-29VIbTQ'>不留遗憾，2030G资料包够你玩转整个大学</a> 到朋友圈（不能分组），或2个200人以上的同学群。\n"
                    		+ "②需要收集8个赞，并将截图发送到【公众号后台】，24小时内将2030G资料包发送给你！\n"
                    		+ "③【开学福利】给不遗憾青年们推荐优质学车小助手，扫码加好友备注“松山湖学车”可免费咨询松山湖片区学车价格~";
                    wxHelpUtil.sendTextCustomMsg(fromUserName, texttext, accessToken);
                    
                    wxHelpUtil.sendImageCustomMsg(fromUserName, imagetext, accessToken);
                	
                	
                	/*NewsMessage newsMessage=new NewsMessage();
                	newsMessage.setToUserName(fromUserName);
                	newsMessage.setFromUserName(toUserName);
                	newsMessage.setCreateTime(new Date().getTime() + "");
                	newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                	newsMessage.setArticleCount("1");
                	
                	
                	
                	
                    Article article=new Article();
                    article.setDescription("Hello，不遗憾青年~"
                    		+ "①为了让更多同学一起进步，请转发推文 不留遗憾，2030G资料包够你玩转整个大学 到朋友圈（不能分组），或2个200人以上的同学群。"
                    		+ "②需要收集8个赞，并将截图发送到【公众号后台】，24小时内将2030G资料包发送给你！"
                    		+ "③【开学福利】给不遗憾青年们推荐优质学车小助手，扫码加好友备注“松山湖学车”可免费咨询松山湖片区学车价格~"); //图文消息的描述
                    article.setPicUrl("https://image.135editor.com/files/users/224/2247683/201909/r6R4ZgND_Bw5m.png"); //图文消息图片地址
                    article.setTitle("资料");  //图文消息标题
                    article.setUrl("https://mp.weixin.qq.com/s/rQivs6YM0-GGQl-29VIbTQ");  //图文url链接
                    List<Article> list=new ArrayList<Article>();
                    list.add(article); 
                    
                    newsMessage.setArticles(list);
                    respMessage=MessageUtil.newsMessageToXml(newsMessage);*/
                    
                }else if(content.equals("群聊")){
                	NewsMessage newsMessage=new NewsMessage();
                	newsMessage.setToUserName(fromUserName);
                	newsMessage.setFromUserName(toUserName);
                	newsMessage.setCreateTime(new Date().getTime() + "");
                	newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                	newsMessage.setArticleCount("1");
                	
                	
                	
                	
                    Article article=new Article();
                    article.setDescription("快点进来!\n里面都是老好人。"); //图文消息的描述
                    article.setPicUrl("http://xx.light-umbrella.com/votePro/upload/logo3.png"); //图文消息图片地址
                    article.setTitle("聊天群");  //图文消息标题
                    article.setUrl("http://xx.light-umbrella.com/qrCode/vote/showQRCodeWeb?from=groupmessage&isappinstalled=0");  //图文url链接
                    List<Article> list=new ArrayList<Article>();
                    list.add(article); 
                    
                    newsMessage.setArticles(list);
                    respMessage=MessageUtil.newsMessageToXml(newsMessage);
                }else if(content.equals("不遗憾大学")){
                	NewsMessage newsMessage=new NewsMessage();
                	newsMessage.setToUserName(fromUserName);
                	newsMessage.setFromUserName(toUserName);
                	newsMessage.setCreateTime(new Date().getTime() + "");
                	newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                	newsMessage.setArticleCount("1");
                	
                	
                	
                	
                    Article article=new Article();
                    article.setDescription("我能干嘛？\n进来看看就知道了"); //图文消息的描述
                    article.setPicUrl("http://xx.light-umbrella.com/votePro/upload/logo3.png"); //图文消息图片地址
                    article.setTitle("大学指南");  //图文消息标题
                    article.setUrl("https://mp.weixin.qq.com/s/anE5n91jwHpTyrNASC6Zmg");  //图文url链接
                    List<Article> list=new ArrayList<Article>();
                    list.add(article); 
                    
                    newsMessage.setArticles(list);
                    respMessage=MessageUtil.newsMessageToXml(newsMessage);
                }else if(content.equals("周末")){
                	NewsMessage newsMessage=new NewsMessage();
                	newsMessage.setToUserName(fromUserName);
                	newsMessage.setFromUserName(toUserName);
                	newsMessage.setCreateTime(new Date().getTime() + "");
                	newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                	newsMessage.setArticleCount("1");
                	
                	
                	
                	
                    Article article=new Article();
                    article.setDescription("进入周末研究院，我们带你玩"); //图文消息的描述
                    article.setPicUrl("http://xx.light-umbrella.com/votePro/upload/logo3.png"); //图文消息图片地址
                    article.setTitle("周末研究院");  //图文消息标题
                    article.setUrl("https://cd-nt.lianlianlvyou.com/?a=38191140&v=200&i=wx1e0ee2a622a6b976&s=oZoyN0ubxBEon6x3tdcti4uJ8dsU&state=1#/zhoubian");  //图文url链接
                    List<Article> list=new ArrayList<Article>();
                    list.add(article); 
                    
                    newsMessage.setArticles(list);
                    respMessage=MessageUtil.newsMessageToXml(newsMessage);
                }
                else if(content.equals("学车")){
                	ImageMessage imageMessage=new ImageMessage();
                	imageMessage.setToUserName(fromUserName);
                	imageMessage.setFromUserName(toUserName);
                	imageMessage.setCreateTime(new Date().getTime() + "");
                	imageMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_IMAGE);

                    Image image =new Image();
                    /*image.setMediaId("i8Z6DcvA3MNgUwOhN1pDOqF05jZ6Nxyf8B7cp-_mlC-z2El2ftNqSes_QzjfjpU8");*/
                    image.setMediaId("AGYesuj92cBvSryGwg-u9JDvyt80QGP5rDNqEK3jVwI");
                    imageMessage.setImage(image);
                    respMessage=MessageUtil.imageMessageToXml(imageMessage);
                    
                    
                }
                else{
                	//自动回复
                    TextMessage text = new TextMessage();
                    text.setContent("亲，我们一直都在喔！");
                    text.setToUserName(fromUserName);
                    text.setFromUserName(toUserName);
                    text.setCreateTime(new Date().getTime() + "");
                    text.setMsgType(msgType);
                    respMessage = MessageUtil.textMessageToXml(text);
                }
                
                
               
            } 
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                String eventType = requestMap.get("Event");// 事件类型
                // 订阅
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    
                    TextMessage text = new TextMessage();
                    text.setContent("你好，不遗憾青年，\n欢迎关注“不遗憾大学”\n"
                    		+ "陪你度过大学岁月！\n"
                    		+ "不遗憾大学是一所致力成为你第一所线上大学\n"
                    		+ "关注不遗憾大学，让你大学生活不遗憾~\n"
                    		+ "【1】入学信息，点击菜单栏；\n"
                    		+ "【2】回复“资料”--领取2030G学习资料；\n"
                    		+ "【3】回复“群聊”--进入各种在校群聊；\n"
                    		+ "【4】回复“不遗憾大学”--了解我们；\n"
                    		+ "【5】回复“学车”--3780，全市低价任性学\n"
                    		+ "【6】回复“周末”--进入周末研究院，我们带你玩\n");
                    text.setToUserName(fromUserName);
                    text.setFromUserName(toUserName);
                    text.setCreateTime(new Date().getTime() + "");
                    text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                    
                    respMessage = MessageUtil.textMessageToXml(text);
                } 
                // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {// 取消订阅
                    
                    
                } 
                // 自定义菜单点击事件
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    String eventKey = requestMap.get("EventKey");// 事件KEY值，与创建自定义菜单时指定的KEY值对应
                    if (eventKey.equals("")) {
                        TextMessage text = new TextMessage();
                        text.setContent("");
                        text.setToUserName(fromUserName);
                        text.setFromUserName(toUserName);
                        text.setCreateTime(new Date().getTime() + "");
                        text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                        
                        respMessage = MessageUtil.textMessageToXml(text);
                    }
                }
            }
        }
        catch (Exception e) {
            /*Logger.error("error......")*/
        }
        return respMessage;
		
	}
	
	
	
	//获取openid
	@RequestMapping("/getOpenId")
	public String getOpenId(String code,String state,HttpServletRequest request,HttpServletResponse response){
		try{
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		Map<String, String> map=wxHelpUtil.wxGetOpenId(code);
		String openid=map.get("openid");
		if(wxDataService.selectWxDataByOpenid(openid).size()<1){
			Date nowDate = new Date();
			WxData wxData=new WxData();
			
			wxData.setAccessTokenTime(nowDate);
			wxData.setJsapiTicketTime(nowDate);
			wxData.setAccessToken(map.get("access_token"));
			wxData.setJsapiTicket(map.get("refresh_token"));
			wxData.setOpenid(map.get("openid"));
			wxDataService.addWxData(wxData);
		}else{
			List<WxData> list =wxDataService.selectWxDataByOpenid(openid);
			
			Date nowDate = new Date();
			WxData wxData=new WxData();
			wxData.setId(list.get(0).getId());
			wxData.setAccessTokenTime(nowDate);
			wxData.setJsapiTicketTime(nowDate);
			wxData.setAccessToken(map.get("access_token"));
			wxData.setJsapiTicket(map.get("refresh_token"));
			wxData.setOpenid(map.get("openid"));
			wxDataService.updataWxData(wxData);
			/*List<WxData> list =wxDataService.selectWxDataByOpenid(openid);
			Date date2 =list.get(0).getJsapiTicketTime();
	        Calendar cal2 = Calendar.getInstance();   
	        cal2.setTime(date2);   
	        cal2.add(Calendar.DATE, 30);//30天
	        date2 = cal2.getTime();
	        Date date3=new Date();
	        if(date2.after(date3)){
	    		
	    	}else{
	    		//重新获取refresh_token
	    		
	    		
	    		Date nowDate = new Date();
				WxData wxData=new WxData();
				wxData.setAccessTokenTime(nowDate);
				wxData.setJsapiTicketTime(nowDate);
				wxData.setAccessToken(map.get("access_token"));
				wxData.setJsapiTicket(map.get("refresh_token"));
				wxData.setOpenid(map.get("openid"));
				
				wxDataService.updataWxData(wxData);
	    	}*/
		}
		
        
        
        
		
		String name="openid";
		String value=openid;
		Cookie cookie = new Cookie(name.trim(), value.trim());
        cookie.setMaxAge(60 * 60 * 24);// 设置为30min
        cookie.setPath("/");
        System.out.println("已添加===============");
		response.addCookie(cookie);
		return "redirect:/personGrowth/newMainWeb";
	}
	
	//获取个人信息
	@RequestMapping("/getMeWxData")
	@ResponseBody
	public String getMeWxData(String openid){
		System.out.print("888888888888888");
		List<WxData> list =wxDataService.selectWxDataByOpenid(openid);
		Date date1 =list.get(0).getAccessTokenTime();
		Date date2 =list.get(0).getJsapiTicketTime();
        Calendar cal = Calendar.getInstance();   
        cal.setTime(date1);   
        cal.add(Calendar.HOUR, 2);// 2小时
        date1 = cal.getTime();
        
        Calendar cal2 = Calendar.getInstance();   
        cal2.setTime(date2);   
        cal2.add(Calendar.DATE, 30);//30天
        date2 = cal2.getTime();
        
        Date date3=new Date();
        System.out.print("66666666666");
        Map<String, String> map=new HashMap<String, String>();
        if(date1.after(date3)){
        	map=wxHelpUtil.getInfo(list.get(0).getAccessToken(), openid);
        	 System.out.print("888888888888888");
        	 map.put("msg2", "正在获取");
        }else{
        	if(date2.after(date3)){
        		//重新获取access_token
        		list.get(0).setAccessToken(wxHelpUtil.wxGetAccessTokenAgain(list.get(0).getJsapiTicket()));
            	Date date4=new Date();
            	list.get(0).setAccessTokenTime(date4);
            	wxDataService.updataWxData(list.get(0));
            	map=wxHelpUtil.getInfo(list.get(0).getAccessToken(), openid);
            	map.put("msg", "重新获取access_token");
        	}else{
        		//重新获取refresh_token
        		map.put("msg", "重新授权");
        	}
        }
        if(map.get("headimgurl")!=null&&map.get("headimgurl")!=""){
        
        System.out.print("888888888888888");
        UserList userList=new UserList();
        userList.setOpenid(openid);
        userList.setSex(map.get("sex"));
        userList.setUserName(map.get("nickname"));
        userList.setReservedFields(map.get("headimgurl"));
        userList.setAddress(map.get("unionid"));
        userList.setCreateTime(date3);
        userList.setState(1);
        userListService.updateUser(userList);
    	
        }
		return JSON.toJSONString(userListService.getUserByOpenId(openid));
	}
	
	@RequestMapping("/getOpenId2")
	public String getOpenId2(String code,String state,RedirectAttributes redirectAttributes,HttpServletResponse response){
		
		
		String openid=wxHelpUtil.wxGetOpenId(code).get("openid");
		
		String name="openid";
		String value=openid;
		Cookie cookie = new Cookie(name.trim(), value.trim());
        cookie.setMaxAge(30 * 60);// 设置为30min
        cookie.setPath("/");
        System.out.println("已添加===============");
		response.addCookie(cookie);
		
		redirectAttributes.addAttribute("openid",openid);
		redirectAttributes.addAttribute("activityId",state);
		
		System.out.println("8888 "+state);
		String result="redirect:/vote/voteIndex2";
		return result;
	}

	@RequestMapping("/getOpenidAndUrl")
	public String getOpenId3(String code,String state,RedirectAttributes redirectAttributes){
		String openid=wxHelpUtil.wxGetOpenId(code).get("openid");
		System.out.println(state);
		redirectAttributes.addAttribute("openid",openid);
		
		String result=state;
		return result;
	}
	
	
	//获取token
	@RequestMapping("/getAccessToken")
	@ResponseBody
	public String getAccessToken(){
		WxData wxData =new WxData();
		wxData.setAccessToken(wxHelpUtil.wxGetaccessToken());
		Date nowDate = new Date();
		wxData.setAccessTokenTime(nowDate);
		wxData.setJsapiTicket(wxHelpUtil.wxjsapiTicket(wxData.getAccessToken()));
		if(wxDataService.addWxData(wxData)>0){
			return JSON.toJSONString("success");
		}else{
			return JSON.toJSONString("fail");
		}
		
		
	}
	
	
	//生成签名
	@RequestMapping("/buildSign")
	@ResponseBody
	public String buildSign(String url,String webtype){
		accessTokenUpdate();
		WxData wxData=wxDataService.selectWxDataByOpenid("system").get(0);
		Date date1 =wxData.getAccessTokenTime();
		Date date2 =wxData.getJsapiTicketTime();
        Calendar cal = Calendar.getInstance();   
        cal.setTime(date1);   
        cal.add(Calendar.HOUR, 2);// 2小时
        date1 = cal.getTime();
        Calendar cal2 = Calendar.getInstance();   
        cal2.setTime(date2);   
        cal2.add(Calendar.HOUR, 2);// 2小时
        date2 = cal2.getTime();
        Date date3=new Date();
        if(date2.after(date3)){       	
        }else{
        	if(date1.after(date3)){
        		//重新获取JsapiTicket
        		wxData.setJsapiTicket(wxHelpUtil.wxjsapiTicket(wxData.getAccessToken()));
        		wxData.setJsapiTicketTime(date3);
        		wxDataService.updataWxData(wxData);
        	}else{
        		//重新获取accessTicket
        		wxData.setAccessToken(wxHelpUtil.wxGetaccessToken());
        		//重新获取JsapiTicket
        		wxData.setJsapiTicket(wxHelpUtil.wxjsapiTicket(wxData.getAccessToken()));
        		wxData.setJsapiTicketTime(date3);
        		wxData.setAccessTokenTime(date3);
        		wxDataService.updataWxData(wxData);
        		
        		
        	}
        }
        if(webtype.equals("1")){
        	
        }else if(webtype.equals("2")){
        	url=url+"?from=timeline&isappinstalled=0";
        }else if(webtype.equals("3")){
        	url=url+"?from=groupmessage&isappinstalled=0";
        }else if(webtype.equals("4")){
        	url=url+"?from=singlemessage&isappinstalled=0";
        }else if(webtype.equals("5")){
        	url=url+"&from=timeline&isappinstalled=0";
        }else if(webtype.equals("6")){
        	url=url+"&from=groupmessage&isappinstalled=0";
        }else if(webtype.equals("7")){
        	url=url+"&from=singlemessage&isappinstalled=0";
        }
		return JSON.toJSONString(JsSignUtil.sign(url,wxData.getJsapiTicket()));
	}
	
	
	
	//新生成签名(自动拼接参数）
		@RequestMapping("/newBuildSign")
		@ResponseBody
		public String newBuildSign(String url,String paras){
			
			System.out.println("我进来了"+url+"和"+paras);
			accessTokenUpdate();
			System.out.println("accessTokenUpdate成功");
			WxData wxData=wxDataService.selectWxDataByOpenid("system").get(0);
			Date date1 =wxData.getAccessTokenTime();
			Date date2 =wxData.getJsapiTicketTime();
	        Calendar cal = Calendar.getInstance();   
	        cal.setTime(date1);   
	        cal.add(Calendar.HOUR, 2);// 2小时
	        date1 = cal.getTime();
	        Calendar cal2 = Calendar.getInstance();   
	        cal2.setTime(date2);   
	        cal2.add(Calendar.HOUR, 2);// 2小时
	        date2 = cal2.getTime();
	        Date date3=new Date();
	        if(date2.after(date3)){       	
	        }else{
	        	if(date1.after(date3)){
	        		//重新获取JsapiTicket
	        		wxData.setJsapiTicket(wxHelpUtil.wxjsapiTicket(wxData.getAccessToken()));
	        		wxData.setJsapiTicketTime(date3);
	        		wxDataService.updataWxData(wxData);
	        	}else{
	        		//重新获取accessTicket
	        		wxData.setAccessToken(wxHelpUtil.wxGetaccessToken());
	        		//重新获取JsapiTicket
	        		wxData.setJsapiTicket(wxHelpUtil.wxjsapiTicket(wxData.getAccessToken()));
	        		wxData.setJsapiTicketTime(date3);
	        		wxData.setAccessTokenTime(date3);
	        		wxDataService.updataWxData(wxData);
	        		
	        		
	        	}
	        }
	        if(!paras.equals("null")){
	        	
	        	url+="?";
	        	String parasArray[]=paras.split(",");
	        	for(int i=0;i<parasArray.length;i++){
	        		url+=parasArray[i]+"&";
	        	}
	        	url=url.substring(0,url.length()-1);
	        	System.out.println("签名地址"+url);
	        }
			return JSON.toJSONString(JsSignUtil.sign(url,wxData.getJsapiTicket()));
		}
	
	//授权页
	@RequestMapping("/authorizationWeb")
	public String authorizationWeb(String url){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		System.out.println(date);
        System.out.println("front:" + format.format(date)); //显示输入的日期  

        Calendar cal = Calendar.getInstance();   
        cal.setTime(date);   
        cal.add(Calendar.HOUR, 2);// 24小时制   
        date = cal.getTime();   
        
        System.out.println("after:" + format.format(date));
		System.out.println(date);
		return "";
	}
	
	//确保accessToken不过期
	public void accessTokenUpdate(){
		WxData wxData=wxDataService.selectWxDataByOpenid("system").get(0);
		Date date1 =wxData.getAccessTokenTime();
		Date date2 =wxData.getJsapiTicketTime();
        Calendar cal = Calendar.getInstance();   
        cal.setTime(date1);   
        cal.add(Calendar.HOUR, 2);// 2小时
        date1 = cal.getTime();
        Calendar cal2 = Calendar.getInstance();   
        cal2.setTime(date2);   
        cal2.add(Calendar.HOUR, 2);// 2小时
        date2 = cal2.getTime();
        Date date3=new Date();
        if(date2.after(date3)){       	
        }else{
        	if(date1.after(date3)){
        		//重新获取JsapiTicket
        		wxData.setJsapiTicket(wxHelpUtil.wxjsapiTicket(wxData.getAccessToken()));
        		wxData.setJsapiTicketTime(date3);
        		wxDataService.updataWxData(wxData);
        	}else{
        		//重新获取accessTicket
        		wxData.setAccessToken(wxHelpUtil.wxGetaccessToken());
        		//重新获取JsapiTicket
        		wxData.setJsapiTicket(wxHelpUtil.wxjsapiTicket(wxData.getAccessToken()));
        		wxData.setJsapiTicketTime(date3);
        		wxData.setAccessTokenTime(date3);
        		wxDataService.updataWxData(wxData);
        	}
        }
	}
	
	//上传文件
	@RequestMapping("/uploadWxFile")
	@ResponseBody
	public String uploadWxFile(HttpServletRequest request){
		accessTokenUpdate();
		String accessToken=wxDataService.selectWxDataByOpenid("system").get(0).getAccessToken();
		String result="";
		String introduction=null;
		String title="学车海报";
		String type="image";
		String imgPath =  request.getSession().getServletContext().getRealPath("/") +"upload/image01.jpg";
		File file=new File(imgPath);
		result=wxHelpUtil.uploadPermanentMaterial(file, type, title, introduction, accessToken);
		return result;
	}
	
	

	
    

	
	
	
}