package study;

/**
 *	多重for循环
 */
public class test19 {
	public static void main(String [] args) {
		
		//外循环控制行数
		for (int i = 1; i <= 5; i++) {
			
			//内循环控制列数
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println(); //会换行
		}
	}
}