import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDivisionMergeDemo {

	/**
	 * 文件的分割
	 * targetFile 要分割的目标文件
	 * cutSize 每个文件的大小
	 */
	private static void division(File targetFile,long cutSize) {
		if (targetFile == null) return;
		//计算总分割的文件数
		int num =targetFile.length()%cutSize==0?
				(int)(targetFile.length()/cutSize):(int)(targetFile.length()/cutSize+1);
		
		try {
			//构建一个文件输入流
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(targetFile));
			BufferedOutputStream out = null;
			
			byte[] bs = null;//每次要读取的字节数
			int len = -1;//每次实际读取的长度
			int count = 0;//每个文件要读取的次数
			
			//循环次为生成文件的个数
			for (int i = 0; i < num; i++) {
				out = new BufferedOutputStream(
						new FileOutputStream(new File("C:\\"+(i+1)+"-temp-"+targetFile.getName())));
				
				
				if (cutSize<=1024) {
					bs = new byte[(int)cutSize];
					count = 1;
				}else {
					bs = new byte[1024];
					count = (int) (cutSize/1024);
				}
				
				while (count>0 && (len = bis.read(bs))!=-1) {
					out.write(bs,0,len);
					out.flush();//刷新
					count--;
				}
				
				//计算每个文件大小除于1023的余数,来决定是否要再读取一次
				if (cutSize %1024!=0) {
					bs = new byte[(int) cutSize % 1024];
					len = bis.read(bs);
					out.write(bs,0,len);
					out.flush();
					out.close();
				}
			}
			bis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 文件合并
	 * @param args
	 */
	private static void merge() {
		
	}
	
	public static void main(String[] args) {

		File file = new File("C:\\Users\\Administrator\\Videos\\5月2日\\5月2日.mp4");
		division(file, 1024*1024*20);
	}

}
