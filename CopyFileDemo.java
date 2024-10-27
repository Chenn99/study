package NIODemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * 比较IO操作的性能比较:
 * 1.内存映射最快
 * 2.NIO读写文件
 * 3.使用了缓存的IO流
 * 4.无缓存的IO流
 * 
 * @author Administrator
 *
 */
public class CopyFileDemo {
	
	private static void randomAccessFileCopy() {
		RandomAccessFile in;
		RandomAccessFile out;
		try {
			in = new RandomAccessFile("C:\\test.txt", "r");
			out = new RandomAccessFile("C:\\TEST1\\class\\test.txt", "rw");
			FileChannel fcIn = in.getChannel();
			FileChannel fcOut = out.getChannel();
			
			long size = fcIn.size();//输入流的字节大小
			//输入流的缓冲区
			MappedByteBuffer inBuf = fcIn.map(MapMode.READ_ONLY, 0, size);
			//输出流的缓冲区
			MappedByteBuffer outBuf = fcOut.map(MapMode.READ_WRITE, 0, size);
			
			for (int i = 0; i < size; i++) {
				outBuf.put(inBuf.get());
			}
			
			//关闭(关闭通道时会写入数据块)
			fcIn.close();
			fcOut.close();
			in.close();
			out.close();
			System.out.println("copy success.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 通过文件通道实现文件的复制
	 * @throws Exception
	 */
	private static void copyFile() throws Exception{
		//创建一个输入文件的通道
		FileChannel fcIn = new FileInputStream("C:\\test.txt").getChannel();
		//创建一个输出文件的通道
		FileChannel fcOut = new FileOutputStream("C:\\TEST1\\class\\test.txt").getChannel();
	
		ByteBuffer buf =  ByteBuffer.allocate(1024);
		while (fcIn.read(buf)!=-1) {
			buf.flip();
			fcIn.write(buf);
			buf.clear();
		}
		fcIn.close();
		fcOut.close();
		System.out.println("copy success.");
		
	
	}

	public static void main(String[] args) {
		try {
			//copyFile();
			randomAccessFileCopy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
