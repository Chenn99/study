package study;

import java.util.Scanner;

/**
 * if分支语句
 * 1.输入一个字符,判断是大写字母还是小写字母,输出提示信息
 * @author min
 *
 */
public class test9 {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个数字: ");
		int c = input.nextInt();
		if (c >= 65 && c<= 90) { // 采用ascii码
			System.out.println("这是一个大写字母: "+(char)c);
		}else {
			System.out.println("这是一个小写字母: "+(char)c); //(char)c)强制类型转换
		}
		
		//输出:
		//请输入一个字母: 
		//	65
		//	这是一个大写字母: A
		
		//写一个程序,判断某一年是否为闰年(被4整除但不能被100整除能被400整除)是闰年否则是平年
		System.out.println("请输入一个年份: ");
		int year =input.nextInt();
		if ((year%4==0 && year%100!=0) || year%400==0) {
			System.out.println("这是个闰年");
		}else {
			System.out.println("这是个平年");
		}
		
		
		
	}	
	
	
//	Scanner input = new Scanner (System.in);
//	System.out.println("请输入一个字母: ");
//    int age = Integer.parseInt(input.nextLine());
//    if (age < 50){
//        System.out.println("You are young");
//    }else{
//        System.out.println("You are old");
//    }
	
}
