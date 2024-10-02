package com.vince;
/**
 * 
 * 对象需要具备克隆功能
 * 1.实现Cloneable接口,(标记接口)
 * 2.重写Obeject类中的Clone方法
 * @author Administrator
 *
 */
public class Cat implements Cloneable{

	private String name;
	private int age;
	
	
	public Cat() {
		super();
	}
	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}
	
	//重写Object中的clone方法
	@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
}
