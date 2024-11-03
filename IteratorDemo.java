import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 集合的输出(迭代)
 * @author Administrator
 *
 */
public class IteratorDemo {

	//断言接口
	private static void predicateTest() {
		List<String> list = Arrays.asList("tom","jack","job","lily");
		List<String> res = filter(list, (s)->s.contains("o"));
		res.forEach(System.out::println);
	}
	
	private static List<String> filter(List<String> list,Predicate<String> p){
		List<String> results = new ArrayList<>();
		
		for (String s : list) {
			if (p.test(s)) { //测试是否符合要求
				results.add(s);
			}
		}
		return results;
	}
	
	//supplier 代表结果供应商
	private static void supplierTest() {
		List<Integer> list = getNums(10,()->(int)(Math.random() *100));
		list.forEach(System.out::println);
	}
	
	private static List<Integer> getNums(int num,Supplier<Integer> sup) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			list.add(sup.get());
		}
		return list;
	}
	
	//表示接受一个参数并产生结果的函数
	private static void functionTest() {
		String s = strToUpp("abcd", (str)->str.toUpperCase());
		System.out.println(s);//ABCD
	}
	
	public static String strToUpp(String str,Function<String, String> f) {
		return f.apply(str);
	}
	
	/**
	 * JDK1.8新的迭代方法
	 */
	private static void foreach() {
		List<String> list = new ArrayList<>();
		list.add("tom");
		list.add("jack");
		list.add("job");
		list.add("lily");
		
		//Consumer
		list.forEach((String s )->{System.out.println(s);});
		//list.forEach(System.out::println); 双冒号表示调用
	}
	
	private static void enumration() {
		Vector<String> vs = new Vector<>();
		vs.add("tom");
		vs.add("jack");
		vs.add("job");
		vs.add("lily");
		
		Enumeration<String> es = vs.elements();
		while (es.hasMoreElements()) {
			System.out.println(es.nextElement());		
		}
	}
	
	//foreach(1.5后)
	private static void foreach(Collection<Cat> c) {
		for (Cat cat : c) {
			System.out.println(cat);
		}
	}
	
	//iterator(1.5之前统一的迭代集合方式)
	private static void iterator(Collection<Cat> c) {
		Iterator<Cat> it = c.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			
		}
	}
	
	
	public static void main(String[] args) {
		List<Cat> list = new ArrayList<>();
		Cat c1 = new Cat("小白", 5, 1);
		Cat c2 = new Cat("小花", 2, 2);
		Cat c3 = new Cat("小兰", 2, 3);
		Cat c4 = new Cat("小黑", 5, 1);
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		//foreach(list);
		//iterator(list);
		//enumration();
		//foreach();
		//functionTest();
		//supplierTest();
		predicateTest();
	}

}
