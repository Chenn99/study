package study;

/**
 *	for循环
 */
import java.util.Scanner;
public class test24 {
	public static void main(String [] args) {
		
		// 用来控制外层行数
//		for (int j = 1; j <= 9; j++) {
			// 用来控制一行从0到9的数字
//			for (int i = 0; i <= 9; i++) {
				// 数字输出 间有间距的输出
//				System.out.print(i+ " ");
//			}
			// 换行
//			System.out.println();
//		}
		
		// 题目描述: 使用 for 循环打印从1到10的数字，每个数字单独占一行。
//		for (int i = 1; i <= 10; i++) {
//			//控制换行
//			System.out.println(i);
//		}
		
		//使用 for 循环打印从1到20之间的所有偶数，每个偶数单独占一行。
		for (int i = 0; i < 20; i++) {
			//是否能被2整除,判断为偶数
			if (i%2==0) {
				System.out.println(i);
			}
		}
	}
}