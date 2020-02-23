package HeiMa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/*
 * IO异常处理(JDK7的新特性)
 * 可以使用JDK7优化后的try-with-resource 语句，该语句确保了每个资源在语句结束时关闭。
 * 所谓的资源（resource）是指在程序完成后，必须关闭的对象
 * ----------
 * try (创建流对象语句，如果多个,使用';'隔开) {
 * // 读写数据
 * } catch (IOException e) {
 * 		e.printStackTrace();
 * }
 * 即不用写finally
 */
public class tryCatchJDK7 {
	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("F:\\a.txt");
				FileOutputStream fos = new FileOutputStream("F:\\b.txt")){
			int len = 0;
			while((len=fis.read()) != -1) {
				fos.write(len);
			}
			
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
