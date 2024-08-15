package study;

/**
 * 方法（函数）:根据传入的参数数量打印直角三角形
 */
import java.util.Scanner;
public class test26 {
	public static void main(String [] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("请输入三角形的行数: ");
		int num = input.nextInt(); //用一个变量来接收这个调用方法的值
		printTriangle(num); // 因为下面这个方法没有返回值在这里直接调用就可以了
	}
	
	public static void printTriangle(int line) {
		//外循环控制行数
		for (int i = 1; i <= line; i++) {
			
			//内循环控制空格
			for (int j = i; j < line; j++) {
				System.out.print(" "); 
			}
			//内循环控制*
			for (int j = 1; j <= i*2-1; j++) {
				System.out.print("*");
			}
			System.out.println();  //换行
		}
	}
}