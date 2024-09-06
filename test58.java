package study;
/**
 * 	final关键字 :表示最终的,声明的属性值不能改,声明的方法不能被子类重写,声明的类无法被继承(扩展)
 * 	1.使用final声明一个属性,就是常量,常量的命名规则建议使用全大写,常量必须在定义时或在构造器中初始化
 * 	2.使用final声明的方法,不能被子类重写,只能被继承
 * 	3.使用final关键字声明一个类,该类就转变为最终类,没有子类的类,final修饰的类无法被继承
 */
public class test58 {
	//定义常量
	//如果想要公共访问 就用 public
//	public static final int PERSON_NUM = 10;
	//如果想要私有访问 就用 private
	//private static final 都是修饰符,在java里对它们的位置没有限制
	//private static final int PERSON_NUM = 10;
	public static void main(String [] args) {
		
		System.out.println(Constant.PERSON_NUM);//用类直接访问

	}
	
//常量类(工具类):在实际项目开发中,常量类通常用于定义项目中一些公共的,不变的,数据
	
final class Constant {
	public static final int PERSON_NUM = 10; //人数
	public static final String SERVER_ROOT_URL  = "http://www.123.com"; 
	public static final String CACHE_PATH = "data_cache"; 
}

class FinalClass{
	//要么在定义时初始化赋值
	public final int DAY_NUMBER; //工作天数
	//要么在构造器中初始化赋值
	public FinalClass() {
		DAY_NUMBER = 22;
	}
	
	public final void print() {
		System.out.println("我是final方法");
	}
	
//	public void setLength(final int size) {
//		final int x = 20;
//		//size++;
//		//System.out.println(size);
//	}
}

class SubClass extends FinalClass{
//	public void print() {
//		System.out.println("我是final方法");
//	}
}
}
