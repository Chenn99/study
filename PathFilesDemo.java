package NIODemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

/**
 * JDK1.7新的文件操作类
 * Path接口
 * Path类
 * Files类
 * @author Administrator
 *
 */
public class PathFilesDemo {

	public static void main(String[] args) {
		File file = new File("C:\\TEST1\\class\\test.txt");
		
		//path
		//得到路径的三种方式
		Path p1 = Paths.get("C:\\TEST1\\class","test.txt");
		System.out.println(p1);
		
		Path p2 = file.toPath();
		System.out.println(p2);
		
		Path p3 = FileSystems.getDefault().getPath("C:\\TEST1","test.txt");
		
		//Files工具类
//		Path p4 = Paths.get("C:\\TEST1\\test.txt");
//		String info = "小河流水哗啦啦...";
//		try {
//			//写入文件
//			Files.write(p4, info.getBytes("gb2312"), StandardOpenOption.APPEND);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//读取文件
//		try {
//			byte[] bytes = Files.readAllBytes(p4);
//			System.out.println(new String(bytes));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//复制文件
//		try {
//			Files.copy(p3, Paths.get("C:\\test.txt"),StandardCopyOption.REPLACE_EXISTING);//存在,替换原文件
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//移动文件
//		try {
//			//Files.move(p3, Paths.get("C:\\test.txt"),StandardCopyOption.ATOMIC_MOVE);
//			Files.move(p3, Paths.get("C:\\test.txt"),StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//删除文件
//		try {
//			Files.delete(p3);
//			System.out.println("删除成功!");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//创建新目录,除了最后一个部件,其他必须是已存在的
//		try {
//			Files.createDirectories(Paths.get("C:\\test10"));
//			//Files.createDirectories(path);//创建多级不存在的目录
//			System.out.println("文件夹创建成功");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//创建文件
		try {
			Files.createFile(Paths.get("C:\\text10.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//添加前/后缀创建临时文件或临时目录
//		Path newPath = Files.createTempFile(dir, prefix, suffix);
//		Path newPath = Files.createDirectory(dir, prefix);
	}
}
