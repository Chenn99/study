package study;

/**
 * 数组的示例:1,猜数游戏:从键盘中任意输入一个数据,判断数列中是否包含此数。
 */
import java.util.Scanner;
import java.util.Random; //生成伪随机数
public class test31 {
	public static void main(String [] args) {
		
		int[] nums = new int[5];
		int len = nums.length;
		Random r = new Random();//创建一个可以生成随机数的工具
		for (int i = 0; i < len; i++) {
			nums[i] = r.nextInt(50);
		}
		
		//int[] nums = {20,17,6,2,22,27};
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要猜的数： （50以内）");
		int userNum = input.nextInt();
		
		boolean flag = false;
		for (int i : nums) {
			if (userNum==i) {
				flag = true;
				break; 
			}
		}
		
		if (flag) {
			System.out.println("猜对了");
		}else {
			System.out.println("猜错了");
		}
		
	}
}