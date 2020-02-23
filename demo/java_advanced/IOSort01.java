package HeiMa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


/*
 * 对出师表多个标好序号的句子进行排序（1.2.3. ....）
 * 
 * 1.创建Map集合 键存储序号
 * 2.使用字符缓冲输入流中的readline 逐行读取文本
 * 3.对读取文本进行切割，获取行中序号和文本内容
 * 4.切割后进行存储（key有序，会自动排序）
 * 5.遍历map集合，获取每个键值对，拼接为一个文本
 * 6.字符缓冲输出流，write ， 并运用newLine方法
 * 7.close
 */
public class IOSort01 {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new FileReader("F:\\b.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\a.txt"));
			
			HashMap<String, String> map = new HashMap<String, String>();
			
			String line;
			while( (line = br.readLine() ) != null) {
				String[] arr = line.split("\\.");
				map.put(arr[0], arr[1]);
			}
			
			
			for(String key:map.keySet()) {
				System.out.println(key);
				String value = map.get(key);
				line = key + "." + value;
				bw.write(line);
				bw.newLine();
			}
			bw.close();	
			
			br.close();		
		}
}




