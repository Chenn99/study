import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * 缓存的目的:
 * 解决在写入文件操作时,频繁的操作文件所带来的性能降低的问题,
 * BufferedOutputStream 内部默认的缓存大小是8KB,每次写入时存储到缓存中的byte[]数组中,
 * 当数组存满时,会把数组中的数据写入文件,并且缓存下标归零
 * 
 * 字节缓冲流是为了提高字节读写的效率,因此属于在字节输出输入流的基本上通过缓冲流来增强
 * 
 * 字符流
 * 1.加入字符缓冲流,增强读取的功能(readLine)
 * 2.更高效的读取数据
 * FileReader:内部使用InputStreamReader(sun.nio.cs.StreaDecoder),解码过程,byte->char,默认缓存大小是8K
 * BufferedReader:默认缓存大小是8K,但可以手动指定缓存大小,把数据进接读取到缓存中,减少每次转换过程,效率更高
 * BufferedWriter 同上
 * 
 * @author Administrator
 *
 */
public class BufferStreamDemo {

	private static void charWriter() {
		File file = new File("C:\\TEST1\\class1\\test.txt");
		try {
			Writer writer = new FileWriter(file);
			//为字符流提供缓冲,以达到高效读取的目的
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("小河流水哗啦啦,村花到我家");
			bw.flush();//刷新处理
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void charReader() {
		File file = new File("C:\\TEST1\\class1\\test.txt");
		try {
			Reader reader = new FileReader(file);
			//为字符流提供缓冲,以达到高效读取的目的
			BufferedReader bf = new BufferedReader(reader);
			char[] cs = new char[1024];
			int len = -1;
			while ((len = bf.read(cs))!= -1) {
				System.out.println(new String(cs,0,len));			
			}
			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void byteReader2() {
		File file = new File("C:\\TEST1\\class1\\test.txt");
		//这种写法可以自动关闭流
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
			//固定写法
			byte[] bs = new byte[1024];
			int len = -1;
			while ((len = bis.read(bs)) != -1) {
				System.out.println(new String(bs,0,len));
			}
			
			bis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//读操作
	private static void byteReader() {
		File file = new File("C:\\TEST1\\class1\\test.txt");
		try {
			InputStream in = new FileInputStream(file);
			//构造一个字节缓冲流
			BufferedInputStream bis = new BufferedInputStream(in);
			
			byte[] bs = new byte[1024];
			int len = -1;
			while ((len = bis.read(bs)) != -1) {
				System.out.println(new String(bs,0,len));
			}
			
			bis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//写入操作
	private static void byteWriter() {
		File file = new File("C:\\TEST1\\class1\\test.txt");
		try {
			OutputStream out = new FileOutputStream(file);
			//构造一个字节缓冲流
			BufferedOutputStream bos = new BufferedOutputStream(out);
			
			//
			String info = "小河流水哗啦啦";
			bos.write(info.getBytes());
			//关闭流
			bos.close();//写到缓存流里去了
			//out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//byteWriter();
		//byteReader();
		charWriter();
	}
}
