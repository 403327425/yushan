package com.gezi.hdlw.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;

import freemarker.core.ReturnInstruction.Return;


@Service
public class wxHelpUtil {
	//公众号的唯一标识
	private String appid="wx0e7143aff63d531b";
	//授权后重定向的回调链接地址， 请使用 urlEncode 对链接进行处理
	private String redirect_uri="";
	
/*	//返回类型，请填写code
	private String response_type;*/
	
	/*应用授权作用域，
	snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），
	snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且， 即使在未关注的情况下，只要用户授权，也能获取其信息 ）*/
	private String scope="snsapi_userinfo";
	//重定向后会带上state参数，
	private String state;
	//公众号的appsecret	
	private String secret="d3d18e44de602b96ad6baa2fa6f90e80";
	//code
	private String code;
	//网页授权接口调用凭证
	private String access_token;
	//用户的唯一标识
	private String openid;
	
	
	public String wxGetCode(String temp) {
		state=temp;
		String address="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+"&redirect_uri="+redirect_uri+"&response_type=code&scope="+scope+"&state="+state+"#wechat_redirect ";
		System.out.println(address);
		return address;
	}
	//处理code
	public Map<String, String> wxGetOpenId(String code){
		String address="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
		System.out.println(address);
		Map<String,String> map=new HashMap<String, String>();
		String openid="";
		String refresh_token="";
		String access_token="";
		try {
			URL Idurl =new URL(address);
			HttpURLConnection conn = (HttpURLConnection) Idurl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			InputStream is = conn.getInputStream();
	        //构造一个字符流缓存
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        String str = "";
	        while ((str = br.readLine()) != null) {
	            System.out.println(str);
	            JSONObject jsonObject = JSON.parseObject(str);
		        openid=jsonObject.getString("openid");
		        refresh_token=jsonObject.getString("refresh_token");
		        access_token=jsonObject.getString("access_token");
		        System.out.println(openid);
	        }
	        map.put("openid", openid);
	        map.put("refresh_token", refresh_token);
	        map.put("access_token", access_token);
	        System.out.println(refresh_token);
			conn.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
		
	}
	
	//获取个人信息
	    public Map<String, String> getInfo(String access_token,String openid){
	    	
	    	String address="https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
			System.out.println(address);
			Map<String,String> map=new HashMap<String, String>();
			String nickname="";
			String sex="";
			String headimgurl="";
			String unionid="";
			try {
				URL Idurl =new URL(address);
				HttpURLConnection conn = (HttpURLConnection) Idurl.openConnection();
				conn.setRequestProperty("accept", "*/*");
				conn.setRequestProperty("connection", "Keep-Alive");
				conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
				conn.setDoOutput(true);
				conn.setDoInput(true);
				InputStream is = conn.getInputStream();
		        //构造一个字符流缓存
		        BufferedReader br = new BufferedReader(new InputStreamReader(is));
		        String str = "";
		        while ((str = br.readLine()) != null) {
		            System.out.println(str);
		            
		            JSONObject jsonObject = JSON.parseObject(str);
		            nickname=jsonObject.getString("nickname");
		            sex=jsonObject.getString("sex");
		            headimgurl=jsonObject.getString("headimgurl");
		            unionid=jsonObject.getString("unionid");
			        System.out.println(openid);
		        }
		        
		        if(nickname==null||nickname==""){
		        	nickname=" ";
		        }else{
		        	nickname=nickname.replaceAll("[^a-zA-Z0-9\\u4E00-\\u9FA5]", "");
		        }
		        map.put("nickname", nickname);
		        map.put("sex", sex);
		        map.put("headimgurl", headimgurl);
		        map.put("msg", str);
		        map.put("unionid", unionid);
		        
		        
				conn.disconnect();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return map;
	    }
	
	    
	//获取access_token
		public String wxGetaccessToken(){
		String address="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx5317ce8cdd436edd&secret=17d9a013283f80310b1e895a5a78a884";
		String access_token="";
		try {
			URL Idurl =new URL(address);
			HttpURLConnection conn = (HttpURLConnection) Idurl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			InputStream is = conn.getInputStream();
	        //构造一个字符流缓存
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        String str = "";
	        while ((str = br.readLine()) != null) {
	        	System.out.println(str);
	            JSONObject jsonObject = JSON.parseObject(str);     
	            access_token=jsonObject.getString("access_token");
	        }
			conn.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return access_token;
		
	}
	
		
		
	//更新access_token
		public String wxGetAccessTokenAgain(String refresh_token){
				String address="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+appid+"&grant_type=refresh_token&refresh_token="+refresh_token+"";
				String access_token="";
				try {
					URL Idurl =new URL(address);
					HttpURLConnection conn = (HttpURLConnection) Idurl.openConnection();
					conn.setRequestProperty("accept", "*/*");
					conn.setRequestProperty("connection", "Keep-Alive");
					conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
					conn.setDoOutput(true);
					conn.setDoInput(true);
					InputStream is = conn.getInputStream();
			        //构造一个字符流缓存
			        BufferedReader br = new BufferedReader(new InputStreamReader(is));
			        String str = "";
			        while ((str = br.readLine()) != null) {
			        	System.out.println(str);
			            JSONObject jsonObject = JSON.parseObject(str);     
			            access_token=jsonObject.getString("access_token");
			        }
					conn.disconnect();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return access_token;
		}

		
	//获取jsapi_ticket
		public String wxjsapiTicket(String accessToken){
			String address="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+accessToken+"&type=jsapi";
			String ticket="";
			try {
				URL Idurl =new URL(address);
				HttpURLConnection conn = (HttpURLConnection) Idurl.openConnection();
				conn.setRequestProperty("accept", "*/*");
				conn.setRequestProperty("connection", "Keep-Alive");
				conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
				conn.setDoOutput(true);
				conn.setDoInput(true);
				InputStream is = conn.getInputStream();
		        //构造一个字符流缓存
		        BufferedReader br = new BufferedReader(new InputStreamReader(is));
		        String str = "";
		        while ((str = br.readLine()) != null) {
		        	System.out.println(str);
		            JSONObject jsonObject = JSON.parseObject(str);     
		            ticket=jsonObject.getString("ticket");
		        }
				conn.disconnect();
			} catch (MalformedURLException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ticket;
			
		}
		//发送客服文字信息
		public void sendTextCustomMsg(String openid,String content,String accessToken ){
			JSONObject text=new JSONObject();
			text.put("content", content);
			JSONObject json = new JSONObject();
			json.put("touser", openid);
			json.put("msgtype", "text");
			json.put("text", text);
			
			String imageText=JSON.toJSONString(json);
			String url="https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken+"";
			try {
				System.out.println(getPost2(url,imageText));
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//发送客服图片信息
		public String sendImageCustomMsg(String openid,String content,String accessToken){

			JSONObject image=new JSONObject();
			image.put("media_id", content);
			JSONObject json = new JSONObject();
			json.put("touser", openid);
			json.put("msgtype", "image");
			json.put("image", image);
			
			String imageText=JSON.toJSONString(json);
			String url="https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken+"";
			try {
				System.out.println(getPost2(url,imageText));
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return imageText;
	   }
		
		
	//post接口
		public String getPost(String url,String query)throws Exception{
			URL restURL = new URL(url);
	        /*
	         * 此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类 的子类HttpURLConnection
	         */
	        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
	        //请求方式
	        conn.setRequestMethod("POST");
	        //设置是否从httpUrlConnection读入，默认情况下是true; httpUrlConnection.setDoInput(true);
	        conn.setDoOutput(true);
	        //allowUserInteraction 如果为 true，则在允许用户交互（例如弹出一个验证对话框）的上下文中对此 URL 进行检查。
	        conn.setAllowUserInteraction(false);

	        PrintStream ps = new PrintStream(conn.getOutputStream());
	        ps.print(query);

	        ps.close();

	        BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	        String line,resultStr="";

	        while(null != (line=bReader.readLine()))
	        {
	        resultStr +=line;
	        }
	        System.out.println("3412412---"+resultStr);
	        bReader.close();

	        return resultStr;
		}
	//post接口2
	    public String getPost2(String strURL, String params) {
	        System.out.println(strURL);
	        System.out.println(params);
	        BufferedReader reader = null;
	        try {
	            URL url = new URL(strURL);// 创建连接
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setDoOutput(true);
	            connection.setDoInput(true);
	            connection.setUseCaches(false);
	            connection.setInstanceFollowRedirects(true);
	            connection.setRequestMethod("POST"); // 设置请求方式
	            // connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
	            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
	            connection.connect();
	            //一定要用BufferedReader 来接收响应， 使用字节来接收响应的方法是接收不到内容的
	            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
	            out.append(params);
	            out.flush();
	            out.close();
	            // 读取响应
	            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
	            String line;
	            String res = "";
	            while ((line = reader.readLine()) != null) {
	                res += line;
	            }
	            reader.close();
	            
	            //如果一定要使用如下方式接收响应数据， 则响应必须为: response.getWriter().print(StringUtils.join("{\"errCode\":\"1\",\"errMsg\":\"", message, "\"}")); 来返回
//	            int length = (int) connection.getContentLength();// 获取长度
//	            if (length != -1) {
//	                byte[] data = new byte[length];
//	                byte[] temp = new byte[512];
//	                int readLen = 0;
//	                int destPos = 0;
//	                while ((readLen = is.read(temp)) > 0) {
//	                    System.arraycopy(temp, 0, data, destPos, readLen);
//	                    destPos += readLen;
//	                }
//	                String result = new String(data, "UTF-8"); // utf-8编码
//	                System.out.println(result);
//	                return result;
//	            }

	            return res;
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return "error"; // 自定义错误信息
	    }
	
	
	//cookie判断openid
		public boolean openidCookie(HttpServletRequest request,HttpServletResponse response){
			try{
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			response.setHeader("Content-Type", "text/html;charset=UTF-8");
		    Cookie[] cookies=request.getCookies();
		    boolean flag =false;
		    if(cookies!=null){
		    	for (Cookie cookie : cookies) {
			    	System.out.println(cookie.getName()+"====>"+cookie.getValue());
			    	if(cookie.getName().equals("openid")){
			    		flag=true;
			    	}
			    }
		    }
		    /*String name="openid";
			String value="oYk4M0mhprTKJdhrzPVPh6iFXx1o";
			Cookie cookie = new Cookie(name.trim(), value.trim());
	        cookie.setMaxAge(30 * 60);// 设置为30min
	        cookie.setPath("/");
	        System.out.println("已添加===============");
			response.addCookie(cookie);*/
		    return flag;
		}
	//cookie获取openid
		public String getOpenidByCookie(HttpServletRequest request,HttpServletResponse response){
			try{
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			response.setHeader("Content-Type", "text/html;charset=UTF-8");
		    Cookie[] cookies=request.getCookies();
		    boolean flag =false;
		    String openid="";
		    if(cookies!=null){
		    	for (Cookie cookie : cookies) {
			    	System.out.println(cookie.getName()+"====>"+cookie.getValue());
			    	if(cookie.getName().equals("openid")){
			    		openid=cookie.getValue();
			    	}
			    }
		    }
		    /*String name="openid";
			String value="oYk4M0mhprTKJdhrzPVPh6iFXx1o";
			Cookie cookie = new Cookie(name.trim(), value.trim());
	        cookie.setMaxAge(30 * 60);// 设置为30min
	        cookie.setPath("/");
	        System.out.println("已添加===============");
			response.addCookie(cookie);*/
		    return openid;
		}
	//判断cookie并删除openid
		public void delectOpenidCookie(HttpServletRequest request,HttpServletResponse response){
			Cookie cookie = new Cookie("openid", null);
			cookie.setMaxAge(0);// 设置为30min
	        cookie.setPath("/");
	        response.addCookie(cookie);
		}
		
		

		
	//上传文件
		public  String send(String fileType, String filePath,String accessToken) throws Exception {  
	        String result = null;  
	        File file = new File(filePath);  
	        if (!file.exists() || !file.isFile()) {  
	            throw new IOException("文件不存在");  
	        }  
	        /** 
	        * 第一部分 
	        */  
	        URL urlObj = new URL("https://api.weixin.qq.com/cgi-bin/material/add_material?access_token="+ accessToken + "&type="+fileType+"");  
	        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();  
	        con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式  
	        con.setDoInput(true);  
	        con.setDoOutput(true);  
	        con.setUseCaches(false); // post方式不能使用缓存  
	        // 设置请求头信息  
	        con.setRequestProperty("Connection", "Keep-Alive");  
	        con.setRequestProperty("Charset", "UTF-8");  
	        // 设置边界  
	        String BOUNDARY = "----------" + System.currentTimeMillis();  
	        con.setRequestProperty("Content-Type", "multipart/form-data; boundary="+ BOUNDARY);  
	        // 请求正文信息  
	        // 第一部分：  
	        StringBuilder sb = new StringBuilder();  
	        sb.append("--"); // 必须多两道线  
	        sb.append(BOUNDARY);  
	        sb.append("\r\n");  
	        sb.append("Content-Disposition: form-data;name=\"file\";filename=\""+ file.getName() + "\"\r\n");  
	        sb.append("Content-Type:application/octet-stream\r\n\r\n");  
	        byte[] head = sb.toString().getBytes("utf-8");  
	        // 获得输出流  
	        OutputStream out = new DataOutputStream(con.getOutputStream());  
	        // 输出表头  
	        out.write(head);  
	        // 文件正文部分  
	        // 把文件已流文件的方式 推入到url中  
	        DataInputStream in = new DataInputStream(new FileInputStream(file));  
	        int bytes = 0;  
	        byte[] bufferOut = new byte[1024];  
	        while ((bytes = in.read(bufferOut)) != -1) {  
	        out.write(bufferOut, 0, bytes);  
	        }  
	        in.close();  
	        // 结尾部分  
	        byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线  
	        out.write(foot);  
	        out.flush();  
	        out.close();  
	        StringBuffer buffer = new StringBuffer();  
	        BufferedReader reader = null;  
	        try {  
	        // 定义BufferedReader输入流来读取URL的响应  
	        reader = new BufferedReader(new InputStreamReader(con.getInputStream()));  
	        String line = null;  
	        while ((line = reader.readLine()) != null) {  
	        //System.out.println(line);  
	        buffer.append(line);  
	        }  
	        if(result==null){  
	        result = buffer.toString();  
	        }  
	        } catch (IOException e) {  
	        System.out.println("发送POST请求出现异常！" + e);  
	        e.printStackTrace();  
	        throw new IOException("数据读取异常");  
	        } finally {  
	        if(reader!=null){  
	        reader.close();  
	        }  
	        }  
	        
	        return result;  
	    }
		
		public static String uploadPermanentMaterial(File file, String type, String title, String introduction ,String access_token) {
			
			
			String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token="
					+ access_token + "&type=" + type;
	 
			String result = null;
	 
			try {
				URL uploadURL = new URL(url);
	 
				HttpURLConnection conn = (HttpURLConnection) uploadURL.openConnection();
				conn.setConnectTimeout(5000);
				conn.setReadTimeout(30000);
				conn.setDoOutput(true);
				conn.setDoInput(true);
				conn.setUseCaches(false);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Connection", "Keep-Alive");
				conn.setRequestProperty("Cache-Control", "no-cache");
				String boundary = "-----------------------------" + System.currentTimeMillis();
				conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
	 
				OutputStream output = conn.getOutputStream();
				output.write(("--" + boundary + "\r\n").getBytes());
				output.write(String.format("Content-Disposition: form-data; name=\"media\"; filename=\"%s\"\r\n", file.getName()).getBytes());
				output.write("Content-Type: video/mp4 \r\n\r\n".getBytes());
	 
				byte[] data = new byte[1024];
				int len = 0;
				FileInputStream input = new FileInputStream(file);
				while ((len = input.read(data)) > -1) {
					output.write(data, 0, len);
				}
	 
				/*对类型为video的素材进行特殊处理*/
				if ("video".equals(type)) {
					output.write(("--" + boundary + "\r\n").getBytes());
					output.write("Content-Disposition: form-data; name=\"description\";\r\n\r\n".getBytes());
					output.write(String.format("{\"title\":\"%s\", \"introduction\":\"%s\"}", title, introduction).getBytes());
				}
	 
				output.write(("\r\n--" + boundary + "--\r\n\r\n").getBytes());
				output.flush();
				output.close();
				input.close();
				
				InputStream resp = conn.getInputStream();
	 
				StringBuffer sb = new StringBuffer();
	 
				while ((len = resp.read(data)) > -1)
					sb.append(new String(data, 0, len, "utf-8"));
				resp.close();
				result = sb.toString();
			} catch (IOException e) {
				//....
			}
			
			return result;
		}

		

	
	
	
	
	
}



