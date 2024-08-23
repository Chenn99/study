package study;
import java.util.Random;
/*
 * 模拟双色球综合案例
 * 1.用户选择是机选还是手选号码
 * 2.接收用户选号(6红,1蓝)
 * 3.生成系统选号(6红,1蓝)
 * 4.比较系统号码和用户号码,记录个数
 * 5.验证是否中奖
 * 6.系统号码排序
 * 7.公布结果
 */
import java.util.Scanner;
public class test44 {
	public static void main(String [] args) {
	
		//定义相关变量
		int[] userRedBall = new int[6]; //用户选择的红球号码
		int[] sysRedBall = new int[6]; //系统生成的红球号码
		int userBlueBall = 0; //用户选择生成的蓝球号码
		int sysBlueBall = 0; //系统生成的选择生成的蓝球号码
		int redCount = 0; //记录用户选择正确的红球数
		int blueCount = 0; //记录用户选择正确的篮球数
		int[] redBall = new int[33]; //用于存储1-33的红球号码
		//需要随机生成6个1-33之间不重复的数(算法)
		for (int i = 0; i < redBall.length; i++) {
			redBall[i] = i+1;
		}
		//游戏开始,系统提示
		System.out.println("双色球游戏开始,good luck!");
		System.out.println("请问您是要机选或手选号码(1:机选,2手选): ");
		
		Scanner input = new Scanner(System.in);
		Random r = new Random();
		boolean flag = true;
		while (flag) {
			
			int isAuto = input.nextInt();
			switch (isAuto) {
			
				case 1:
					//机选
					computerSelection(redBall,userRedBall);//机选红球
					userBlueBall = r.nextInt(16)+1; //机选蓝球
					flag = false;
					break;

				case 2:
					//手选
					break;
			}
		}
		
	}
	
	//用于在指定数列中,随机生成多个不重复的数算法
	public static void computerSelection(int[] redBall,int[] userRedBall) {
		// ballCount 1-33总数
		// redBall 我们要随机生成的6个数
		Random r = new Random(); //随机产生数
		int index = -1; 
		for (int i = 0; i < userRedBall.length; i++) { //循环6次
			index = r.nextInt(redBall.length-i);
			userRedBall[i] = redBall[index];
			int temp = redBall[index];
			redBall[index] = redBall[redBall.length-1-i];
			redBall[redBall.length-1-i] = temp;
		}
	}
}