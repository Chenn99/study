package study;

/**
 * 求最大值和最小值算法
 */
public class test34 {
	public static void main(String [] args) {

		int[] num = {12,3,54,67,88,34};
		int max = max(num); //调用求最大值max这个方法，需要定义一个变量来接收方法返回的值
		System.out.println("数列中的最大值是" + max);
//		int min = min(num);
//		System.out.println("数列中的最小值是" + min);
	}
	
	//求数列中的最大值
	public static int max(int[] num) {
		int max = num[0]; //定义一个数，假设这个是最大值
		int len = num.length;
		for (int i = 1; i < len; i++) { //0被赋给了最大值，所以循环从1开始
			if (num[i] > max) {
				//两个数交换位置
				num[i] = num[i] + max;
				max = num[i] - max;
				num[i] = num[i] - max;
			}
		}
		return max;
	}
	
	//求数列中的最小值
//	public static int min(int[] num) {
//		int min = num[0]; //定义一个数，假设这个是最小值
//		int len = num.length;
//		for (int i = 1; i < len; i++) { 
//			if (num[i] < min) {
//				//两个数交换位置
//				num[i] = num[i] + min;
//				min = num[i] - min;
//				num[i] = num[i] - min;
//			}
//		}
//		return min;
//	}
}
