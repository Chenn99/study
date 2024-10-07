package com.vince;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo {

	public static void main(String[] args) {

//		IEat iEat = new IEatImpl();
//		iEat.eat();
//	
//		IEat iEat2 = new IEat() {
//			
//			@Override
//			public void eat() {
//				System.out.println("eat bnana");
//			}
//		};
//		iEat2.eat();
		
		
		//lambda表达式
		//好处:1.代码更简洁,2.不会单独生成class文件
//		IEat iEat3 = () -> {System.out.println("eat grape");};
		
		//没有参数时使用
//		IEat iEat3 = () -> System.out.println("eat grape");
//		iEat3.eat();
		
		//带参数时使用,参数的类型可以省略
//		IEat iEat3 = (thing,name) -> System.out.println("eat..."+thing+name);
//		iEat3.eat("apple","苹果");
		
		//带参数时使用,参数的类型可以省略,代码块中有多行代码
//		IEat iEat3 = (thing,name) -> {
//			System.out.println("eat..."+thing);
//			System.out.println(name);
//		};
//		iEat3.eat("apple","苹果");
		
		//带返回值的方法
//		IEat ieat3 = (thing,name)->{
//			System.out.println(name+"eat"+thing);
//			return 10;
//		};
//		ieat3.eat("苹果", "小白");
		
		//带返回值的方法中只有一句实现代码
		IEat ieat3 = (thing,name)->10; //(表达式,可以不带return)
		//IEat ieat3 = (final String thing,final String name)->10; //(如果要给参数加上修饰符的话,必须要把参数的类型加上)
		//IEat ieat3 = (thing,name)-> thing == null?1:0; //(三目运算表达式,可以不带return)
		ieat3.eat("苹果", "小白");
		
		Student[] students = {
				new Student("张三",18),
				new Student("李四",28),
				new Student("张一",13)};
		Arrays.sort(students,new Comparator<Student>() {
			public int compare(Student o1,Student o2) {
				return o1.getAge() - o2.getAge();
			};
		});
		
		//Comparator<Student> c = (o1,o2)->o1.getAge()-o2.getAge();
		Arrays.sort(students,(o1,o2)->o1.getAge()-o2.getAge());
		System.out.println(Arrays.toString(students));
		//[Student [name=张一, age=13], Student [name=张三, age=18], Student [name=李四, age=28]]
	}
}

//只有一个抽象方法的接口
interface IEat{
	public int eat(final String thing,final String name);
	public default void print() {
		System.out.println("print test"); //默认方法
	}
	public static void method() {
		System.out.println("static method..."); //静态方法
	}
 }

//class IEatImpl implements IEat{
//	public void eat(String thing) {
//		System.out.println("eat--"+thing);
//	}
//}
