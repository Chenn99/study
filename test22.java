package study;

/**
 *	方法(函数)
 */
public class test22 {
	public static void main(String [] args) {
		
		getMenu(); // 调用方法,此时方法才能被运行
	}
	// public 访问权限修饰符
	// static 静态修饰符,描述的方法可以直接调用
	// void 返回值(无返回值)
	// getMenu 方法名
	// 定义一个方法,在没有调用时是不会运行
	public static void getMenu() {
		System.out.println("------菜单-------");
		System.out.println("1.宫保鸡丁 22");
		System.out.println("2.韭菜鸡蛋 20");
		System.out.println("3.红烧狮子头 26");
		System.out.println("4.滋补牛尾汤 38");
		System.out.println("5.番茄炒鸡蛋 39");
	}
}