import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * File类的使用
 * @author Administrator
 *
 */
public class FileDemo {

	public static void main(String[] args) {

		//File类表示一个文件或目录
		// "C:/TEST1/vince.txt"
		// "C:\\TEST1\\vince.txt"
		File f1 = new File("C:"+File.separator+"TEST1"+File.separator+"vince.txt");
		if (!f1.exists()) {//判断文件是否存在
			try {
				f1.createNewFile(); //创建新文件
				System.out.println("文件创建成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//f1.isFile():是否为文件
		System.out.println("是否为文件:"+f1.isFile());//是否为文件:true
		System.out.println("是否为文件夹:"+f1.isDirectory());//是否为文件夹:false
		
		File f2 = new File("C:\\TEST1\\my");
		boolean b = f2.delete(); //删除单独的文件是没问题的,但是删除文件夹不行,必须要保证文件夹里为空文件
		System.out.println(b);
		
		String[] names = f2.list();//列出当前目录下的所有文件名
		System.out.println(Arrays.toString(names));
		
		File[] fs = f2.listFiles();//列出当前目录下的所有文件,以file对象返回
		for (File file : fs) {
			System.out.println("length= "+file.length());
			System.out.println("name= "+file.getName());
			System.out.println("相对路径= "+file.getPath());//相对路径
			System.out.println("绝对路径= "+file.getAbsolutePath());//绝对路径
			System.out.println("是否为隐藏文件= "+file.isHidden());
			System.out.println("是否可读= "+file.canRead());
			System.out.println("是否可写= "+file.canWrite());
			Date date = new Date(file.lastModified());
			DateFormat df = new SimpleDateFormat("HH:mm:ss");
			System.out.println("文件最后修改的时间= "+df.format(date));
			System.out.println("--------------");
			
		}
		//相对路径与绝对路径的区别
		File f3 = new File("temp.txt"); //这是相对路径的写法
		System.out.println(f3.getPath());
		System.out.println(f3.getAbsolutePath());
//		temp.txt
//		C:\Users\root\eclipse-workspace\IODemo\temp.txt //绝对路径
		
		//
		File f4 = new File("C:\\TEST1\\class1");
		//f4.mkdir();
		f4.mkdirs();  //可用于创建含有子级目录
		//重命名与移动文件
		//f4.renameTo(new File("C:\\TEST1\\class2"));
		f4.renameTo(new File("C:\\class1"));
		
		File f5 = new File("C:\\TEST1\\my");
//		File[] files = f5.listFiles(new FileFilter() {
//			
//			@Override
//			public boolean accept(File pathname) {
//				return pathname.getName().endsWith(".txt");
//			}
//		});
		//当上面这种new了一个接口里面只有一个方法发情况 还可以用lambda表达式
		File[] files = f5.listFiles((pathname) -> pathname.getName().endsWith(".txt"));
		System.out.println("-------------------------");
		for (File file : files) {
			System.out.println(file.getName());
		}
	}

}
