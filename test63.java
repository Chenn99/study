package study;

/**
 * 策略模式(Strategy Pattern),定义了一系列的算法,
 * 将每一种算法封装起来并可以相互替换使用,
 * 策略模式让算法独立于使用它的客户应用而独立变化。
 * 
 * 把可变的行为抽象出来，这样的好处是这些行为可以在真正使用时相互替换
 */
public class test63 {
	public static void main(String[] args) {
		
		BaseService user =  new UserService();
		user.setISave(new FileSave()); 
		//user.setISave(new NetSave());  //把数据保存到网络上
		user.add("user");
//		检查数据合法性
//		把数据保存到文件中user
//		数据保存完毕
		
	}
}

//（定义一个接口）把可变的行为抽象出来，定义一系列的算法
interface ISave {
	public void save(String data);
	
}
//接口是实现接口
class FileSave implements ISave{
	public void save(String data) {
		System.out.println("把数据保存到文件中"+data);
	}
}

class NetSave implements ISave{
	public void save(String data) {
		System.out.println("把数据保存到网络上"+data);
	}
}

//抽象类
abstract class BaseService{
	//抽象方法
//	public abstract void doSave(String data);

	private ISave iSave; //把接口定义作为类的属性，绑定接口
	public void setISave(ISave iSave) {
		this.iSave = iSave;
	}
	
	public void add(String data) {
		System.out.println("检查数据合法性");
		iSave.save(data); 
		System.out.println("数据保存完毕");
	}
}

class UserService extends BaseService{
	
}

//具体的子类去实现（普通的写法）
//class UserService extends BaseService{
//	
//	public void doSave(String data) {
//		System.out.println("把数据保存到文件中"+data);
//	}
//}