package study;

import java.util.Scanner;

/**
 * 通过键盘输入，初始化两个数将这两个数据交换位置后，输出显示交换后的数据
 * @author min
 *
 */
public class test8 {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
//		System.out.println("请输入第一个数");
//		int a = input.nextInt();
//		System.out.println("请输入第二个数");
//		int b = input.nextInt();
		
		//1)通过第三个变量来交换
//		int c = a;
//		a = b;
//		b = c;
//		System.out.println("a = " + a +",b =" + b);
		//输出结果如下
		//请输入第一个数
		//10
		//请输入第二个数
		//20
		//a = 20,b =10
		
		//2)不通过第三个变量如何来交换两个数？
		//① a=1 b=2   通过表达式
//		a = a+b-(b=a);
//		System.out.println("a = " + a +",b =" + b);
		
		//② a=1 b=2   通过＋‐计算
		int a = 1;
		int b = 2;
//		a = a+b;
//		b = a-b;
//		a = a-b;
//		System.out.println("a = " + a +",b =" + b);
		
		//③ a=1 b=2   通过异或  两个数交换位置最快的方法(使用异或 的位运算)
		a = a^b; //注意:不能拿两个相同的值去异或
		b = a^b; 
		a = a^b; 
		System.out.println("a = " + a +",b =" + b);
		
	}	
}
