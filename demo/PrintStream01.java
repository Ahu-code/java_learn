package HeiMa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/*
 * 打印流
 * FilterOutputStream  extends OutputStream  
 * 平时我们在控制台打印输出，是调用print 方法和println 方法完成的，这两个方法都来自于
 * java.io.PrintStream 类，该类能够方便地打印各种数据类型的值，是一种便捷的输出方式。
 * PrintStream类
 * 构造方法
 * public PrintStream(String fileName) ： 使用指定的文件名创建一个新的打印流。
 * 构造举例，代码如下：
 * PrintStream ps = new PrintStream("ps.txt")；
 * 
 * 构造方法   
 * PrintStream(File file) 创建一个新的打印流，不带自动行刷新，用指定的文件。  
 * PrintStream(OutputStream out) 创建一个新的打印流。  
 * PrintStream(String fileName) 创建一个新的打印流，没有自动行刷新，用指定的文件名。  
 */
public class PrintStream01 {
	public static void main(String[] args) throws IOException {
		PrintStream ps = new PrintStream("F:\\a.txt");
		ps.write(97);
		ps.println(97);
		ps.close();
	}
}
