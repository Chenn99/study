package study;

/**
 * 数组的定义：一组能够存储相同数据类型的数据集合。
 * 数组一定要有长度
 * 数组中的每个数据称为元素，
 * 数组元素的位置从0开始
 * 数组中的位置称为下标
 */
public class test28 {
	public static void main(String [] args) {
		
		//数组的赋值方式：		
		//第一种
		int[] nums = new int[5];
		/*
		nums[0] = 1;
		nums[1] = 2;
		nums[2] = 3;
		nums[3] = 4;
		nums[4] = 5;
		*/
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i+1;
		}
		
		//第二种
		int[] nums2; //先声明（定义）
		nums2 =	new int[5];
		
		//第三种
		int[] nums3 = new int[] {1,2,3,4,5}; //先声明（定义），再使用指定的值
		
		//第四种
		int[] nums4 = {1,2,3,4,5};
		
		//所有的数组都有一个属性是：length
		System.out.println("数组的长度是： "+ nums4.length);
	}
}