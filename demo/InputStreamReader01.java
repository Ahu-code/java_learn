package HeiMa;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 转换流java.io.InputStreamReader ，是Reader的子类，是从字节流到字符流的桥梁。
 * 它读取字节，并使用指定的字符集将其解码为字符。它的字符集可以由名称指定，也可以接受平台的默认字符集。
 * 构造方法
 * InputStreamReader(InputStream in) : 创建一个使用默认字符集的字符流。
 * InputStreamReader(InputStream in, String charsetName) : 创建一个指定字符集的字符流。
 * 		String charsetName指定编码名称，不区分大小写，默认为utf-8
 */
public class InputStreamReader01 {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream("F:\\a.txt"), "GBK");
		
		int len = 0;
		while( (len=isr.read()) != -1 )
			System.out.println((char) len);
		
		isr.close();
	}
}
