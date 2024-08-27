package study;
/*
 *this关键?
 *调用类中的属性
 *调用类中的方法或构造方法
 *表示当前对象:在方法被调用的过程中，哪个对象调用了方法，在方法内的this就表示谁
 *类名.this
 */
public class test48 {
	public static void main(String [] args) {
		
		Dog dog = new Dog(); //创建了一个新的对象
		dog.setName("咪咪");
		dog.setAge(5);
		
		dog.eat(); //输出：我是咪咪,我爱吃鱼。
	}
}

class Dog {
	private String name;
	private int age;
	
	public void setName(String name) { //name = 咪咪 传参
		this.name = name; //this 代表的是当前对象
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void eat(){
		//在方法中使用this调用类中的其他方法或属性，this可以省略,this前面可以使用当前的类名.this  Dog.this.getName()
		//在后面的内部类知识点中会涉及到
		System.out.println("我是" +this.getName() + ",我爱吃鱼。");
		//System.out.println("我是" +this.name() + ",我爱吃鱼。");
	}
}	



