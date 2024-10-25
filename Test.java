package com.vince.decorator;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Test{
	
	public static void main(String[] args) {
		
		
//		OutputStream ops = new FileOutputStream("xxx");
//		BufferedOutputStream bos = new BufferedOutputStream(ops);
//		PrintStream ps = new PrintStream(bos);
//		ps.print(false);
		
		Drink drink = new SoyaBeanMilk();
		SugarDecorator sugar = new SugarDecorator(drink);
		EggDecorator egg = new EggDecorator(sugar);
		BlackBeanDecorator bean = new BlackBeanDecorator(egg);
		
		System.out.println("你点的豆浆是: "+bean.description());
		System.out.println("一共花了"+bean.cost()+"元");
//		你点的豆浆是: 纯豆浆+糖+鸡蛋+黑豆
//		一共花了16.0元
	}
}