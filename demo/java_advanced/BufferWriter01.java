package HeiMa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*	特有方法：根据系统不一样获取不同分隔符
 * void newLine() 
 * 	写一行行分隔符。  
 */

//步骤与writer差不多

public class BufferWriter01 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\a.txt"));
		
		for (int i = 0; i < 10; i++) {
			bw.write("快乐b站"+ i);
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
}
