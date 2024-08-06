package study;

import java.util.Scanner;

/**
 * if分支嵌套语句
 * @author min
 *
 */
public class test11 {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
//		System.out.println("请输一个数字: ");
//		int score = input.nextInt();
//		if (score >= 90) {  // 判断逻辑从大往小的判断
//			System.out.println("A");
//		}else if (score <=89 && score >= 80) {
//			System.out.println("B");
//		}else if (score <80 && score >= 70) {
//			System.out.println("C");
//		}else if (score <70 && score >= 60) {
//			System.out.println("D");
//		}else if (score < 60) {
//			System.out.println("E");
//		}
		
		//输入两个数 打印出它们 的大小关系,是小于,大于还是等于?
		System.out.println("请输第一个数字: ");
		int a = input.nextInt();
		System.out.println("请输入第二个数字: ");
		int b = input.nextInt();
		if (a>b) {
			System.out.println("数字"+a+"大于数字"+b);
		}else if (a==b) {
			System.out.println("数字"+a+"等于数字"+b);
		}else {
			System.out.println("数字"+a+"小于数字"+b);
		}
	}	
}
