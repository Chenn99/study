package study;
/**
 * 多态性:
 */
public class test61 {
	public static void main(String[] args) {
		//用父类的引用指向子类对象(用大的类型来表示小的类型)
		Chickenn hc = new HomeChicken("小白");
//		hc.eat();
		Chickenn yc = new YeChicken("小黑");
//		yc.eat();
		Chickenn jc = new JianJiaoChicken("尖叫鸡");
		
//		hc = yc;
//		hc.eat();
		eat(hc);
		eat(yc);
		eat(jc);
	}
	//抽象(粒度) 面向抽象编程(面向接口编程)
	public static void eat(Chickenn c) {
		System.out.println("鸡吃饭");
		c.eat();
	}
}

//鸡
abstract class Chickenn{
	private String name;
	public Chickenn() {}
	public Chickenn(String name) {
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}	
	//抽象方法
	public abstract void eat();
}

//家鸡
class HomeChicken extends Chickenn{
	public HomeChicken(String name) { //调用父类的构造方法
		super(name);
	}
	public void eat() { //实现父类的抽象方法
		System.out.println(this.getName() + ",我爱吃米");
	}
}

//野鸡
class YeChicken extends Chickenn{
	public YeChicken(String name) { //调用父类的构造方法
		super(name);
	}
	public void eat() { //实现父类的抽象方法
		System.out.println(this.getName() + ",我爱吃虫子");
	}
}

class JianJiaoChicken extends Chickenn{
	public JianJiaoChicken(String name) { //调用父类的构造方法
		super(name);
	}
	public void eat() { //实现父类的抽象方法
		System.out.println(this.getName() + ",我不吃东西");
	}
}