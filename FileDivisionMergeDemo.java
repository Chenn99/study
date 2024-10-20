import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

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
	private static void merge(Enumeration<InputStream> es) {
		//构造一个合并流
		SequenceInputStream sis = new SequenceInputStream(es);
		try {
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream("c:\\1-temp-5月2日.mp4"));
			
			byte[] bytes = new byte[1024];
			int len =-1;
			while ((len = sis.read(bytes))!= -1) {
				bos.write(bytes,0,len);
				bos.flush();
			}
			bos.close();
			sis.close();
			System.out.println("合并完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {

//		File file = new File("C:\\Users\\Administrator\\Videos\\5月2日\\5月2日.mp4");
//		division(file, 1024*1024*20);
		
		try {
			InputStream in1 = new FileInputStream(new File("C:\\1-temp-5月2日.mp4"));
			InputStream in2 = new FileInputStream(new File("C:\\2-temp-5月2日.mp4"));
			InputStream in3 = new FileInputStream(new File("C:\\3-temp-5月2日.mp4"));
			InputStream in4 = new FileInputStream(new File("C:\\4-temp-5月2日.mp4"));
			InputStream in5 = new FileInputStream(new File("C:\\5-temp-5月2日.mp4"));
			InputStream in6 = new FileInputStream(new File("C:\\6-temp-5月2日.mp4"));
			InputStream in7 = new FileInputStream(new File("C:\\7-temp-5月2日.mp4"));
			InputStream in8 = new FileInputStream(new File("C:\\8-temp-5月2日.mp4"));
			InputStream in9 = new FileInputStream(new File("C:\\9-temp-5月2日.mp4"));
			InputStream in10 = new FileInputStream(new File("C:\\10-temp-5月2日.mp4"));
			InputStream in11 = new FileInputStream(new File("C:\\11-temp-5月2日.mp4"));
			InputStream in12 = new FileInputStream(new File("C:\\12-temp-5月2日.mp4"));
			InputStream in13 = new FileInputStream(new File("C:\\13-temp-5月2日.mp4"));
			InputStream in14 = new FileInputStream(new File("C:\\14-temp-5月2日.mp4"));
			InputStream in15 = new FileInputStream(new File("C:\\15-temp-5月2日.mp4"));
			InputStream in16 = new FileInputStream(new File("C:\\16-temp-5月2日.mp4"));
			InputStream in17 = new FileInputStream(new File("C:\\17-temp-5月2日.mp4"));
			InputStream in18 = new FileInputStream(new File("C:\\18-temp-5月2日.mp4"));
			InputStream in19 = new FileInputStream(new File("C:\\19-temp-5月2日.mp4"));
			InputStream in20 = new FileInputStream(new File("C:\\20-temp-5月2日.mp4"));
			InputStream in21 = new FileInputStream(new File("C:\\21-temp-5月2日.mp4"));
			
			//集合工具类,内部实现使用了数组
			Vector<InputStream> v = new Vector<InputStream>();
			v.add(in1);
			v.add(in2);
			v.add(in3);
			v.add(in4);
			v.add(in5);
			v.add(in6);
			v.add(in7);
			v.add(in8);
			v.add(in9);
			v.add(in10);
			v.add(in11);
			v.add(in12);
			v.add(in13);
			v.add(in14);
			v.add(in15);
			v.add(in16);
			v.add(in17);
			v.add(in18);
			v.add(in19);
			v.add(in20);
			v.add(in21);
			
			Enumeration<InputStream> es = v.elements();
			merge(es);
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
