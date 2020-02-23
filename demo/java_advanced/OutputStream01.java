package HeiMa;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
 * java.io.OutputStream 抽象类是表示字节输出流的所有类的超类，将指定的字节信息写出到目的地。它定义了字
 * 节输出流的基本共性功能方法。
 * public void close() ：关闭此输出流并释放与此流相关联的任何系统资源。
 * public void flush() ：刷新此输出流并强制任何缓冲的输出字节被写出。
 * public void write(byte[] b) ：将 b.length字节从指定的字节数组写入此输出流。
 * public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
 * public abstract void write(int b) ：将指定的字节输出流。
 * 
 * 
 */
/*
 * 构造方法
 * FileOutputStream(File file)
 * 创建文件输出流以写入由指定的 File对象表示的文件。
 * FileOutputStream(String name)
 * 创建文件输出流以指定的名称写入文件。 
 */
/*
 * 字节输出流的使用步骤：
 * 1.创建一个FileOutputStream对象，构造方法写入数据的目的地
 * 2.调用FileOutpuStream对象中的write方法，将数据写入文件中
 * 3.释放资源
 */

public class OutputStream01 {
	public static void main(String[] args) throws IOException {
		//1.创建一个FileOutputStream对象，构造方法写入数据的目的地
		FileOutputStream fos = new FileOutputStream("F:\\b\\b.txt");
		//2.调用FileOutpuStream对象中的write方法，将数据写入文件中
		fos.write(97);
		/*若一次性写多个字节：
		 * 	若第一个字节为正，那么显示ASCII表
		 * 	若第一个为负数，则与第二个一起组成中文
		 */
		
		byte[] bytes = {65,66,67,68,69};//a烤紻E
		fos.write(bytes);
		
		//public void write(byte[] b, int off, int len) ：
		//从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
		fos.write(bytes, 1, 2);
		
		//写入字符串方法
		byte[] bytes2 = "你好".getBytes();
		System.out.println(Arrays.toString(bytes2));//[-28, -67, -96, -27, -91, -67]
		fos.write(bytes2);
		//3.释放资源
		fos.close();
	}
}
