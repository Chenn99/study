package iterator;

import java.util.Iterator;

import java.util.List;

/**
 * 迭代器接口的具体实现类
 * @author Administrator
 *
 */
public class ConcreteIterator implements Iterator{

	private MyList list = null;
	private int index;//迭代器的下标，指针
	public ConcreteIterator(MyList list) {
		this.list = list;
	}
	@Override
	public boolean hasNext() {
		if (index>=list.getSize()) 
			return false;
		else return true;
	}
	@Override
	public Object next() {
		Object obj = list.get(index);
		index++;
		return obj;
	}
	

}
