package com.vince;

import java.util.Arrays;

public class StringDemo2 {

	public static void main(String[] args) {

		String str = "dhgugau27643";
		char c = str.charAt(1);
		//System.out.println(c);
		
		System.out.println(str.toCharArray());
		char[] cs = {'a','b','c'};
		String s1 = new String(cs);
		System.out.println(s1);
		
		String s2 = new String(cs,0,1);
		System.out.println(s2);
		
	 //转换成字节
		System.out.println(Arrays.toString(str.getBytes()));
		//assii码 [100, 104, 103, 117, 103, 97, 117, 50, 55, 54, 52, 51]
		
		System.out.println(str.replace('h', '*'));
		System.out.println(str.replaceAll("[0-9]", "*"));//dhgugau*****
	//预定义字符类
	//\d = [0-9]
		System.out.println(str.replaceAll("\\d", "*")); //dhgugau*****
		
		System.out.println(str.substring(4)); //gau27643
		System.out.println(str.substring(3, 8)); //ugau2
		
		System.out.println(Arrays.toString(str.split("u")));
		System.out.println(str.contains("u")); //true
		
		System.out.println(str.indexOf("u"));//3  找到第一个u的位置 返回它的索引
		System.out.println(str.lastIndexOf("u"));//6  从后往前找
		String s3 = "";
		System.out.println(s3.isEmpty()); //true 是空字符串
		System.out.println(str.isEmpty()); //false
		System.out.println(str.length()); //12
		
		String s4 = " sdbcgua ahdi376r "; 
		System.out.println(s4.trim()); //sdbcgua ahdi376r 中间空格不去除
		System.out.println(s4.concat("**88*"));
		//  sdbcgua ahdi376r **88*
		
	}

}
