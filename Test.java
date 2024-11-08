package iterator;

import java.util.Iterator;

public class Test {

	public static void main(String[] args) {

		MyList list = new ConcreteAggregate();
		list.add("张飞");
		list.add("刘备");
		list.add("关羽");
		list.add("曹操");
		list.add("诸葛亮");
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
//			张飞
//			刘备
//			关羽
//			曹操
//			诸葛亮
		}
		
	}

}
