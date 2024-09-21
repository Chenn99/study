package study;
/**
 *  基本数据类型包装类
 */
public class test72 {
	public static void main(String[] args) {
		
		//把数据类型转换为包装类,称为自动装箱
		Integer i1 = new Integer(10);
		//把包装类转换为基本数据类型,称为自动拆箱
		int i2 = i1.intValue();
		
		Integer i3 = 10; //建议方式
		
		Integer i4 = new Integer("123");
		//把数值字符串转换为int类型
		String num1 = "12";
		int i5 = Integer.parseInt(num1);
		
		int i6 = Integer.valueOf(num1);
		
		//面试题:
		Integer x1 = new Integer(10);
		Integer x2 = new Integer(10);
		System.out.println(x1==x2); //false ==双等号比较的是对象引用的地址
		System.out.println(x1.equals(x2));//true equals比较的才是值

		Integer x3 = new Integer(128);
		Integer x4 = new Integer(128);
		System.out.println(x3==x4);	//false
		System.out.println(x3.equals(x4)); //true
		
		Integer x5 = 10; //用到是同一个对象,都指向10
		Integer x6 = 10;
		System.out.println(x5==x6); //true 享元模式,缓存一个字节以内的数
		System.out.println(x5.equals(x6)); //true
		
		Integer x7 = 128; //超过一个字节 
		//Integer x7 = 127;  //true
		Integer x8 = 128;
		System.out.println(x7==x8); //false
		System.out.println(x7.equals(x8)); //true 比较值
	}
}