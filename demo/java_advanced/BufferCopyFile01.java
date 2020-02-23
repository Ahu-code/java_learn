package HeiMa;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 效率测试， 与之前copy文件作对比
 * 步骤：
 * 		1.创建字节缓冲输入流，构造方法中传入字节输入流（new
 * 		2.创建字节缓冲输出流，构造方法中传入字节输出流（new
 * 		3.使用read
 * 		4.使用write
 * 		5.释放
 */
public class BufferCopyFile01 {
	public static void main(String[] args) throws IOException {
		
		long s0 = System.currentTimeMillis();
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\1.jpg"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("F:\\2.jpg"));
		
		
		int len = 0;
		byte[] bytes = new byte[4096];
		while( (len = bis.read(bytes)) != -1 ) {
			bos.write(bytes, 0, len);
		}
		bos.close();
		bis.close();//关闭的是缓冲流
		
		long s1 = System.currentTimeMillis();
		System.out.println((s1-s0) + "毫秒");
	}
}

