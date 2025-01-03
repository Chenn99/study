package study;

/**
 * 单例设计模式:保证一个类仅有一个实例,并提供一个访问它的全局访问点
 * 1.构造方法私有化
 * 2.声明一个本类对象
 * 3.给外部提供一个静态方法获取对象实例
 * 
 * 1.懒汉式:在第一次调用getInstance方法时,对象被创建,到结束程序后释放
 * 2.饿汉式:在类被加载后,对象被创建,到程序结束后释放
 * 
 * 在项目中为什么要使用单例,单例有什么好处?
 * 1.在设计一些工具类的时候(通常工具类,只有功能方法,没有属性)
 * 2.工具类可能会被频繁调用
 * 
 * 目的是为了节省重复创建对象所带来的内存消耗,从而提高效率
 * 
 * 能不能使用构造方法私有化+静态方法来替代单例?
 */
public class test54 {
	public static void main(String [] args) {
		Singleton2 s = Singleton2.getInstance();
		s.print();
		
		Singleton2 s2 = Singleton2.getInstance();
		s2.print();
		
		System.out.println(s==s2); //比较的是内存地址是否相同
		
	}
}

//使用构造方法私有化+静态方法来实现工具类,比如Max
class Tools{
	private Tools() {}
	public static void print1() {
		
	}
	public static void print2() {
		
	}
}

//饿汉式:占用内存的时间长,提高效率
class Singleton1{
	private Singleton1() {}
	//静态的  只存一份
	private static Singleton1 s = new Singleton1();
	public static Singleton1 getInstance() {
		return s;
	}

	public void print() {
		System.out.println("测试方法");
	}
	
}
//懒汉式:占用内存的时间短,效率低(懒加载,延迟加载)
//在多线程访问时会有安全问题
class Singleton2{
	private Singleton2() {}
	private static Singleton2 s;//还没创建对象
	public static Singleton2 getInstance() {
		if (s==null) {
			s = new Singleton2(); //在这里做个判断再创建对象
		}
		return s;
	}

	public void print() {
		System.out.println("测试方法2");
	}
}