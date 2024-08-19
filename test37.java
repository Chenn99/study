package study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * foreach循环：for循环的底层原理
 */
public class test37 {
	public static void main(String [] args) {
		
		//foreach循环：增强for循环的底层原理
		//数组
		int [] arr = {1,2,3,4,5}; 
		//冒号左边是我们要取出来的个体元素，冒号右边是我们要遍历的数组
		for (int i : arr) { 
			System.out.println(i);
		}
		//以上foreach的底层源码：数组遍历的本质
		//转换成下标遍历i打印出来
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		//集合
		List<Integer> List = new ArrayList<>();
		List.add(1);
		List.add(2);
		List.add(3);
		
		for (Integer integer : List) {
			System.out.println(integer); //输出1 2 3
		}
		
		//foreach遍历集合-> java底层使用迭代器遍历：List遍历的本质
		Iterator<Integer> iterator = List.iterator();
		while (iterator.hasNext()) {
			int x = iterator.next();
			System.out.println(x);
		}
	}
}

