import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Collection接口:用于存储单个对象的集合
 * List接口:
 * 1.有序的
 * 2.允许多个null元素
 * 3.具体的实现有常用的:ArrayList,Vector,LinkedList
 * 
 * 在实际开发中，我们如何选择list的具体实现？
 * 1.安全性问题    （推荐Vector 线程安全的，但是ArrayList也可以使用工具类将其变成线程安全的，因此使用率更高）
 * 2.是否频繁插入，删除操作（LinkList）
 * 3.是否是存储后遍历（ArrayList）
 * @author Administrator
 *
 *Set接口：
 */
public class ListDemo {

	/**
	 * linkedList
	 * 1.实现原理，采用双向链表结构实现
	 * 2.适合插入，删除操作，性能高
	 */
	private static void linkedList() {
		LinkedList<String> l = new LinkedList<>();
		l.add("陈老师");
		l.add("张老师");
		l.add("刘老师");
		l.add("李老师");
		
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
	}
	
	/**
	 * Vector
	 * 1.实现原理，采用动态对象数组实现，默认构造方法创建了一个大小为10的对象数组
	 * 2.扩充的算法：当增量为0 时，扩充为原来大小的2倍，当增量大于0时，扩充为原来大小+增量
	 * 3.不适合删除或插入操作
	 * 4.为了防止数组动态扩充次数过多，建议创建Vector时，给定初始容量
	 * 5.线程安全的，适合在多线程访问时使用，在单线程下使用效率较低，synchronzice
	 * 面试题：Vector与ArrayList的区别？
	 */
	private static void Vector(){
		Vector<String> v = new Vector<>();
		v.add("陈老师");
		v.add("张老师");
		v.add("刘老师");
		v.add("李老师");
		
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
		
	}
	/**
	 * ArrayList（1.8）
	 * 1.实现原理，采用动态对象数组实现，默认构造方法
	 * 2.第一次添加元素，扩展容量为10，之后的扩充算法：原来数组大小+原来数组的一半
	 * 3.不适合进行删除或者插入操作
	 * 4.为了防止数组动态扩充次数过多，建议创建ArrayList时，给定初始容量
	 * 5.多线程中使用不安全，适合在单线程访问时使用,效率较高
	 * JDK1.2开始
	 */
	private static void ArrayList() {
		//使用集合来存储多个不同类型的元素(对象),那么在处理时会比较麻烦,在实际开发中,不建议
		//这样使用,我们应该在一个集合中存储相同的类型对象
		//List list = new ArrayList();
		List<String> list = new ArrayList<>(); //jdk1.7后可以这样写,省略掉第二个String
		//List<String> list = new ArrayList<String>();
		list.add("陈老师");
		list.add("张老师");
		list.add("刘老师");
		list.add("李老师");
		//list.add(10);
		//遍历集合
		int size = list.size(); //变成局部变量,进栈
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		System.out.println(list.contains("陈老师"));//true
		list.remove("李老师");
		System.out.println(list.size());
		
		String[] array = list.toArray(new String[] {});
		for (String s : array) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		ArrayList();
	}

}
