package HeiMa;

import java.io.FileWriter;
import java.io.IOException;

/*
 * java.io.Writer 抽象类是表示用于写出字符流的所有类的超类，将指定的字符信息写出到目的地。它定义了字节
 * 输出流的基本共性功能方法。
 * void write(int c) 写入单个字符。
 * void write(char[] cbuf) 写入字符数组。
 * abstract void write(char[] cbuf, int off, int len) 写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
 * void write(String str) 写入字符串。
 * void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
 * void flush() 刷新该流的缓冲。
 * void close() 关闭此流，但要先刷新它。
 */

/*
 * FileWriter类
 * 构造方法
 * FileWriter(File file) ： 创建一个新的 FileWriter，给定要读取的File对象。
 * FileWriter(String fileName) ： 创建一个新的 FileWriter，给定要读取的文件的名称。
 */
/*
 *字符输出流使用步骤
 *	1. 使用FileWriter对象创建流对象
 *	2. 使用write方法，将数据写到内存缓冲区中(字符转化为字节的过程)
 *	3. 使用flush方法，将内存缓冲区中的数据，刷新到文件中————写到缓冲区中
 *	4. 释放资源(会先把内存缓冲区中的数据刷新到文件中) 
 *
 *flush:
 *	类比水管连接抽水机和水缸(水管就好比是缓冲区)
 * 	flush()这个函数是清空的意思，用于清空缓冲区的数据流，进行流的操作时，数据先被读到内存中，然后再用数据写到文件中，
 *	那么当你数据读完时，我们如果这时调用close()方法关闭读写流，这时就可能造成数据丢失，
 */
public class Writer01 {
	 public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("F:\\a.txt");
//		fw.write(97);
		/*
		 * flush 与 close的区别
		 * 那么这样一来我们如果中途调用close()方法，输出区也还是有数据的，
		 * 就像水缸里有水，只是在缓冲区遗留了一部分，
		 * 这时如果我们先调用flush()方法，就会强制把数据输出，缓存区就清空了，最后再关闭读写流调用close()就完成了。
		 */
		//fw.flush();
		//刷新以后流可以继续使用
		fw.write(98);
		
		fw.close();
		
	 }
	
}
