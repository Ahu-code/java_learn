package HeiMa;

import java.io.FileWriter;
import java.io.IOException;

/*
 * IO异常处理
 * try {
 * //创建流对象
 * 	  	fw = new FileWriter("fw.txt");
 * // 写出数据
 * } catch (IOException e) {
 * 		e.printStackTrace();
 * }
 */
public class tryCatch01 {
	public static void main(String[] args) {
		FileWriter fw;
		//提高fw的作用域，让finally也可使用
		//需要注意的是，变量在定义时，可以没有值，但使用时必须有值
		//fw = new FileWriter("F:\\a.txt",true);若此时创建失败，则fw没有值，finally也不能执行
		//因此，给他个空
		fw = null;
		try {
			fw = new FileWriter("F:\\b.txt",true);//若此时创建失败，则fw没有值，finally也不能执行
			
			for (int i = 0; i < 10; i++) {
				fw.write("HelloWorld!"+i+"\n");
			}
			fw.flush();
			
		}catch(IOException e) {
			System.out.println(e);
		}finally {
			if(fw!=null)//因为fw为null时，会抛出空指针异常
				try {
					fw.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
		}
	}
}


