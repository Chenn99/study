import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * 字节输出输入流
 * 输出流:超类 OutputStream,对文件的输出流使用子类FileOutputStream
 * 输入流:超类 InputStream,对文件的输入流使用子类FileInputStream
 * 
 * 输入输出字节流操作原理,每次只会操作一个字节,(从文件中读取或写入)
 * 字节操作流,默认每次执行写入操作会直接把数据写入文件
 * @author Administrator
 *
 */
public class ByteStreamDemo {


	public static void main(String[] args) {
		
		//out();
		in();
	}
	
	private static void out() {
		//0.确定目标文件
		File file = new File("c:\\TEST1\\vince.txt");
		//1.构建一个文件输出流对象
		try {
			//OutputStream outputStream = new FileOutputStream(file);
			OutputStream outputStream = new FileOutputStream(file,true);//append 为true表示追加内容
			//2.输出的内容
			String info = "小河流水哗啦啦\r\n"; //\r\n表示换行		
//			String line = System.getProperty("line.separator");//获取换行符
//			String info = "小河流水哗啦啦"+line;
			//3.把内容写入到文件
			outputStream.write(info.getBytes());
			//4.关闭流
			outputStream.close();
			System.out.println("write success");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void in() {
		//0.确定目标文件
		File file = new File("c:\\TEST1\\vince.txt");
		//1.构建一个文件输入流对象
		try {
			InputStream in = new FileInputStream(file);
			//1个中文占位2个字节
			//byte[] bytes = new byte[2];
			byte[] bytes = new byte[1024]	;
			StringBuilder buf = new StringBuilder();

			int len = -1; //表示每次读取的字节长度,-1表示没有
			//把数据读入到数组中,并返回读取的字节数,当不等于-1时,表示读取到数据,等于-1表示文件已经读完了
			while ((len = in.read(bytes))!= -1) {
				//根据读取到的字节数组,再转换为字符串内容,添加到StringBuilder中
				buf.append(new String(bytes));
			} 
			//打印内容
			System.out.println(buf);
			//关闭输入流
			in.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
