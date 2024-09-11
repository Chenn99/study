package study;

/**
 * 
 */
public class test64 {
	public static void main(String[] args) {
		
		Studentt s = new Studentt(1,"飞飞",18);
		System.out.println(s);
//		Studentt s1 = new Studentt(2,"花花",23);
		Studentt s2 = new Studentt(1,"飞飞",18);
		boolean b = s.equals(s2);
		System.out.println(b);
		
		String s3 = new String("备备");
		String s4 = new String("备备");
//		System.out.println(s3==s4); false
		System.out.println(s3.equals(s4)); //true
		
		System.out.println(s.getClass() == s2.getClass()); 
}
}

class Studentt{
	private String name;
	private int sid;
	private int age;
	public Studentt() {}
	public Studentt(int sid,String name,int age) {
		this.sid = sid;
		this.name = name;
		this.age = age;
	}
	//重写Object类中的toString方法
	public String toString() {
		return "sid="+sid+",name="+name+",age="+age;
	}
	//重写equals方法，来实现两个对象的比较
	public boolean equals(Object obj) {
		if (this==obj) {
			return true;
		}
		if (obj instanceof Studentt) {
			Studentt s = (Studentt)obj;
			if (this.name.equals(s.name)) {
				return false;
			}
			if (this.sid!=s.sid) {
				return false;
			}
			if (this.age!=s.age) {
				return false;
			}
			return true;
		}
		return false;
	}
}