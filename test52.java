package study;

/**
 * 构造器练习(constructor)
 */
public class test52 {
	public static void main(String [] args) {
		
		Person1 person1 = new Person1(); //无参构造
		System.out.println("p1的age="+person1.age+"p1的name="+person1.name);
		Person1 person2 = new Person1("kk",20); //有参构造
		System.out.println("p1的age="+person2.age+"p1的name="+person2.name);
	}
}

class Person1{
	String name; //默认值 null
	int age; //默认值 0
	public Person1() {
		age = 18;
	}
	public Person1(String pName,int pAge) {
		name = pName;
		age = pAge;
	}
}