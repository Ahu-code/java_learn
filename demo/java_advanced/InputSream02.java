package HeiMa;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * 一次读入多个字节
 * 使用字节数组读取： read(byte[] b) ，每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读
 * 取到末尾时，返回-1 ，代码使用演示：
 */
/*
 * String(byte[] bytes) 
 * 通过使用平台的默认字符集解码指定的字节数组来构造新的 String 。 
 * String(byte[] bytes, int offset, int length) 
 * 通过使用平台的默认字符集解码指定的字节子阵列来构造新的 String 。 
 */
public class InputSream02 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("F:\\1.jpg");
	
		//用 read(byte[] b) 方法来读
//		byte[] bytes = new byte[2];
//		int len = fis.read(bytes);
//		System.out.println(len);
//		System.out.println(Arrays.toString(bytes));
//		System.out.println(new String(bytes));//ab
//		
//		
//		len = fis.read(bytes);
//		System.out.println(len);
//		System.out.println(Arrays.toString(bytes));
//		System.out.println(new String(bytes));//cb
//		//即数组具有缓冲作用，存储之前读取的多个个字节
//		//释放资源
		
		//进行优化，用数组进行缓存
		byte[] bytes = new byte[1024];
		int len = 0;
		while((len=fis.read(bytes)) != -1)
			System.out.println(new String(bytes, 0, len));

		fis.close();
	}
	
}
