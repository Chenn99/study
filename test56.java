package study;

/**
 * 继承:继承是从已有的类创建新类的过程
 * 继承一个父类,只能继承非私有的数据(属性和方法)
 * protected 访问权限修饰符,在继承关系中使用,在父类中使用protected修饰的属性或方法可以被子类继承
 * 创建子类对象时,父类的构造方法也会被调用,为什么?
 * 因为在子类要使用到父类的数据,那么就要通过父类的构造方法来初始化数据
 * (如果创建子类对象时使用默认的构造方法,那么父类的默认构造方法也会被调用)
 * 如果创建子类对象时会调用父类的默认构造方法
 * 
 * 当父类中没有无参构造方法时,子类必须显示的调用父类的带参构造方法,怎么调用呢?
 * 可以在子类中显示的使用super(...)调用的父类的构造方法,只能出现在第一句
 */
public class test56 {
	public static void main(String [] args) {
		
		HomeDog homeDog = new HomeDog("旺财");
		homeDog.print();
		homeDog.eat(); //homeDog子类继承父类DDog的eat()方法
		HuskyDog huskyDog = new HuskyDog();
		//HuskyDog huskyDog = new HuskyDog("小一");
		huskyDog.show();
		
//		我是DDog的构造方法
//		我是HomeDog的构造方法
//		我是一只家狗,名字叫:旺财
//		我是DDog的构造方法
//		我是哈士奇,我叫小一,我能跳舞
	}
}

//父类
class DDog{
	protected String name; //受保护的,可以被子类继承
	private String sex; //私有的,不能被子类继承

	//父类的无参构造
	//	public DDog() {
//		System.out.println("我是DDog的构造方法");
//	}

	//父类的有参构造
	public DDog(String name,String sex) {
		this.name = name;
		this.sex = sex;
		System.out.println("我是DDog的构造方法");
	}
	public void eat() {
		System.out.println("吃饭");
	}
}

//子类1
class HomeDog extends DDog{
	public HomeDog(String name) { //子类的有参构造
		super(name, "公"); //只能在第一句
		//this.name = name;
		System.out.println("我是HomeDog的构造方法");
	}
	//扩展
	public void print() {
		System.out.println("我是一只家狗,"+"名字叫:"+name);
	}
}

//子类2
class HuskyDog extends DDog{
	public HuskyDog() {
		super("小一", "公");
		//this.name = name;
		System.out.println("我是HuskyDog的构造方法");
	}
	public void show() {
		System.out.println("我是哈士奇,我叫"+name+",我能跳舞");
		//我是哈士奇,我叫小一,我能跳舞
	}
}