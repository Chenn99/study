import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 缓存的目的:
 * 解决在写入文件操作时,频繁的操作文件所带来的性能降低的问题,
 * BufferedOutputStream 内部默认的缓存大小是8KB,每次写入时存储到缓存中的byte[]数组中,
 * 当数组存满时,会把数组中的数据写入文件,并且缓存下标归零
 * 
 * 字节缓冲流是为了提高字节读写的效率,因此属于在字节输出输入流的基本上通过缓冲流来增强
 * @author Administrator
 *
 */
public class BufferStreamDemo {

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
		byteReader();
	}
}
