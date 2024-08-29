package study;

/**
 * 两个对象之间的一对一关系:
 * 比如:一个英雄Hero对一个兵器Weapon
 * 双向一对一
 * 单向一对一
 */
public class test50 {
	public static void main(String [] args) {
		
		Hero hero = new Hero("刘备",300);
		Weapon weapon = new Weapon("双股剑",3);

		//把两个对象关联起来
		hero.setWeapon(weapon);
		weapon.setHero(hero);
		
		//通过英雄来获取的他的信息
		String name= hero.getName();
		int age = hero.getAge();
		Weapon w = hero.getWeapon();
		System.out.println("我是" +name +",我" +age+"岁,我的武器是"+w.getName()+",排行"+w.getGrade()+"级");
		//输出:我是刘备,我300岁,我的武器是双股剑,排行3级
	}
}

//英雄类
class Hero{
	private String name;
	private int age;
	private Weapon weapon;
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	public Hero() { //有其他的构造方法时,保留默认构造方法
		
	}
	public Hero(String name,int age) { //创建一个带参数的构造方法
		this.name =name;
		this.age = age;
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
}

//兵器类
class Weapon{
	private String name;
	private int grade;
	private Hero hero;
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	public Hero getHero() {
		return hero;
	}
	public Weapon() {
		//默认的构造方法
	}
	public Weapon(String name,int grade) {
		this.name = name;
		this.grade = grade;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getGrade() {
		return grade;
	}
	
}