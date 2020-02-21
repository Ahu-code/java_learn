package HeiMa;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 缓冲流,也叫高效流，是对4个基本的FileXxx 流的增强，所以也是4个流，按照数据类型分类： 
 * 字节缓冲流： BufferedInputStream ， BufferedOutputStream
 * 字符缓冲流： BufferedReader ， BufferedWriter
 * 缓冲流的基本原理，是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，
 * 通过缓冲区读写，减少系统IO次数，从而提高读写的效率。
 */

/* 字节缓冲流
 * public BufferedInputStream(InputStream in) ：创建一个 新的缓冲输入流。
 * public BufferedOutputStream(OutputStream out) ： 创建一个新的缓冲输出流。
 */
/*
 * BufferedOutputStream(OutputStream out) 创建一个新的缓冲输出流，以将数据写入指定的底层输出流。  （大小默认）
 * BufferedOutputStream(OutputStream out, int size)  创建一个新的缓冲输出流，以便以指定的缓冲区大小将数据写入指定的底层输出流。  
 * 				OutputStream out :字节输出流
 * 				size：指定缓冲流内部缓冲区大小
 * 步骤：
 * 		1.创建FileoutputStrem对象，绑定输出目的地
 * 		2.创建BufferedOutputStream对象，传递OutputStream对象，提高效率
 * 		3.使用BufferedOutputStream中的write方法，写入到内部缓冲区
 * 		4.使用BufferedOutputStream中的flush方法，刷新到文件中
 * 		5.释放资源，因此第四步可省略
 */

public class BufferOutPut01 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("F:\\a.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		bos.write("将数据写入缓冲区".getBytes());
		bos.flush();
		bos.close();
	}
	
}






