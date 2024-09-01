package study;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *对象数组与管理
 *使用对象数组实现多个Chicken的管理
 */
public class test55 {
	public static void main(String [] args) {
		ChickenManager cm = new ChickenManager(5);
		cm.add(new Chicken(1,"小小",10));
		cm.add(new Chicken(2,"小二",8));
		cm.add(new Chicken(3,"小三",6));
		cm.add(new Chicken(4,"小四",2));
		cm.add(new Chicken(5,"小五",4));
		
		//cm.add(new Chicken(6,"小六",6));
		
	}
}

//小鸡管理类
class ChickenManager{
	
	private Chicken[] cs = null;
	private int count = 0;//记录当前数组的元素个数(下标)
	
	public ChickenManager(int size)  {
		if (size >0) {
			cs = new Chicken[size];
		}else {
			cs = new Chicken[5];
		}
	}
	//添加:实现动态数组
	public void add(Chicken c) {
		if (count >= cs.length) { //数组已满,需要扩充
			
			//算法1:扩充原来数组大小的一半  cs.length*3/2+1
			//算法2:扩充原来数组的一倍  cs.length*2
			int newLen = cs.length*2;
			cs = Arrays.copyOf(cs, newLen);
			
		}else {
			cs[count] = c;
			count++;
		}
	}
	//删除
	public void delete() {
		
	}
	//更新
	public void update() {
		
	}
	//查找
	public Chicken find(int id) {
		return id;
		
	}
	//输出所有
	public void printAll() {
		
	}
}

//小鸡类(数据对象) value object(VO)
class Chicken{
	
	private int id;
	private String name;
	private int age;
	public Chicken() {} //一般情况下最好保留默认的构造方法
	public Chicken(int id,String name,int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void print() {
		System.out.println("id="+id+"name="+name+"age="+age);
	}
}