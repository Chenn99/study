package com.guava;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.Collections2;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Sets.SetView;

public class GuavaDemo {
	
	/**
	 * 双键的Map -> Table -> rowKey+columnKey+value
	 */
	@Test
	public void testGuava10() {
		Table<String, String, Integer> table = HashBasedTable.create();
		table.put("jack", "java", 80);
		table.put("tom", "php", 70);
		table.put("bin", "java", 59);
		table.put("lily", "c", 98);
		
		Set<Cell<String, String, Integer>> cells = table.cellSet();
		for (Cell cell : cells) {
			System.out.println(cell.getRowKey()+"-"+cell.getColumnKey()+"-"+cell.getValue());
//			jack-java-80
//			tom-php-70
//			bin-java-59
//			lily-c-98
		}
	}
	
	/**
	 * BiMap:双向Map（bidirectional Map）键与值不能重复
	 */
	@Test
	public void testGuava9() {
		BiMap<String, String> map = HashBiMap.create();
		map.put("finally_test", "17313628537");
		map.put("bin_test", "19824748264");
		String name = map.inverse().get("19824748264");
		System.out.println(name);
		
		//System.out.println(map.inverse().inverse()==map);//true
		//inverse 代表反转，将key 和 value 的位置调换
	}
	
	/**
	 * MultiMap:key可重复
	 */
	@Test
	public void testGuava8() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Java从入门到精通", "tom");
		map.put("Android从入门到精通", "tom");
		map.put("PHP从入门到精通", "jack");
		map.put("天天开心", "vince");
		
		Multimap<String, String> mmap = ArrayListMultimap.create();
		Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();//加一个迭代器
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = iter.next();
			mmap.put(entry.getValue(), entry.getKey());
		}
		
		Set<String> keySet = mmap.keySet();
		for (String key : keySet) {
			Collection<String> val = mmap.get(key);
			System.out.println(key+"->"+val);
		}
//		tom->[Java从入门到精通, Android从入门到精通]
//		vince->[天天开心]
//		jack->[PHP从入门到精通]
	}
	
	/**
	 * Multise:无序可重复
	 */
	@Test
	public void testGuava7() {
		String s = "good good study day day up";
		String[] ss = s.split(" ");
		HashMultiset<String> set = HashMultiset.create();
		for (String str : ss) {
			set.add(str);
		}
		
		Set<String> set2 = set.elementSet();
		for (String str : set2) {
			System.out.println(str+":"+set.count(str));
		}
		//输出结果
//		study:1
//		up:1
//		good:2
//		day:2
	}
	
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