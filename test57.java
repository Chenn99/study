package study;

/**
 * 继承的应用示例
 */
public class test57 {
	public static void main(String [] args) {
		
		//CosmeticManager cm = new CosmeticManager();
		//SortCosmeticManager cm = new SortCosmeticManager();
		ImportCosmeticManager cm = new ImportCosmeticManager();
		cm.add(new Cosmetic("香奈儿","进口",400));
		cm.add(new Cosmetic("圣罗兰","进口",800));
		cm.add(new Cosmetic("大宝","国产",20));
		cm.add(new Cosmetic("雪花膏","国产",15));
		cm.printInfo();
	}
}

//实现可输出进口化妆品的管理类
class ImportCosmeticManager extends CosmeticManager{
	//排序输出所有产品
	public void printInfo() {
		//比较两个字符串的值是否相等,不能使用==,使用equals()
		for (int i = 0; i < count; i++) {
			if ("进口".equals(cs[i].getType())) {
				System.out.println(cs[i].getInfo());
			}
		}
	}
}

//可按单价排序的化妆品管理类
class SortCosmeticManager extends CosmeticManager{

	//排序输出所有产品
	public void printInfo() {
		Cosmetic[] temp = java.util.Arrays.copyOf(cs, count);
		Cosmetic c = null; //第三个变量
		//冒泡排序法
		for (int i = 0; i < temp.length-1; i++) {
			for (int j = 0; j < temp.length-1-i; j++) {
				if (temp[j].getPrice() > temp[j+1].getPrice()) {
					c = temp[j];
					temp[j] = temp[j+1];
					temp[j+1] = c;
				}
			}
		}
		//foreach遍历输出
		for (Cosmetic cosmetic : temp) {
			System.out.println(cosmetic.getInfo());
		}
	}
}

//化妆品管理类
class CosmeticManager{
	//定义一个数组
	protected Cosmetic[] cs = new Cosmetic[4];
	protected int count = 0; //下标
	
	//进货功能
	public void add(Cosmetic c) {
		//扩充
		int size = cs.length;
		if (count>=size) {
			int newLen = size*2;
			cs = java.util.Arrays.copyOf(cs, newLen);
		}
		cs[count] = c;
		count++;
	}
	
	//输出所有产品
	public void printInfo() {
		for (int i = 0; i < count; i++) {
			System.out.println(cs[i].getInfo());
		}
	}
}

//定义一个化妆品类
class Cosmetic{
	private String name;//品牌
	private String type;//进口或国产
	private int price;//单价
	//空参的构造方法
	public Cosmetic() {}
	//有参的构造方法
	public Cosmetic(String name,String type,int price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public String getInfo() {
		return "name="+name+",type="+type+",price"+price;
	}
	
}
