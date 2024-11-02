import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set接口
 * 1.无序的(不保证顺序)
 * 2.不允许重复元素
 * HashSet,TreeSet,LinkedHashSet
 * 
 * 如果要排序,选择TreeSet
 * 如果不用排序,也不用保证顺序HashSet,
 * 不要排序,要保证顺序,选择LinkedHashSet
 */
public class SetDemo {
	
	/**
	 * 哈希表和链接列表实现,
	 * 维护着一个运行于所有条目的双重链接列表.
	 * 此链接列表定义了迭代顺序,即按照将元素插入到set中的顺序(插入顺序)进行迭代.
	 */
	private static void linkedHashSet() {
		LinkedHashSet<Cat> set = new LinkedHashSet<>();
		Cat c1 = new Cat("小白", 5, 1);
		Cat c2 = new Cat("小花", 2, 2);
		Cat c3 = new Cat("小兰", 2, 3);
		Cat c4 = new Cat("小黑", 5, 1);
		set.add(c1);
		set.add(c2);
		set.add(c3);
		set.add(c4);
		
		for (Cat cat : set) {
			System.out.println(cat);
		}
		
	}
	
	
	/**
	 * 有序的,基于TreeMap(二叉树数据结构),对象需要比较大小,通过对象比较器来实现,
	 * 对象比较器还可以用来去除重复元素,如果自定义的数据类,没有实现比较器接口,将无法添加到TreeSet集合中
	 */
	private static void TreeSet(){
		TreeSet<Cat> tree = new TreeSet<>(new CatComparator());
		Cat c1 = new Cat("小白", 5, 1);
		Cat c2 = new Cat("小花", 2, 2);
		Cat c3 = new Cat("小兰", 2, 3);
		Cat c4 = new Cat("小黑", 3, 1);
		tree.add(c1);
		tree.add(c2);
		tree.add(c3);
		tree.add(c4);
		System.out.println(tree.size());
		
		for (Cat cat : tree) {
			System.out.println(cat);
		}
		
		
	}
	
	
	/**
	 * HashSet
	 * 1.实现原理,基于哈希表(HashMap)实现
	 * 2.不允许重复,可以有一个NULL元素
	 * 3.不保证顺序恒久不变
	 * 4.添加元素时把元素作为HashMap的key存储,HashMap的value使用一个固定的object对象
	 * 5.排除重复元素是通过equals来检查对象是否相同
	 * 6.判断两个对象是否相同,先判断两个对象的hashCode是否相同(如果两个对象的hashCode相同,不一定是同一个对象,如果不同,那一定
	 * 不是同一个对象),如果不同,则两个对象不是同一个对象,如果相同,还要进行equals判断,equals相同则是同一个对象,不同则不是同一个对象)
	 * 7.自定义对象要认为属性值都相同时为同一个对象,有这种需求时,那么我们要重写对象所在类的hashCode和equals方法
	 * 
	 * 小结
	 * 1)哈希表的存储结构:数组+链表,数组里的每个元素以链表的形式存储
	 * 2)如何把对象存储到哈希表中,先计算对象的hashCode值,再对数组的长度求余数,来决定对象要存储在数组中的哪个位置
	 * 3)解决hashSet中的重复值使用的方式是,参考第6点
	 * 
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
		Cat c4 = new Cat("喵喵", 5, 1);
		
		Set<Cat> cats = new HashSet<>();
		cats.add(c1);
		cats.add(c2);
		cats.add(c3);
		cats.add(c4);
		//cats.add(c1); System.out.println(cats.size()) //4个
		System.out.println(cats.size()); 
		
		for (Cat cat : cats) {
			System.out.println(cat);
		}
		System.out.println("c1="+c1.hashCode());
		System.out.println("c2="+c2.hashCode());
		System.out.println("c3="+c3.hashCode());
		System.out.println("c4="+c4.hashCode());
	}
	
	
	public static void main(String[] args) {
		//hashSet();
		//TreeSet();
		linkedHashSet();
	}

}
