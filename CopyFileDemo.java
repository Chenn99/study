import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件的复制示例:
 * 从一个输入流中读取数据,然后通过输出流写入目标位置
 * 一边读一边写
 * @author Administrator
 *
 */
public class CopyFileDemo {

	public static void main(String[] args) {
		System.out.println("start copy...");
		copy("C:\\HelloWorld.class", "C:\\TEST1\\class\\HelloWorld.class");
		System.out.println("copy success");
	}

	//这里不涉及文本文件操作,可以只使用字节流
	private static void copy(String src,String target) {
		File srcFile = new File(src);
		File targetFile = new File(target);
		InputStream in = null;
		OutputStream out = null;
		
		
		try {
			//输入输出流
			in =new FileInputStream(srcFile);
			out =new FileOutputStream(targetFile);
			
			//固定写法
			byte[] bs = new byte[1024];
			int len =-1;
			while ((len=in.read(bs))!= -1) {
				out.write(bs,0,len);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (in!=null)in.close();
				if (out!=null)out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
