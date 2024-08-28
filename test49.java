package study;

//示例一：值传递
//public class test49 {
//	public static void main(String [] args) {
//		int x = 10; //基本数据类型变量（局部变量） 存储在栈里面
//		method(x);
//		System.out.println("x="+x);
//	}
//	
//	public static void method(int mx) {
//		mx = 20;
//	}
//}

//示例二：引用传递
//public class test49 {
//	public static void main(String [] args) {
//
//		Duck d = new Duck();
//		method(d);
//		System.out.println("Duck age="+d.age);
//	}
//	
//	public static void method(Duck duck) {
//		duck.age = 5;
//	}
//}
//
//class Duck{
//	int age = 2; //省略封装
//}


//示例三：String传递
//字符串本身就是一个对象
//public class test49 {
//	public static void main(String [] args) {
//		
//		String name = "小飞";
//		method(name);
//		System.out.println("name="+name);
//	}
//	
//	public static void method(String  sname) {
//		sname = "小贝"; 
//	}
//}

//示例四：String传递
public class test49 {
	public static void main(String [] args) {
		MyPerson p = new MyPerson();
		method(p);
		System.out.println("person name="+p.name);
	}
	
	public static void method(MyPerson  per) {
		per.name = "贝贝"; 
	}
}

class MyPerson{
	String name = "飞飞"; //省略封装
	
}
