package study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 关于集合遍历删除元素
 */
public class test38 {
	public static void main(String [] args) {
				
		//集合
		List<Integer> List = new ArrayList<>();
		List.add(1);
		List.add(2);
		List.add(3);
		List.add(4);
		List.add(5);
		
		//当想删除第三个元素
		//如果实现集合删除必须使用迭代器删除，否则会报java.util.ConcurrentModificationException
//		for (int i : List) {
//			if (i == 3) {  //这里的逻辑没有问题，但是报异常
//				List.remove(i);
//			}
//		}
		
		//Iterator原理：
		//迭代器                  集合                       迭代器                  集合
		// 1    ->    a        1    ->    a
		// 2    ->            
		// 3    ->    c        3    ->    c
		//迭代器会创建一个指向原来集合的索引表，集合元素删除的时候，迭代器中的索引表不会同步改变，找不到要迭代的对象，所以会报错。
		
		//使用迭代器（iterator)方式来实现遍历删除元素
		Iterator<Integer> iterator = List.iterator();
		while (iterator.hasNext()) {
			int x = iterator.next(); //在这里取到元素
			if (x == 3) {
				iterator.remove();
			}
		}
		
		List.forEach(System.out::println);
	}
}

