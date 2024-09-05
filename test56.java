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
 * 
 * overloading与overridng的区别?
 * overloading:方法的重载,发生在同一个类中,方法名相同,参数列表不同,返回值无关
 * overridng:方法的重写,发生在子父类中,方法名相同,参数列表相同,返回值无关,子类的访问修饰符要大于或等于父类的访问修饰符
 * 子类的异常声明必须小于或等于父类的异常声明.如果方法被private,static,final修饰,则不能被重写
 */
public class test56 {
	public static void main(String [] args) {
		
		HomeDog homeDog = new HomeDog("旺财");
		homeDog.print();
		homeDog.eat(); //homeDog子类继承父类DDog的eat()方法
		HuskyDog huskyDog = new HuskyDog();
		//HuskyDog huskyDog = new HuskyDog("小一");
		huskyDog.show();
		huskyDog.eat();
		
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
	public void eat(){
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
		//super.属性 表示调用父类的属性,如果是继承过来的属性,那么super可以省略
		System.out.println("我是一只家狗,"+"名字叫:"+super.name);
	}
	//重写父类的方法
	public void eat(){
		super.eat();//调用父类的方法
		System.out.println("我是家狗,我喜欢吃骨头");
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
	//重写父类的方法
	public void eat() {
		System.out.println("我是哈士奇,我喜欢吃鸡肉");
	}
}