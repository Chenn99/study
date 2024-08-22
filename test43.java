package study;
/*
 * Arrays工具类的使用
 */
import java.util.Arrays;
public class test43 {
	public static void main(String [] args) {
		
		int[] num = {10,20,50,65,88,90}; 
		//二分查找
		int index = Arrays.binarySearch(num, 90);
		System.out.println("找到的下标为: " +index);
		//输出结果:
		//找到的下标为: 5
		
		//输出数组
		for (int i : num) {
			System.out.println(i);
		}
		//输出结果:
		//10,20,50,65,88,90
		
		//在测试输出数据时可以时,可以使用,更加方便
		System.out.println(Arrays.toString(num));
		//输出结果:
		//[10, 20, 50, 65, 88, 90]
		
		//排序
		int[] num2 = {10,32,11,44,543,22,12};
		Arrays.sort(num2); //快速排序
		System.out.println(Arrays.toString(num2));
		//输出结果:
		//[10, 11, 12, 22, 32, 44, 543]
		
		//数组的复制
		int[] num3 = Arrays.copyOf(num2, 10);
		//num2 = Arrays.copyOf(num2, 10); 可以这样用num2去接收,也可以定义一个新的数组num3
		System.out.println(Arrays.toString(num3));
		//输出结果:
		//[10, 11, 12, 22, 32, 44, 543, 0, 0, 0],后面三位数自动补成0,因为整数型默认为0
		
		//System.arraycopy(Object src 原对象, int srcPos 原对象的起始位置, Object dest 目标对象, int destPos 目标对象的起始位置, int length 一共多长多行) 
		int[] newNum = new int[num2.length]; //这里必须要创建一个新的数组
		System.arraycopy(num2, 0, newNum, 0, num2.length);
		System.out.println(Arrays.toString(newNum));
		//输出结果:
		//[10, 11, 12, 22, 32, 44, 543]
		
		//小结,数组的复制:
		/*
		 * 效率由高到低排序是:System.arraycopy -> Arrays.copyOf -> for
		 */
		
		//判断两个数组的值是否相等
		System.out.println(Arrays.equals(num3, newNum)); //布尔型,返回true或者是false
		
		//填充数组
		Arrays.fill(num2,1);
		System.out.println(Arrays.toString(num2));
	}
}