import java.util.HashSet;
import java.util.Set;

/**
 * Set接口
 * 1.无序的(不保证顺序)
 * 2.不允许重复元素
 * HashSet,TreeSet,LinkedHashSet
 */
public class SetDemo {
	
	/**
	 * HashSet
	 * 1.实现原理,基于哈希表(HashMap)实现
	 * 2.不允许重复,可以有一个NULL元素
	 * 3.不保证顺序恒久不变
	 * 4.添加元素时把元素作为HashMap的key存储,HashMap的value使用一个固定的object对象
	 * 5.排除重复元素是通过equals来检查对象是否相同
	 */
	private static void hashSet() {
		Set<String> set = new HashSet<>();
		set.add("张飞");
		set.add("关羽");
		set.add("刘备");
		set.add("诸葛亮");
		set.add("曹操");
		set.add("");	
		System.out.println(set.size());
		//遍历打印
		String[] names = set.toArray(new String[]{});
		for (String s : names) {
			System.out.println(s);
		}
		
		Cat c1 = new Cat("喵喵", 5, 1);
		Cat c2 = new Cat("花花", 1, 2);
		Cat c3 = new Cat("小白", 2, 3);
		Cat c4 = new Cat("喵喵", 6, 4);
		
		Set<Cat> cats = new HashSet<>();
		cats.add(c1);
		cats.add(c2);
		cats.add(c3);
		cats.add(c4);
		//cats.add(c1); System.out.println(cats.size()) //4个
		System.out.println(cats.size()); 
	}
	
	
	public static void main(String[] args) {
		hashSet();
	}

}
