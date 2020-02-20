package HeiMa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * IO异常处理(JDK9的新特性)
 * JDK9的改进(扩展知识点了解内容)
 * JDK9中try-with-resource 的改进，对于引入对象的方式，支持的更加简洁
 * 对JDK7进行优化
 * ----------
 * A a = new A();
 * B b = new B();
 * try (a;b) {
 * // 读写数据
 * } catch (IOException e) {
 * 		e.printStackTrace();
 * }
 * 即不用写finally
 */

public class tryCatchJDK9 {
	public static void main(String[] args) throws IOException {
		//本身有异常 便进行一个throws抛出
		FileInputStream fis = new FileInputStream("F:\\a.txt");
		FileOutputStream fos = new FileOutputStream("F:\\b.txt");
		try (fis;fos){
			int len = 0;
			while((len=fis.read()) != -1) {
				fos.write(len);
			}
			
		}catch(IOException e) {
			System.out.println(e);
		}
		
		//fos.write(1);		//Stream Closed即流已经被释放了
	}
}
