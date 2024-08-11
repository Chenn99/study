package study;

/**
 *	多重for循环
 */
public class test21 {
	public static void main(String [] args) {
		
//		//外循环控制行数
//		for (int i = 1; i <= 5; i++) {
//			
//			//内循环控制列数
//			for (int j = 5; j > 0; j--) {
//				if (j<=i) {
//					System.out.print("*"); 
//				}else {
//					System.out.print(" "); 
//				}
//			}
//			System.out.println(); //会换行
//		}
		
		//外循环控制行数
		for (int i = 1; i < 5; i++) {
			
			//内循环控制空格
			for (int j = i; j < 5; j++) {
				System.out.print(" "); 
			}
			//内循环控制*
			for (int j = 1; j <= i*2-1; j++) {
				System.out.print("*");
			}
			System.out.println(); 
		}
	}
}