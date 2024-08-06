package study;

import java.util.Scanner;

/**
 * if分支嵌套语句
 * @author min
 *
 */
public class test10 {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("今天天气如何(1好,2霾): ");
		int weather = input.nextInt();
		
		if (weather == 1) {
			System.out.println("今天天气太好了,我是逛街还是逛公园(1逛街,2逛公园):");
			int flag = input.nextInt();
			if (flag == 1) {
				System.out.println("今天天气太好了,我选择逛街");
			}else if (flag == 2) {
				System.out.println("今天天气太好了,我选择去公园");
			}
		}else if (weather == 2) {
			System.out.println("今天天气太好了,我是在家看电影还是玩游戏(1看电影,2玩游戏)");
			int flag = input.nextInt();
			if (flag == 1) {
				System.out.println("今天天气太好了,我在家看电影");
			}else if (flag == 2) {
				System.out.println("今天天气太好了,我在家玩游戏");
			}
		}
	}	
}
