package study;

/**
 * 方法重载使用场景
 * 对于功能类似的方法来说，因为参数列表不一样，却需要记住那么多不同的方法名称，太麻烦。
 * 方法的重载：多个方法的名称一样，但是参数列表不一样。
 */
public class test35 {
	public static void main(String [] args) {
		
		System.out.println(sum(10, 20)); //两个参数的方法
		System.out.println(sum(10, 20, 30)); //三个参数的方法
		System.out.println(sum(10, 20, 30, 40)); //四个参数的方法
		//System.out.println(sum(10, 20, 30, 40, 50)); //找不到方法来匹配
		
	}
	
	//两个数字相加
	public static int sum(int a,int b) {
		System.out.println("有2个参数的方法执行！");
		return a+b;
	}
	
	//三个数字相加
	public static int sum(int a,int b,int c) {
		System.out.println("有3个参数的方法执行！");
		return a+b+c;
	}
		
	//四个数字相加
	public static int sum(int a,int b,int c,int d) {
		System.out.println("有4个参数的方法执行！");
		return a+b+c+d;
	}
}
