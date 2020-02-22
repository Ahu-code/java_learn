package HeiMa;

import java.io.IOException;
import java.io.PrintStream;

/*
 * 改变打印流向
 * System.out 就是PrintStream 类型的，只不过它的流向是系统规定的，打印在控制台上。
 * 不过，既然是流对象，我们就可以玩一个"小把戏"，改变它的流向。
 * 
 * 使用System.setOut方法改变输出语句的目的地改为参数中传递的打印流的目的地
 * static void setOut(PrintStream out) 
 * 重新分配标准输出流。  
 */
public class PrintStream02 {
	public static void main(String[] args) throws IOException {
		System.out.println("在控制台输出");
		
		PrintStream ps = new PrintStream("F:\\a.txt");
		System.setOut(ps);
		System.out.println("在文件输出");
		ps.close();
	}
}
