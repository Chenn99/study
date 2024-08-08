package study;

/**
 * while循环
 * 2.计算10的阶乘。
 * @author min
 *
 */
public class test14 {
	public static void main(String [] args) {
		
//		int i = 1;//增量
//		int num = 1;
//		while (i<=10) {
//			num *= i;
//			i++;
//		}
//		System.out.println(num);//输出结果3628800
		
		//while特点是先判断再执行，有可能执行0次
//		int i = 1;//增量
//		int num = 0;
//		while (i<=100) {
//			num += i;
//			i++;
//		}
//		System.out.println(num); //输出结果5050
		
		int i = 1;//增量
		while (i<100) {
			if (i%2==0) {
				System.out.println("偶数"+i);
			}else {
				System.out.println("奇数"+i);
			}
			if (i%3==0) {
				System.out.println("3的倍数"+i);
			}
			i++;
		}
	}	
}
