package com.gezi.hdlw.util;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class MyUtil {
	/**
	 * 返回当前日期的字符串表示 YYYY-MM-DD
	 * 
	 * @return 当前日期的字符串表示
	 */
	public static String getNowDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	public static Date getDateByString(String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	//批次号
	public static String create_Batch_no(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(new Date());
    }

	public static Date getDateByString2(String dateStr) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取当前日期的Date格式化类型(yyyy-MM-dd)
	 * 
	 * @return
	 */
	public static Date createDate() {
		String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(nowDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 得到yyyyMMddHHmmss
	 */
	public static String getNowDateStr() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	/**
	 * 得到yyyyMMddHHmmss
	 */
	public static String getNowDateStr2() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 得到一个字符串形式的格式化UUID
	 * 
	 * @return
	 */
	public static String getStrUUID() {
		Random random = new Random();
		int end = random.nextInt(999);
		// 如果不足三位前面补0
		String endStr = String.format("%03d", end);
		return UUID.randomUUID().toString().replace("-", "") + endStr;
	}

	// 自动生成名字（中文）
	public static String getRandomNickName() {
		int max = 4;
		int min = 2;
		int len = new Random().nextInt(max) % (max - min + 1) + min;
		String ret = "";
		try {
			for (int i = 0; i < len; i++) {
				int hightPos, lowPos; // 定义高低位
				Random random = new Random();
				hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
				lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
				byte[] b = new byte[2];
				b[0] = (new Integer(hightPos).byteValue());
				b[1] = (new Integer(lowPos).byteValue());
				ret += new String(new String(b, "GBK").getBytes("UTF-8"), "ISO-8859-1");
			}
			return new String(ret.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
