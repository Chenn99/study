import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * 打印流:很方便的进行输出
 * 
 * 字节打印流
 * 在字节输出时,可以增强输出功能
 * 字符打印流
 * 
 * @author Administrator
 *
 */
public class PrintStreamDemo {
	
	private static void charPrint() {
		File file = new File("C:\\TEST1\\class1\\test.txt");
		try {
			Writer out = new FileWriter(file);
			//对文件的直接写入
			//带上缓存的目的,增加写入的效率
			BufferedWriter bw = new BufferedWriter(out);
			//打印流,帮助我们提供输出的遍历性
			PrintWriter pw = new PrintWriter(bw);
			pw.println("小河流水天天哗啦啦");
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void bytePrint() {
		File file = new File("C:\\TEST1\\class1\\test.txt");
		try {
			OutputStream out = new FileOutputStream(file);
			//对文件的直接写入
			//带上缓存的目的,增加写入的效率
			BufferedOutputStream bf = new BufferedOutputStream(out);
			//打印流,帮助我们提供输出的遍历性
			PrintStream ps = new PrintStream(bf);
			ps.println("小河流水天天哗啦啦");
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		//bytePrint();
		charPrint();
	}

}
