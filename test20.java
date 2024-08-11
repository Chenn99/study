package study;

/**
 *	打印九九乘法表
 */
public class test20 {
	public static void main(String [] args) {
		
		//外循环控制行数
		for (int i = 1; i <= 9; i++) {
			
			//内循环控制列数
			for (int j = 1; j <= i; j++) {
				System.out.print(j+"*"+i+"="+(j*i)+"\t"); //加上一个制表符,加上间距
			}
			System.out.println(); //会换行
		}
	}
}