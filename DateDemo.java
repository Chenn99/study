package com.vince;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateDemo {

	public static void main(String[] args) {

		Date date = new Date();
		// java.sql.Date date2 = new java.sql.Date();
		System.out.println(date);
		// Mon Sep 30 23:37:37 JST 2024

		// 实际开发中使用最常的两个日期相关的构造方法
		// Date (long date) 参数是毫秒
		// Date() 空参

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = new GregorianCalendar();
		int year = c1.get(Calendar.YEAR);
		int month = c1.get(Calendar.MONTH);
		int day = c1.get(Calendar.DAY_OF_MONTH);
		int hour = c1.get(Calendar.HOUR_OF_DAY); // 24小时制
		// int hour = c1.get(Calendar.HOUR) 12小时制
		int minute = c1.get(Calendar.MINUTE);
		int second = c1.get(Calendar.SECOND);
		int millisecond = c1.get(Calendar.MILLISECOND);
		StringBuilder sb = new StringBuilder(50);
		sb.append(year).append("年").append(month).append("月").append(day).append("日").append(hour).append(":")
				.append("时").append(minute).append(":").append("分").append(second).append(":").append("秒")
				.append(millisecond).append(":").append("毫秒");
		System.out.println(sb.toString());
		//2024年8月30日23:时52:分18:秒139:毫秒

		//更加简洁,方便,常用
		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss SSS");//父类引用指向 子类对象
		//SimpleDateFormat 子类
		String nowDate = df.format(new Date());
		System.out.println(nowDate);		
		//2024年09月30日23:52:18 179
	}
}