package study;

/**
 * 根据天数(46)计算周数和剩余的天数,天数是通过键盘输入
 * @author min
 *
 */
import java.util.Scanner;

public class test6 {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入天数: ");
		int day = input.nextInt();
		System.out.println("周数是:" + (day/7));
		System.out.println("剩余的天数:" + (day%7));
		//输出结果:
		//请输入天数: 
		//46
		//周数是:6
		//剩余的天数:4
		
	}
}
