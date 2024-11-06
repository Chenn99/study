import java.util.Optional;

/**
 * Optional JDK1.8容器类
 * @author Administrator
 *
 */
public class OptionalDemo {

	public static void main(String[] args) {
		//创建Optional对象的方式
		Optional<String> optional = Optional.of("bin");
//		Optional<String> optional2 = optional.ofNullable("bin");
		Optional<String> optional3 = optional.empty();
//		System.out.println(optional2.isPresent()); //true
//		System.out.println(optional3);
		
		System.out.println(optional.get()); //bin
		//判断的一个方法
		optional.ifPresent((value)->System.out.println(value)); //bin
		
		System.out.println(optional.orElse(null)); //bin
		System.out.println(optional3.orElse(null)); //null
	
		System.out.println(optional.orElseGet(()-> "default"));//bin
		System.out.println(optional3.orElse(null)); //null
		
		//抛出异常的方法
//		try {
//			optional3.orElseThrow(Exception::new);  自定义异常
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		Optional<String> optional5 = optional.map((value)-> value.toUpperCase()); //转大写
		System.out.println(optional5.orElse("not found")); //BIN
		
		Optional<String> optional6 = optional.flatMap((value)->Optional.of(value.toUpperCase()));
		System.out.println(optional6.orElse("not found")); //BIN
		
		Optional<String> optional7 = optional.filter((value)->value.length()>3);
		System.out.println(optional7.orElse("这个长度小于3")); //这个长度小于3
	}
}