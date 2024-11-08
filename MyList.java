package iterator;
import java.util.Iterator;
/**
 * 容器的接口
 * @author Administrator
 *
 */
public interface MyList {
	void add(Object e);
	Object get(int index);
	Iterator iterator();
	int getSize();
	
}