package iterator;

import java.util.Iterator;
/**
 * 容器接口的具体实现类
 * @author Administrator
 *
 */
public class ConcreteAggregate implements MyList{

	private Object[] elements;//对象数组
	private int size;
	private int index;
	public ConcreteAggregate() {
		elements = new Object[100];
	}
	
	public void add(Object e) {
		elements[index++] = e;
		size++;
	}
	
	public Object get(int index) {
		return elements[index];
	}
	
	public Iterator iterator() {
		return new ConcreteIterator(this);
	}
	
	public int getSize() {
		return size;
	}
}
