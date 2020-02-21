package HeiMa;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * 构造方法：
 * BufferedInputStream(InputStream in) 创建一个 BufferedInputStream并保存其参数，输入流 in ，供以后使用。  
 * BufferedInputStream(InputStream in, int size) 创建 BufferedInputStream具有指定缓冲区大小，并保存其参数，输入流 in ，供以后使用。  
 */
/*
 * 
 *  * 步骤：
 * 		1.创建FileInputStrem对象，绑定输出目的地
 * 		2.创建BufferedInputStream对象，传递OutInStream对象，提高效率
 * 		3.使用BufferedInputStream中的read方法，读取文件
 * 		4.使用BufferedInputStream中的flush方法，刷新到文件中
 * 		5.释放资源，因此第四步可省略
 */

public class BufferInput01 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("F:\\a.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		/*//记录每次读到的字节
		int len = 0;
		while( (len = bis.read()) != -1) {
			System.out.println(len);
		}*/
		
		//int read(byte[] b)
		byte[] bytes = new byte[1024];
		int len = 0;
		while( (len = bis.read(bytes)) != -1 ) {
			System.out.println(new String(bytes, 0, len));//String方法重点！！！
		}
		bis.close();//关闭的是缓冲流
		
	}
}



