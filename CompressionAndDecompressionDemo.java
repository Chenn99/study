import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 压缩与解压缩
 * @author Administrator
 *
 */
public class CompressionAndDecompressionDemo {

	/**
	 * 压缩
	 * @param args
	 */
	private static void compression(String zipFileName,File targetFile) {
		System.out.println("正在压缩");
		try {
			//要生成的压缩文件
			ZipOutputStream zOut = new ZipOutputStream(new FileOutputStream(zipFileName));
			BufferedOutputStream bf = new BufferedOutputStream(zOut);
			zip(zOut,targetFile,targetFile.getName(),bf);
			bf.close();
			zOut.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("压缩完成");
	}
	
	//zip
	private static void zip(ZipOutputStream zOut, File targetFile, String name, BufferedOutputStream bf) throws Exception{
		//如果是目录
		if (targetFile.isDirectory()) {
			File[] files = targetFile.listFiles();
			if (files.length == 0) {//空文件夹
				zOut.putNextEntry(new ZipEntry(name+"/"));//处理空目录
			}
			for (File f : files) {
				//递归处理
				zip(zOut, f, name+"/"+f.getName(), bf);
			}
		//如果是文件
		}else {
			zOut.putNextEntry(new ZipEntry(name));
			InputStream in = new FileInputStream(targetFile);
			BufferedInputStream bis = new BufferedInputStream(in);
			byte[] bs = new byte[1024];
			int len = -1;
			while ((len=bis.read(bs))!=-1) {
				bf.write(bs,0,len);
			}
			bis.close();
		}
	}

	/**
	 * 解压
	 * @param args
	 */
	public static  void decopression(String targetFileName,String parent) {
		try {
			//构建解压的输入流
			ZipInputStream zis = new ZipInputStream(new FileInputStream(targetFileName));
			ZipEntry entry = null;
			File file = null;
			while ((entry=zis.getNextEntry())!=null && !entry.isDirectory()) {
				file= new File(parent,entry.getName());
				if (!file.exists()) {
					new File(file.getParent()).mkdirs();//创建此文件的上级目录
				}
				OutputStream out = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				byte[] bs = new byte[1024];
				int len = -1;
				while ((len=zis.read(bs))!=-1) {
					bos.write(bs,0,len);
				}
				bos.close();
				System.out.println(file.getAbsolutePath()+"解压成功");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//compression("c:\\test.zip",new File("C:\\TEST1\\my"));
		decopression("c:\\test.zip","C:\\TEST1"); 
	}

}
