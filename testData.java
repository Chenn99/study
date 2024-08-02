package study;

/**
 * 基本数据类型转换
 * @author min
 *
 */
public class testData {
	public static void main(String [] args) {
		
		byte b = 10;
		short s = b; //把一个字节赋值给一个短整型变量,自动转换
		int i = s; //把一个短整型赋值给一个整型变量,自动转换
		long lon = i; //把一个长整型赋值给一个短整型变量,自动转换
		
		//char -> int之间是可以自动转换的
		char sex = '女'; 
		int sex2 =sex;
		System.out.println(sex2); //输出结果为22899  女 汉字的ascii码
		
		float f = 20f;
		double d = f;
		System.out.println(d); //输出结果为20.0
		
		// float 和 double 是属于近似值
		// byte char short int long 属于精确值
		// 精确值转近似值时有可能丢失精度
		
		int num = 2147483000;
		float num2 = num;
		// 如果用于表示货币值,不建议使用float或double
		System.out.println(num2); //输出结果为2.14748301E9
		
		//byte short int 在计算时会自动转换成int类型
		short s1 = 10;
		s1 = (short) (s1 + b);  //先计算这部分的值(s1 + b),再把得到的这个int值赋值给s1,最后强制类型转换成short类型
		System.out.println(s1); //输出结果为20
		
		//把大的容量类型转换为小的容量类型,需要添加强制类型转换
		int x = (int) lon;
		
	}
}
