package com.gezi.hdlw.util;

import java.io.File;

/**
 * 
 * 
 * <p>
 * Title: ConfigConsts
 * </p>
 * 
 * <p>
 * Description:系统资源路径
 * </p>
 * 
 * @author lixinrong
 * 
 * @date 2019年4月26日
 */
public final class ConfigConsts {
	/** 网络访问网站服务路径 外网域名+项目名 */
	public static final String API_URL = "https://gzoa.wx.ge-test.com/hdlw";
	/** 网站图片保存路径 本地物理磁盘绝对路径*/
	public static String PICTURE_IMAGE_DIR = "/www/wwwroot/gzoa.wx.ge-test.com/picture_image";
	/** 图片资源的网络访问路径 外网域名+项目名+映射资源名*/
	public static final String PICTURE_IMAGE_URL = "https://gzoa.wx.ge-test.com/hdlw/picture_image/";
	static {
		File logfile = new File("/www/wwwroot/gzoa.wx.ge-test.com", "picture_image");
		if (!logfile.exists()) {
			logfile.mkdirs();
		}
		PICTURE_IMAGE_DIR = logfile.getAbsolutePath();
	}
}
