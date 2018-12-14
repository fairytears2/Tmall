package com.netease.course.uitls;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {
	

	public static void main(String[] args) {
		System.out.println(md5("admin", "123456"));
	}
	
	//项目中的加密算法，比较流行的有：MDX(MD2,MD5),SHA-X(SHA-1,256,384,512)
	public static String md5(String str1,String str2) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");//参数为加密的算法
			md.update(str1.getBytes());//将明文更新到md对象中；
			md.update(str2.getBytes());
			byte[]  rs=  md.digest();//做加密计算
			return new BigInteger(1,rs).toString(16);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@SuppressWarnings("static-access")
	public static String sha_1(String string){
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(string.getBytes());
			byte[] rs = md.digest();
			StringBuffer sBuffer = new StringBuffer();
			for (byte b : rs) {
				sBuffer.append(string.format("%02x", b));
			}
			return sBuffer.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
		
	}
	
	
	
	
}
