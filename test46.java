package study;
/*
 * 封装性
 * 如果属性没有封装，那么在本类之外创建对象后，可以直接访问属性
 * private关键字：访问权限修饰符，public表示公有的，private表示私有的，私有的属性和方法，只能在本类中访问
 * 公有的属性和方法，可以被类外部的其他类访问，想要在类外部访问私有属性，我们需要提供公有的方法来间接访问
 * 通常在一个类中，属性都私有化，并对外提供getter and setter方法
 */
public class test46 {
	public static void main(String [] args) {
		
		Person p1 = new Person();
		//p1.name = "菲菲";
		//p1.age = 18;
		
		p1.setName("菲菲");
		p1.setAge(18);
		
		p1.run(8);
		
		p1 = null; //这里可以完成对象的销毁，释放这个内存
	}
}

//没有封装之前
class Person{
	//属性的封装
	private String name;  //成员变量，在类中定义
	private int age;	//成员变量，在类中定义
	
	//getter and setter
	
	//对外提供一个为name属性设置的方法
	public void setName(String name) {
		this.name = name; 
	}
	
	//对外提供一个获取name属性的方法
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void run(int len) { //此处参数也是局部变量
		int m = len; //m也是局部变量
		System.out.println("我跑了"+m+"米");
	}
}
