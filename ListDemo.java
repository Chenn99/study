import java.util.List;
import java.util.ArrayList;

/**
 * Collection接口:用于存储单个对象的集合
 * List接口:
 * 1.有序的
 * 2.允许多个null元素
 * 3.具体的实现有常用的:ArrayList,Vector,LinkedList
 * Set接口:
 * @author Administrator
 *
 */
public class ListDemo {

	/**
	 * ArrayList
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
