package study;

/**
 * 抽象类应用
 */
public class test62 {
	public static void main(String[] args) {

		UserManager um = new UserManager();
		um.action("test","add"); //你没有操作权限,请联系管理员
//		um.action("admin","add"); //用户执行添加操作
//		um.action("admin","del"); //用户执行删除操作
	}
}

abstract class BaseManager{
	
	public void action(String name,String method) {
		if ("admin".equals(name)) {
			execute(method);
		}else {
			System.out.println("你没有操作权限,请联系管理员");
		}
	}
	
	public abstract void execute(String method); //抽象方法
}

class UserManager extends BaseManager{
	public void execute(String method) {
		
		//用户是否登录的验证
		//验证成功后才可以执行以下操作
		if ("add".equals(method)) {
			System.out.println("用户执行添加操作");
		}else if ("del".equals(method)) {
			System.out.println("用户执行删除操作");
		}
	}
}


