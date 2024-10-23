import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Properties:
 * Properties可以用来做配置文件
 * javaweb和javaee 开发中通常会用到
 * 
 * 
 * ReaouceBundle 只读
 * Properties 可读可写
 * @author Administrator
 *
 */
public class PropertiesDemo {

	
	public static String version = "";
	public static String username = "";
	public static String password = "";
	
	//静态代码块,只会执行一次
	static {
		//readConfig();
	}
	
	/**
	 * 对属性文件的写操作
	 * @param version
	 * @param username
	 * @param password
	 */
	private static void writeConfig(String version,String username,String password) {
		Properties p = new Properties();
		p.put("app.version", version);
		p.put("db.username", username);
		p.put("db.password", password);
		OutputStream out;
		try {
			out = new FileOutputStream("config.properties");
			p.store(out, "update config");
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 读取Properties配置文件
	 */
	private static void readConfig() {
		Properties p = new Properties();
		try {
			//通过当前线程的类加载器对象,来加载指定包下的配置文件
			//Thread.currentThread().getContextClassLoader().getResourceAsStream("com/xxx/config.properties");
			InputStream is = new FileInputStream("config.properties");
			p.load(is);//加载文件
			
			//从properties中获取数据
			version = p.getProperty("app.version");
			username = p.getProperty("db.username");
			password = p.getProperty("db.password");
			
			is.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
	}
	
	public static void main(String[] args) {
	
		writeConfig("2", "vince", "654332");
		readConfig();
		System.out.println(PropertiesDemo.version);
		System.out.println(PropertiesDemo.username);
		System.out.println(PropertiesDemo.password);
	}

}
