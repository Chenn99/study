package com.guava;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class GuavaDemo {
	
	/**
	 * 集合操作：交集，差集，并集
	 */
	@Test
	public void testGuava6() {
		Set<Integer> set1 = Sets.newHashSet(1,2,3);
		Set<Integer> set2 = Sets.newHashSet(3,4,5);
		//交集
		SetView<Integer> v1 = Sets.intersection(set1, set2);
	//	v1.forEach(System.out::println);
		
		//差集
		SetView<Integer> v2 = Sets.difference(set1, set2);
		//v2.forEach(System.out::println);
		
		//并集
		SetView<Integer> v3 = Sets.union(set1, set2);
		v3.forEach(System.out::println);
	}
	
	
	/**
	 * 加入约束：非空，长度验证
	 */
	@Test
	public void testGuava5() {
//		Set<String> set = Sets.newHashSet();
//		//14版可用
//		Constraint<String> constraint = new Constraint<>(){
//			@Override
//			public String checkElement(String element) {
//				
//			}
//		}
//		Preconditions.checkArgument(expression);
//		Preconditions.checkArgument(reference);
	}
	
	/**
	 * 组合式函数
	 */
	@Test
	public void testGuava4() {
		List<String> list = Lists.newArrayList("lily","louis","jack","tom","bob");
		
		//函数：截取
		Function<String,String> f1 = new Function<String, String>() {
			public String apply(String t) {
				return t.length()>4?t.substring(0,3):t;
			}
		};
		//函数：转大写
		Function<String,String> f2 = new Function<String, String>() {
			public String apply(String t) {
				return t.toUpperCase();
			}
		};
		
		//把两个函数组合起来
		Function<String, String> f =  Functions.compose(f1, f2); //compose 组合的意思
		Collection<String> col = Collections2.transform(list, f);
		col.forEach(System.out::println);
	}
	
	/**
	 * 转换
	 */
	@Test
	public void testGuava3() {
		Set<Long> timeSet = Sets.newHashSet(20240927L,20241109L,20250947L);
		Collection<String> res = Collections2.transform(timeSet, (e)->new SimpleDateFormat("yyy-mm-dd").format(e));
		res.forEach(System.out::println);
	}
	
	/**
	 * 过滤器
	 */
	@Test
	public void testGuava2() {
		
		List<String> list = Lists.newArrayList("lily","louis","jack","tom","bob");
		Collection<String> res = Collections2.filter(list, (e)->e.startsWith("l"));
		res.forEach(System.out::println); //:: 是方法引用运算符，用于将一个方法作为参数传递。
	}
	
	/**
	 * 设置只读
	 */
	@Test 
	public void testGuava1() {
		System.out.println("test Guava");
		
		//第一种方式    利用默认JDK来实现
//		List<String> list = Arrays.asList("jack");
//		list.add("tom");  
		//第二种方式
		List<String> list = new ArrayList<>();
		list.add("tom");
		list.add("lily");
		list.add("Bob");
		list.add("bin");
//		List<String> red = Collections.unmodifiableList(list);
//		red.add("cc");  
		//第三种方式
//		ImmutableList<String> list1 = ImmutableList.of("tom", "jack", "bob", "lily");
//		list1.add("louis");
	}
}