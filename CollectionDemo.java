import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionDemo {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("lily");
		list.add("tom");
		list.add("louis");
		list.add("louis");
		
		//Collections.reverse(list);//反转  [louis, tom, lily]
		//Collections.shuffle(list); //打乱[tom, louis, lily] 
		//Collections.sort(list); //根据首字母排序  [lily, louis, tom]
		//Collections.swap(list, 0, 2); //位置交换  [louis, tom, lily]
		//Collections.rotate(list,1); //转一圈 [louis, lily, tom]
		
		//查找
//		System.out.println(Collections.binarySearch(list, "tom"));
//		1
//		[lily, tom, louis]
		
//		System.out.println(Collections.max(list)); // 按照首字母排最大 tom
//		System.out.println(Collections.min(list)); // lily
		
//		Collections.fill(list, "ben"); // 填充  [ben, ben, ben]
		
		//求这个集合中某个值出现的次数 
//		System.out.println(Collections.frequency(list, "louis")); 
//		2
//		[lily, tom, louis, louis]
		
		//替换
//		Collections.replaceAll(list, "louis", "ben"); //[lily, tom, ben, ben]
		
		//线程安全的
	//	List<String> list2 = Collections.synchronizedList(new ArrayList<String>());
		
	//	List<String> list3 = Collections.emptyList();
	//	list3.add("bin");  java.lang.UnsupportedOperationException
		
		Collections.sort(list,Collections.reverseOrder()); //排完序以后反转 [tom, louis, louis, lily]
		System.out.println(list);//list数组里已经实现了toString方法
		
//		List<String> li = query();
//		li.size(); //0
	}
	
//	public static List<String> query(){
//		List<String> list = null;
//		
//		return Collections.emptyList();
//	}
}