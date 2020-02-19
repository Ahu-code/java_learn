package HeiMa;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 使用两个参数的构造方法即可
 * FileOutputStream(File file, boolean append) 
 * 创建文件输出流以写入由指定的 File对象表示的文件。 
 * FileOutputStream(String name, boolean append) 
 * 创建文件输出流以指定的名称写入文件。 
 * 		String name 和 File file	 写入数据的目的地
 * 		boolean append :追加开关
 * 			true:创建对象不会覆盖原文件，继续在文件的末尾追加数据
 * 			false:创建新文件覆盖原文件
 */
public class OutputSteam02 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("F:\\b\\c.txt",true);
		fos.write("你好".getBytes());
		fos.write("\r\n".getBytes());
		fos.write("旧时光".getBytes());
		fos.close();
	}
}
