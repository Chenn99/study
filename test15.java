package study;

/**
 * do while循环:特点是先执行再判断，最少执行一次
 * 2.java阶乘求和  1!+2!+...+10!
 * @author min
 *
 */
public class test15 {
	public static void main(String [] args) {
		
		int num = 0; //记录总和
		int i = 1;
		do {	//求和
			int j = 1;
			int jc = 1; //求阶乘的和
			while (j<=i) { //求阶乘
				jc *= j;
				j++;
			}
			num += jc;
			i++;
		} while (i<=10); //循环条件
		System.out.println(num);
	}
}