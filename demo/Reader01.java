package HeiMa;

import java.io.FileReader;
import java.io.IOException;

/*
 * 使用字节流读入中文字符
 * 一个中文：
 * 		GBK：占用两个字节
 * 		UTF-8：占用三个字节
 */
/*
 * 带reader的就是字符流，带stream的是字节流
 * 
 * 字符输入流【Reader】
 * java.io.Reader 抽象类是表示用于读取字符流的所有类的超类，可以读取字符信息到内存中。
 * 它定义了字符输入流的基本共性功能方法。
 * public void close() ：关闭此流并释放与此流相关联的任何系统资源。
 * public int read() ： 从输入流读取一个字符。
 * public int read(char[] cbuf) ： 从输入流中读取一些字符，并将它们存储到字符数组 cbuf中 。
 */

/*
 * FileReader 文件字符流，以字符方式读入内存中
 * 构造方法
 * FileReader(File file) ： 创建一个新的 FileReader ，给定要读取的File对象。
 * FileReader(String fileName) ： 创建一个新的 FileReader ，给定要读取的文件的名称。
 */
public class Reader01 {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("F:\\a.txt");
		
		int len = 0;
		/*while((len = fr.read()) != -1)
			System.out.print((char)len);*/
		
		char[] ch = new char[1024];
		while((len = fr.read(ch)) != -1)
			System.out.println(new String(ch, 0, len));
		
		fr.close();
	}
}	




