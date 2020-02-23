package HeiMa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopybyIO {
	public static void main(String[] args) throws IOException {
		long s = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream("F:\\1.jpg");
		FileOutputStream fos = new FileOutputStream("F:\\2.jpg");
		
		
		/*int len = 0;
		while((len=fis.read())!=-1)
			fos.write(len);*/
		
		
		
		//使用 数组进行缓存
		byte[] bytes = new byte[4096];
		int len=0;
		while((len=fis.read(bytes))!=-1)
			fos.write(bytes, 0, len);
		
		//流的关闭原则：先开后关，后开先关。
		fos.close();
		fis.close();
		long e = System.currentTimeMillis();
		System.out.println("复制文件共耗时："+(e-s)+"毫秒");
	}
}
