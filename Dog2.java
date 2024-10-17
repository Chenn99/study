import java.io.Serializable;

public class Dog2 implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String sex;

	public Dog2() {
		super();
	}

	public Dog2(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Dog2 [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

}
