package study;

/**
 * 通过键盘输入声明初始化一个圆柱体的高和底面半径,pai值是3.14,求圆柱体的体积,并显示输出圆柱体的体积; Π(r^2)h
 * @author min
 *
 */
import java.util.Scanner; //导入键盘输入的工具类

public class test4 {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in); //初始化
		System.out.println("请输入圆柱体的高: ");
		int h = input.nextInt();
		System.out.println("请输入圆柱体的底面半径: ");
		int r = input.nextInt();
		double result = 3.14*r*r*h;
		System.out.println("输出圆柱体的体积是: "+result);
		
		//输出结果如下:
		//请输入圆柱体的高: 
		//10
		//请输入圆柱体的底面半径: 
		//3
		//输出圆柱体的体积是: 282.59999999999997
		
	}
}
