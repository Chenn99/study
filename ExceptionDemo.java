package com.cm.ex;

/**
 * 异常处理
 * @author Administrator
 *	1.Throwable是异常的基类，分为Error和Exception，在编程中我们关注Exception
 *	2.Exception分为编译期异常（受检异常）和运行期异常（非受检异常）
 *	3.异常会导致程序中断，无法继续执行
 *	4.在开发中，我们需要把可能出现异常的代码使用try语句块包裹起来
 *	5.处理异常可以让程序保持运行状态
 *	6.catch可以有多个，顺序为从子类到父类，大的放后面，小的放前面
 */
public class ExceptionDemo {

	public static void main(String[] args) {

		div(10, 2); //运行时异常
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
		}finally {
			System.out.println("程序执行完毕");
		}
		
		
		System.out.println("程序结束");
	}

}
