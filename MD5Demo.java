package com.vince;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class MD5Demo {

	private static String savePassword = "pmq7VoTEWWLYh1ZPCDRujQ==";//存储的密文
	
	public static void main(String[] args) {

		//test();
		//System.out.println(login("12345678"));//false
		System.out.println(login("admin123456"));//true
		//忘记密码了只能重置密码 不能查看明文
	}
	
	private static boolean login(String password) {
		
		if (savePassword.equals(md5(password))) {
			return true;
		}else {
			return false;
		}
	}

	//计算md5的工具方法
	private static String md5(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			//通过MD5计算摘要
			byte[] bytes = md.digest(password.getBytes("UTF-8"));
			String str = Base64.getEncoder().encodeToString(bytes);
			return str;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private static void test() {
		String password = "admin123456";//achka8216419461密码明文(原文)
		String savePassword = "pmq7VoTEWWLYh1ZPCDRujQ==";//存储的密文
		
		try {
			MessageDigest md = MessageDigest.getInstance("md5");//SHA-1
			//通过MD5计算摘要
			byte[] bs = md.digest(password.getBytes("UTF-8"));
			System.out.println(Arrays.toString(bs));
			String mdStr = new String(bs);
			//System.out.println(mdStr);
			//a-z A-Z 0-9 / *  BASE64编码算法
			//1.8版本
			//String str = Base64.getEncoder().encodeToString(bs);
			//System.out.println(str);//pmq7VoTEWWLYh1ZPCDRujQ==
			
			//JDK1.8之前使用  没有访问权限 需要自己设定
			BASE64Encoder bsBase64Encoder = new BASE64Encoder();
			String str = bsBase64Encoder.encode(bs);
			//base64解码
			BASE64Decoder base64Decoder = new BASE64Decoder();
			byte[] bytes = base64Decoder.decodeBuffer(str);
			System.out.println(bytes);//pmq7VoTEWWLYh1ZPCDRujQ==
			
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
