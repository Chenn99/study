package com.cm.ex;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 异常处理
 * @author Administrator
 *	1.Throwable是异常的基类，分为Error和Exception，在编程中我们关注Exception
 *	2.Exception分为编译期异常（受检异常）和运行期异常（非受检异常）
 *	3.异常会导致程序中断，无法继续执行
 *	4.在开发中，我们需要把可能出现异常的代码使用try语句块包裹起来
 *	5.处理异常可以让程序保持运行状态
 *	6.catch可以有多个，顺序为从子类到父类，大的放后面，小的放前面
 *
 *	ArithmeticException 数学算术异常
 *	ArrayIndexOutOfBoundsException 数组下标越界
 *	NullPointException 空指针异常
 *	InputMismatchException 输入不匹配异常
 *	Exception 父类,最大的那个
 *	RuntimeException 运行期异常
 */
public class ExceptionDemo {

	public static void main(String[] args) {

		//div(10, 2); //运行时异常
		//method();
//		try {
//			div2(20, 0); 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		input(); //InputMismatchException输入不匹配异常
	}
	
	/**
	 * 除法运算
	 */
	private static void div(int num1,int num2) {
		int[] arr = {1,2,3,4,5};
		
		try {
			System.out.println(arr[4]);
			arr = null;
			System.out.println(arr.length);
			int ret = num1/num2;
			//alt+/
			System.out.println("result= " +ret);
		} catch (ArithmeticException e) { //数学算术异常
			System.out.println("除数不能为0");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("数组下标越界");
		}catch (NullPointerException e) {
			System.out.println("空指针异常");
		}catch (Exception e) {
			System.out.println("出错啦");
		}finally { //最终
			System.out.println("程序执行完毕");
		}
		
		
		System.out.println("程序结束");
	}
	
	private static int method() {
		int a = 10;
		int b = 5;
		try {
			System.out.println("a="+a);
			System.out.println("b="+b);
			int c = a/b;
			System.out.println("a/b="+c);
			return c ;  //正常退出方法
		} catch (Exception e) {
			//代码测试时使用
			e.printStackTrace(); //打印内存栈的信息
		}finally {
			System.out.println("finally"); 
			//finally关键字,在进行异常的处理之后,在异常的处理格式中还有一个finally语句,
			//那么此语句将作为异常的统一出口,不管是否产生了异常,最终都要执行此段代码.
		}
		return -1;
//		输出结果
//		a=10
//		b=5
//		a/b=2
//		finally
	}
	
	//自动补全 :alt+/
	private static int div2(int a,int b)throws ArithmeticException {
		//throw在方法内使用,throws在方法声明时使用,搭配使用
		try {
			int c = a/b;
			return c;
		} catch (ArithmeticException e) {
			throw new ArithmeticException("除数不能为零");
		}finally { //不管有没有异常,finally语句块都会去执行
			System.out.println("运行结束");
		}	
	}
	
	private static void input() {
		
		//ctrl +shift + 0 导包
		Scanner input = new Scanner(System.in);
		try {
			int num = input.nextInt();
			System.out.println(num);
		} catch (InputMismatchException e) {
			System.out.println("输入不匹配");
		}
		
	}

}
