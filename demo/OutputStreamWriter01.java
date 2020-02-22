package HeiMa;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * 转换流java.io.OutputStreamWriter ，是Writer的子类，是从字符流到字节流的桥梁。使用指定的字符集将字符
 * 编码为字节。它的字符集可以由名称指定，也可以接受平台的默认字符集。
 * 构造方法
 * OutputStreamWriter(OutputStream in) : 创建一个使用默认字符集的字符流。
 * OutputStreamWriter(OutputStream in, String charsetName) : 创建一个指定字符集的字符流。
 * 		String charsetName指定编码名称，不区分大小写，默认为utf-8
 */
public class OutputStreamWriter01 {
	public static void main(String[] args) throws IOException {
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("F:\\a.txt"), "GBK");
		osw.write("你好");
		osw.flush();
		osw.close();
	}
}
