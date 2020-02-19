package HeiMa;

import java.io.FileWriter;
import java.io.IOException;

/*
 * flush 与 close的区别
 * 那么这样一来我们如果中途调用close()方法，输出区也还是有数据的，
 * 就像水缸里有水，只是在缓冲区遗留了一部分，
 * 这时如果我们先调用flush()方法，就会强制把数据输出，缓存区就清空了，最后再关闭读写流调用close()就完成了。
 */

/*
 * 续写和换行：操作类似于FileOutputStream。
 * FileWriter(String name, boolean append) 
 * 创建文件输出流以指定的名称写入文件。 
 * 		String name 和 File file	 写入数据的目的地
 * 		boolean append :追加开关
 * 			true:创建对象不会覆盖原文件，继续在文件的末尾追加数据
 * 			false:创建新文件覆盖原文件
 */
public class Writer02 {
	 public static void main(String[] args) throws IOException {
			FileWriter fw = new FileWriter("F:\\a.txt",false);
			
			//写入字符数组
//			char[] ch = {'a','b','c'};
//			fw.write(ch);

			//写入字符串
			fw.write("字符串",0,2);//第三参数为长度
			
			//续写
			for (int i = 0; i < 10; i++) {
				fw.write("HelloWorld!"+i+"\n");
			}
			
			fw.flush();
			fw.close();
			
		 }
}
