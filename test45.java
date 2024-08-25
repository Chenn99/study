package study;
/*
 * 面向过程:以步骤为单位,一步一步完成某一个具体事情
 * 面向对象:以对象为单位,通过调度组合不同的对象来完成某一个事情
 */
public class test45 {
	public static void main(String [] args) {
		
		//int i = 0;  这是声明一个基本数据类型
		Horse h = null; //声明一个类的变量(除了八种基本数据类型以外,都是引用数据类型,包括数组)
		
		//创建一个Horse类型的对象,实例对象
		h = new Horse();
		//有了对象,我们就可以调用对象的属性和方法
		h.name = "赤兔马";
		h.age = 350;
		
		h.run(); //调用方法,那么方法就会被执行。
		h.eat(); //调用方法,那么方法就会被执行。
		
		//匿名对象:只能使用一次，用完后，该对象就会被释放
		new Horse().eat();
		
		h = null; //把对象释放
		//h.eat(); //当对象不存在时，调用该对象的属性和方法将报错（空指针）
		
	}
}

//定义一个类(类型)
class Horse{
	//在类中定义属性(特征)
	String name;  //字符串是引用类型变量，不是基本数据类型变量
	int age;
	public void run() {
		System.out.println("我是" + name + ",我" + age + "岁了,我还能日行千里。");
	}
	public void eat() {
		System.out.println("我吃仙草，还吃的很多");
	}
}