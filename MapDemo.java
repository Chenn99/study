import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Map接口
 * 1.键值对存储一组对象
 * 2.Key不能重复(唯一),Value可以重复
 * 3.具体的实现类:HashMap,TreeMap,Hashtable,LinkedHashMap
 * @author Administrator
 *
 */
public class MapDemo {

	/**
	 * HashMap的现实原理:
	 * 1.基于哈希表(数组+链表+二叉树(红黑树)) 1.8JDK
	 * 2.加载因子为0.75,默认数组大小是16
	 * 3.把对象存储到哈希表中,如何存储?
	 * 把key对象通过hash()方法计算hash值,然后用这个hash值对数组长度取余数(默认16),
	 * 来决定该对Key对象在数组中存储的位置,当这个位置有多个对象时,以链表结构存储,JDK1.8后,
	 * 当链表长度大于8时,链表将转换为红黑树结构存储.
	 * 这样的目的,是为了取值更快,存储的数据量越大,性能的表现越明显
	 * 4.扩充原理:当数组的容量超过了75%,那么表示该数组需要进行扩充,如何扩充?
	 * 扩充的算法是:当前数组容量左移一位<<1 (相当于是乘以2),扩大一倍,扩充次数过多,会影响性能,每次扩充表示hash表
	 * 重新散列(重新结算每个对象的存储位置),我们在开发中尽量要减少扩充次数带来的性能问题.
	 * 5.线程不安全,适合在单线程中使用
	 */
	private static void hashMap() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Tom");
		map.put(2, "Jack");
		map.put(3, "Vince");
		map.put(4, "Bin");
		map.put(5, "Lily");
		System.out.println("size="+map.size());
		//从MAP中取值
		System.out.println(map.get(1)); //通过key取value
		
		//map的遍历1  遍历Entry 键,值
//		Set<Entry<Integer, String>> entrySet = map.entrySet();	
//		for (Entry<Integer, String> e : entrySet) {
//			System.out.println(((Entry<Integer, String>) e).getKey()+"->"+e.getValue());
//		}
		
		//2 遍历键
//		Set<Integer> keys = map.keySet();
//		for (Integer i : keys) {
//			String value = map.get(i);
//			System.out.println(i+"->"+value);
//		}
		
		//3 遍历值
//		Collection<String> val = map.values();
//		for (String v : val) {
//			System.out.println(v);
//		}
//		
//		System.out.println("-------------------");
		//4 forEach
//		map.forEach((key,value) ->System.out.println(key+"->"+value));
//		
//		System.out.println(map.containsKey(7));
		
		//hash
		Integer key = 1434;
		//System.out.println(key.hashCode()); //1434
		System.out.println(1434 % 16);
		
	}
	
	public static void main(String[] args) {
		hashMap();
	}

}
