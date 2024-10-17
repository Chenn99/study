import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class ObejectStreamDemo {

	public static void main(String[] args) {
		//writeObject();
		//readObject(); //Dog [name=旺旺, age=2, sex=母]
		
		//序列化一组对象 可以用数组
		//writeObjects();
		readObjects();
	}
	
	/**
	 * 反序列化的过程
	 * 从文件中把对象的内容读取出来,还原成对象
	 */
	private static void readObject() {
		File file = new File("C:\\TEST1\\class\\dog.obj");
		
		try {
			InputStream in = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(in);
			Dog dog =(Dog)ois.readObject();
			ois.close();
			System.out.println(dog);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 对象序列化
	 * 把对象写入文件:实际写入的是类名,属性名,属性类型,属性的值等
	 */
	private static void writeObject() {
		Dog dog = new Dog("旺旺", 2, "母");
		File file = new File("C:\\TEST1\\class\\dog.obj");
		
		try {
			OutputStream ops = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(ops);
			oos.writeObject(dog);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void writeObjects() {
		Dog dog = new Dog("旺旺", 2, "母");
		Dog dog2 = new Dog("小白", 3, "公");
		Dog[] dogs = {dog,dog2};
		File file = new File("C:\\TEST1\\class\\dogs.obj");
		
		try {
			OutputStream ops = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(ops);
			oos.writeObject(dogs);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readObjects() {
		File file = new File("C:\\TEST1\\class\\dogs.obj");
		
		try {
			InputStream in = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(in);
			Dog[] dogs =(Dog[])ois.readObject();
			ois.close();
			System.out.println(Arrays.toString(dogs));
			//[Dog [name=旺旺, age=2, sex=母], Dog [name=小白, age=3, sex=公]]
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
