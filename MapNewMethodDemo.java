import java.util.HashMap;
import java.util.Map;

public class MapNewMethodDemo {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "jack");
		map.put(2, "tom");
		map.put(3, "lily");
		
		String value = map.getOrDefault(4, null);
		System.out.println(value); //null
		
//		String s = map.get(5);
//		if (s==null) {
//			System.out.println();
//		}else {
//			
//		}
		
//		String val = map.put(3,"ben"); //lily
//		System.out.println(val);
//		map.forEach((k,v)->System.out.println(k+"->"+v));
		
		//只会添加不存在相同key的值
//		String val2 = map.putIfAbsent(3, "luna");
//		System.out.println(val2);
		
		//根据键和值都匹配时才删除
//		map.remove(1,"vince");
//		map.forEach((k,v)->System.out.println(k+"->"+v));
//		1->jack
//		2->tom
//		3->lily
		
//		map.remove(1,"jack");
//		map.forEach((k,v)->System.out.println(k+"->"+v));
//		2->tom
//		3->lily
		
		//替换
//		map.replace(3, "vince");
//		map.replace(3, "lily","vince");
		
		//map.compute(1,(k,v1)->v1+"1"); //1->jack1
		//map.computeIfAbsent(5,(val)-> val+"test"); //为空的话  打印出来是 5->5test
		
		//合并
		//map.merge(1,"888", (oldVal,newVal)-> oldVal.concat(newVal));//1->jack888
		map.merge(5,"888", (oldVal,newVal)-> oldVal.concat(newVal));//为空的话  打印出来是 5->888
		map.forEach((k,v)->System.out.println(k+"->"+v));
		
	}
}
