import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandromAccessFile
 * @author Administrator
 *
 */
public class RandromAccessFileDemo {

	public static void main(String[] args) {

		try {
			//读取文件
			RandomAccessFile r = new RandomAccessFile("C:\\Users\\Administrator\\Pictures\\天空\\QQ图片20211028115245.jpg","r");
			//写入文件
			RandomAccessFile w = new RandomAccessFile("C:\\TEST1\\QQ图片20211028115245.jpg","rw");
	
			byte[] bs = new byte[1024];
			int len = -1;
			while ((len = r.read(bs))!=-1) {
				w.write(bs,0,len);
			}
			w.close();
			r.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("copy success");
	}

}
