package study;
/*
 * 构造方法(构造器):构造方法是在类中定义的,构造方法的定义格式:方法名称与类名称相同,无返回值类型的声明
 * 1.构造方法就是类构造对象时调用的方法,用于对象的初始化工作
 * 2.构造方法是实例化一个类的对象时,也就是new的时候,最先调用的方法
 */
public class test47 {
	public static void main(String [] args) {
		
		Cat cat = new Cat();
		Cat cat2 = new Cat("wangwang",2);
	}
}

class Cat{
	
	//默认构造方法,通常有其他构造方法时,要保留默认构造方法
	private String name; //成员变量
	private int age; //成员变量

	//默认构造方法
	public Cat() {
		//System.out.println("构造方法执行了");
	}
	
	public Cat(String name) { //带一个参数的构造方法
		this.name = name;
		System.out.println("带一个参数的构造方法执行");
	}
	
	//构造方法重载
	public Cat(String name,int age) { //带两个参数的构造方法
		//下面这句是指方法之间的相互调用,调用只带一个参数的Cat方法
		this(name); //调用其他构造方法时,此语句需要在第一句,在构造方法相互调用时必须要有出口
		//this.name = name;
		this.age = age;
		System.out.println("带两个参数的构造方法执行");
	}



}