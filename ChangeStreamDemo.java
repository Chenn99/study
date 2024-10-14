import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

/**
 * 转换流
 * OutputStreamWriter:可以将输出的字符流转换为字节流
 * InputStreamWriter:将输入的字节流转换为字符流输入形式
 * 
 * 从代码的角度看,都是把字节流封装成字符流
 * @author Administrator
 *
 */
public class ChangeStreamDemo {

	private static void write(OutputStream out) {
		Writer writer = new OutputStreamWriter(out,Charset.defaultCharset());
		try {
			writer.write("一二三四五");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void read(InputStream in) {
		//只有字符流才可以指定编码
		Reader reader = new InputStreamReader(in,Charset.forName("UTF-8"));
		char[] cs = new char[1024];
		int len = -1;
		try {
			while ((len=reader.read(cs))!=-1) {
				System.out.println(new String(cs,0,len));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {

//		InputStream in = new FileInputStream("C:\\TEST1\\vince.txt");
//		read(in);
		
		OutputStream out = new FileOutputStream("C:\\TEST1\\vince.txt");
		write(out);
	}

}
