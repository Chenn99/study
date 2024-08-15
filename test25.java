package study;

/**
 * 方法（函数）
 * 方法的返回值:判断任意给定的年份是否是闰年
 * 方法要么没有返回值，要么只有一个返回值！！
 */
public class test25 {
	public static void main(String [] args) {
		
		//调用方法
		//有返回值的需要有个东西来装下面方法传回的返回值，根据类型不同接收
		boolean a = isRunNian(2017); //这里的2017为实参
		if (a) {
			System.out.println("闰年");
		}else {
			System.out.println("平年");
		}
		
		print(); //没有返回值的直接调用方法
		
	}
	
	public static boolean isRunNian(int year) { //参数就是年份，int year为形参
		if (year%4 == 0 && year%100 != 0 || year%400 == 0) {
			return true; //return返回值类型一定是和声明的返回值类型相同
		}else {
			return false; //可以有多个return，必须只会执行一个
		}
	}
	
	public static void print() {
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				return; //表示方法结束，结束这个方法
			}
			System.out.println(i);
		}
	}
}