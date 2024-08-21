package study;

import java.util.Arrays;

public class test41 {
	public static void main(String [] args) {
		//1.相邻的数据两两交换位置，交换的规则，默认大的放后面，小的放前面
		int[] arr = {9,8,7,6,5,4,3,2,1}; //待排序的数列
		//数组有多长就要完成减1次的交换
        //第一轮交换完，可以获得最大值
        //第二轮交换完，可以获得次大值
        
        extracted(arr); //也可以写出一个方法，在主方法里调用
        System.out.println(Arrays.toString(arr));
	}
        
	private static void extracted(int[] arr){
            for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length-1-i; j++) {
					if (arr[j]>arr[j+1]) {
					//当两个数需要交换位置的时候，就需要引入第三个变量
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}	
    }
}