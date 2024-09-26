package com.vince;

/**
 * 
 * @author Administrator
 * String 表示一个字符串,内部使用字符数组实现,不能被继承(最终类),不可变
 */
public class StringDemo {
	
	public static void main(String[] args) {
		
		//String 的两种赋值方式,JAVA推荐使用第一种赋值方式
		
		//1直接赋值
		String s1 = "小白";
		//2使用new关键字创建对象
		//面试题:问以下代码创建了几个对象? 答:2个 
		String s2 = new String("小白"); //现在常量池里找是否有该对象没有就创建一个放在常量池,再用new操作符在堆里创建一个内存对象
		
		String s3 = "小白";
		
		System.out.println(s1==s2); 
		//这是在比较两个对象的地址是否一致 false
		//如果用.equals方法是在比较字符串值,返回true
		
		System.out.println(s1==s3); //true,这是同一个对象
		System.out.println("-------------------------");
		
		//代码示例:4种情况分析;直接赋值字符串连接时,考虑编译期和运行期
		//如果在编译期值 可以被确定,那么就使用已有的对象,否则会创建新的对象
		String a = "a";
		String a1 = a+1; //编译期不能被确定,因为a会被识别成变量,运行期才能被识别
		String a2 = "a1"; //编译期可以被确定
		System.out.println(a1==a2); //false
		
		final String b = "b"; //常量池
		String b1 = b+"1"; //编译期b1的值可以被确定,两个常量相加,运行期把b1先放在常量池
		String b2 = "b1"; //地址指向常量池里即存的b1,从常量池里取
		System.out.println(b1==b2); //true 都指向常量池里的b1 为同一个地址一个对象
		
		String c = getC(); //通过方法返回的值,方法在运行期才会得到结果,编译期不可被确定
		String c1 = c+1;//编译期不可被确定
		String c2 = "c1"; //编译期可以确定
		System.out.println(c1==c2); //false
		
		final String d = getD(); //方法运行期才能得到结果
		String d1 = d+1; //相当于new一个对象,在堆中创建对象
		String d2 = "d1";
		System.out.println(d1==d2);//false
	}
	
	private static String getC() {
		return "c";
	}
	
	private static String getD() {
		return "d";
	}
}