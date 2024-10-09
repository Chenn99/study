import java.io.File;

/**
 * 在指定的目录中查找文件
 * @author Administrator
 *
 */
public class FileDemo2 {

	public static void main(String[] args) {

		findFile(new File("C:\\Users\\Administrator\\Pictures\\素材"), ".jpg");
		
	}
	
	// 查找文件的方法
	private static void findFile(File target,String ext) {
		if (target==null) return; //如果是空的场合
		//如果得到的文件是目录
		if (target.isDirectory()) {
			File[] files = target.listFiles();
			if (files!=null) {
				for (File file : files) {
					findFile(file, ext);//递归调用
				}
			}
		}else {
			//此处表示File是一个文件
			String name = target.getName().toLowerCase();//区分大小写,统一转成小写
			//System.out.println(name);
			if (name.endsWith(ext)) {
				System.out.println(target.getAbsolutePath());
			}
		}
	}

}
