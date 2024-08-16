package study;

/**
 * 数组的遍历
 */
public class test29 {
	public static void main(String [] args) {
		
		int[] scores = {59,75,83,93,100};
		System.out.println("数组的长度是： " + scores.length);
		
		//for遍历取值
		int len = scores.length;
		for (int i = 0; i < len; i++) {
			
			int score = scores[i]; //定义一个变量
			System.out.println(score);
		}
		System.out.println("-------------------");
		
		//forearch JDK1.5新增的特性
		for (int i : scores) {
			System.out.println(i);
		}
		System.out.println("-------------------");
		
		//调用方法:
		//print(scores);
		//print2(59,75,83,93,100); //这里可变参数的输出结果是75,83,93,100，因为第一个59被赋给了k
		//print3(null); //空指针异常
		print4(scores);
	}

	public static void print(int[] i) {
		int len = i.length;
		for (int j = 0; j < len; j++) {
			System.out.println(i[j]);
		}
	}
	
	//JDK1.5可变参数
	//可变参数只能是参数列表中的最后一个
	//可变参数作为数组使用
	public static void print2(int k,int... i) {
		int len = i.length;
		for (int j = 0; j < len; j++) {
			System.out.println(i[j]);
		}
		
	}
	
	//测试数组的异常NullPointerException(空指针)
	public static void print3(int[] i) {
		//java.lang.NullPointerException
		//当一个变量为null(没有赋值时)时，我们去调用了该变量的属性和方法
		System.out.println("数组的长度是： " + i.length);
	}
	
	//测试数组的异常，数组下标越界
	//java.lang.ArrayIndexOutOfBoundsException
		public static void print4(int[] i) {
			for (int j = 0; j <= i.length; j++) {
				System.out.println(i[j]);
			}
			
		}
	
}