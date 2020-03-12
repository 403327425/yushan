package com.gezi.GS.util;

import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * AES加密工具类
 *
 * @author jarome
 * @date 2017/12/22
 **/
public class AesUtils {

//	private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS7Padding";
	
	static {
		//如果是PKCS7Padding填充方式，则必须加上下面这行
		Security.addProvider(new BouncyCastleProvider());
	}

	public static String PADDING = "AES/CBC/PKCS7Padding";

	private static final String KEY_ALGORITHM = "AES";

	public static Integer APP_IV_LEN = 16;

	public static String APP_IV = "ACE1201805011FDB";

	public static String generateKey() throws Exception {
		// 实例化密钥生成器
		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
		/**
		 * 设置AES密钥长度 AES要求密钥长度为128位或192位或256位，java默认限制AES密钥长度最多128位
		 * 如需192位或256位，则需要到oracle官网找到对应版本的jdk下载页，在"Additional Resources"中找到 "Java
		 * Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy
		 * Files",点击[DOWNLOAD]下载
		 * 将下载后的local_policy.jar和US_export_policy.jar放到jdk安装目录下的jre/lib/security/目录下，替换该目录下的同名文件
		 */
		kg.init(128);
		// 生成密钥
		SecretKey secretKey = kg.generateKey();
		// 获得密钥的字符串形式
		return Base64.encodeBase64String(secretKey.getEncoded());
	}

	/**
	 * 加密方法
	 *
	 * @param data    要加密的数据
	 * @param key     加密key
	 * @param iv      加密iv
	 * @param padding 数据填充方式
	 * @return 加密的结果
	 */
	/*
	 * public static String encode(String data, String key, String iv, String
	 * padding) { try { //算法/模式/补码方式 Cipher cipher = Cipher.getInstance(padding);
	 * int blockSize = cipher.getBlockSize(); byte[] dataBytes = data.getBytes();
	 * int plaintextLength = dataBytes.length; if (plaintextLength % blockSize != 0)
	 * { plaintextLength = plaintextLength + (blockSize - (plaintextLength %
	 * blockSize)); } byte[] plaintext = new byte[plaintextLength];
	 * System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length); SecretKeySpec
	 * keyspec = new SecretKeySpec(key.getBytes(), "AES"); IvParameterSpec ivspec =
	 * new IvParameterSpec(iv.getBytes()); cipher.init(Cipher.ENCRYPT_MODE, keyspec,
	 * ivspec); byte[] encrypted = cipher.doFinal(plaintext);
	 * 
	 * //return CodecUtils.parseByte2HexStr(encrypted); return new
	 * Base64().encodeToString(encrypted); } catch (Exception e) {
	 * LOGGER.error("encode err", e); return null; } }
	 * 
	 *//**
		 * 	加密方法
		 *
		 * @param content 加密内容
		 * @param key     加密key
		 * @param iv      加密iv
		 * @param padding 数据填充方式
		 * @return 原数据
	 * @throws Exception 
		 *//*
			 * public static String decode(String content, String key, String iv, String
			 * padding) { try { Security.addProvider(new BouncyCastleProvider()); Cipher
			 * cipher = Cipher.getInstance(padding); SecretKeySpec keyspec = new
			 * SecretKeySpec(key.getBytes(), padding); IvParameterSpec ivspec = new
			 * IvParameterSpec(iv.getBytes()); cipher.init(Cipher.DECRYPT_MODE, keyspec,
			 * ivspec);
			 * 
			 * byte[] contentBytes = new Base64().decode(content); if (contentBytes == null)
			 * { return null; } byte[] original = cipher.doFinal(contentBytes); //去除结尾的0 int
			 * i = original.length - 1; for (; i >= 0; i--) { byte bi = original[i]; if (bi
			 * != 0) { break; } } byte[] res = new byte[i + 1]; System.arraycopy(original,
			 * 0, res, 0, i + 1); return new String(res); } catch (Exception e) {
			 * LOGGER.error("decode err", e); return null; } }
			 */

	public static String encode(String data, String key, String iv, String padding) throws Exception {
		byte[] sourceBytes = data.getBytes("UTF-8");
		/* byte[] keyBytes = Base64.decodeBase64(key); */
		Cipher cipher = Cipher.getInstance(padding);
		SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), KEY_ALGORITHM);
		/*
		 * cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyBytes, KEY_ALGORITHM));
		 */
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		byte[] decrypted = cipher.doFinal(sourceBytes);
		return Base64.encodeBase64String(decrypted);
	}

	/**
	 * 解密方法
	 *
	 * @param content 加密内容
	 * @param key     加密key
	 * @param iv      加密iv
	 * @param padding 数据填充方式
	 * @return 原数据
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	public static String decode(String content, String key, String iv, String padding) throws NoSuchAlgorithmException, Exception {
		byte[] sourceBytes = Base64.decodeBase64(content);
		/* byte[] tmpt = Base64.decode(content.getBytes("UTF-8"), */
		//byte[] sourceBytes=new Base64().decode(content.getBytes("UTF-8"));
		SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(),KEY_ALGORITHM);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		/* byte[] keyBytes = Base64.decodeBase64(key); */
        Cipher cipher = Cipher.getInstance(padding);  
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec,ivParameterSpec);  
        byte[] decoded = cipher.doFinal(sourceBytes);  
        return new String(decoded, "UTF-8");
	}

}
