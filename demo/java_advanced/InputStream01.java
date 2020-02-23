package HeiMa;

import java.io.FileInputStream;
import java.io.IOException;

/*
 *  FileInputStream(File file) 
 *  通过打开与实际文件的连接创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名。    
 *  FileInputStream(String name) 
 *  通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名 name命名。  
 *  参数：读取文件的数据源
 *  	String name 文件路径
 *  	File file 文件
 *  当你创建一个流对象时，必须传入一个文件路径。
 *  该路径下，如果没有该文件,会抛出FileNotFoundException 。
 *  
 *  读取数据原理：硬盘-》内存
 *  	java-》JVM-》Os-》Os读取数据的方法-》读取文件
 *  
 *  步骤：
 *  	1.创建FileInputStream对象，构造方法中绑定要读取的数据源
 *  	2.使用FileInputStream对象中的read方法，进行读取
 *  	3.释放资源
 */
public class InputStream01 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("F:\\b\\c.txt");
		int len = fis.read();
		System.out.println(len);
		
		int len01 = 0;
		while((len01=fis.read())!=-1) {
			System.out.println((char)len01);
		}
		
		fis.close();
	}
	
}
