package study;

/**
 * 定义一个五位整数,求各个位上的和
 * @author min
 *
 */
public class test5 {
	public static void main(String [] args) {
		int num = 54321;
		int w = num/10000;
		int q = num/1000%10;
		int b = num/100%10;
		int s = num/10%10;
		int g = num%10; 
		// 取余（%）运算符返回左侧操作数除以右侧操作数的余数。它总是与被除数的符号保持一致。
		System.out.println(w+q+b+s+g); //输出结果 15
		
	}
}
