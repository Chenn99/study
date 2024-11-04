import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream 接口:
 * 不是存储数据结构,数据源可以是一个集合,为了函数式编程创造,
 * 惰式执行,数据只能被消费一次
 * 
 * 两种类型的操作方法:
 * 1.中间操作(生成一个Stream)
 * 2.结束操作(执行计算操作)
 * @author Administrator
 *
 */
public class StreamDemo {

	
	public static void main(String[] args) {
		
		//foreach方法
		Stream<String> st = Stream.of("good","good","study","day","day","up");
		//st.forEach((str)->{System.out.println(str);});
		//st.forEach(System.out::println);
		
		//filter
		//st.filter((s)->s.length()>3).forEach(System.out::println);
		
		//distinct 去除重复
		//st.distinct().forEach(System.out::println);
		//st.distinct().forEach(s->System.out.println(s));
		
		//map 映射关系
		//st.map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//flatMap
//		Stream<List<Integer>> ss = Stream.of(Arrays.asList(1,2,3),Arrays.asList(4,5));//两个集合
//		ss.flatMap(list->list.stream()).forEach(System.out::println);
		
		//reduce
//		Optional<String> opt = st.reduce((s1,s2)->s1.length()>=s2.length()?s1:s2);
//		System.out.println(opt.get()); //查找出最长的单词 study
		
		//collect
		List<String> list = st.collect(Collectors.toList());
		list.forEach(s->System.out.println(s));
		
		//::方法的引用
		//引用静态方法     Interger::valueOf
		//引用对象的方法    list::add
		//引用 构造方法     ArrayList::new
		
	}
}
