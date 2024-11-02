import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * 集合的输出(迭代)
 * @author Administrator
 *
 */
public class IteratorDemo {

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
		enumration();
	}

}
