package HeiMa;

import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;

/*
 * 特有方法：
 * String readLine() 
 * 读一行文字。  
 * 读一行文字。 一行被视为由换行符（'\ n'），回车符（'\ r'）中的任何一个或随后的换行符终止。  
 * 返回：包含行的内容的字符串，不包括任何行终止字符，如果已达到流的末尾，则为null 
 */
public class BufferReader01 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("F:\\a.txt"));
		
		String s;		
		while((s = br.readLine() )!=null) 
			System.out.println(s);
			
		br.close();
	}
}
