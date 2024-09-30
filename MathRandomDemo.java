package com.vince;

import static java.lang.Math.floor;//静态导入

import java.util.Random;
public class MathRandomDemo {

	public static void main(String[] args) {

		System.out.println(Math.PI);
		//求圆周率
		System.out.println(Math.abs(-10));
		//求绝对值  返回10
		System.out.println(Math.random());
		//求0~1之间的随机数 
		System.out.println(Math.round(Math.random()*100));
		//求0~100之间的随机数 
		//Math.round(); 返回一个整数,把小数位都给去掉了
		//System.out.println(Math.round(Math.random()*1000)/1000.0);
		//0.708 保留三位小数
		System.out.println(Math.sqrt(2)); 
		//求平方根
		System.out.println(floor(1.234564));
		//求近似值
		
		Random random = new Random();
		System.out.println(random.nextLong());
		//随机数最大的长整型
		System.out.println(random.nextInt(10));
		
		
	}

}
