package study;

/**
 * 方法（函数）
 * 方法的重载：在同一个类中，方法名相同，参数列表不同，返回值不能作为重载的条件
 * overloading method
 */
public class test27 {
	public static void main(String [] args) {
		
		int ret = add(10, 20); //在这里用相同类型定义一个变量来接受return出来的返回值
		System.out.println(ret);
	}
	
	public static int add(int a,int b) { //方法名可以相同，参数列表不同
		return a+b;  
		//这里因为是个有返回值的方法所以需要把返回值return出去
	}
	
	public static float add(float a,float b) {
		return a+b;
		//根据不同类型的参数可以写多个相同的add方法
	}
	
	public static float add(int a,float b) {
		return a+b;
	}
}