package HeiMa;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/*
 * 属性集
 * java.util.Properties 继承于Hashtable ，来表示一个持久的属性集。
 * 是一个双列集合		Map-Hashtable-Properties类
 * 它使用键值结构存储数据，每个键及其对应值都是一个字符串。
 * 该类也被许多Java类使用，比如获取系统属性时， System.getProperties 方法就是返回一个Properties 对象
 */
public class Properties01 {
	public static void main(String[] args) throws IOException {
//		show01();
		show02();
		show03();
	}
	
	//使用properties集合存储数据
	/*
	 * setProperty(String key, String value) 
	 * 	     调用 Hashtable方法 put 。
	 * getProperty(String key) 
	 * 	使用此属性列表中指定的键搜索属性。相当于map集合的get 
	 * stringPropertyNames() 返回键集 相当于map中的Set方法
	 */
//	private static void show01() {
//		Properties prop = new Properties();
//		prop.setProperty("赵丽颖", "168");
//		prop.setProperty("佟丽娅", "165");
//		prop.setProperty("古力娜扎", "166");
//		prop.setProperty("迪丽热巴", "169");
//		
//		System.out.println(prop.stringPropertyNames());
//		
//		Set<String> set = prop.stringPropertyNames();
//		
//		for(String key:set) {
//			String value = prop.getProperty(key);
//			System.out.println(key+"="+value);
//		}
//	}
	
	/*
	 * void store(OutputStream out, String comments) 字节流
	 * void store(Writer writer, String comments) 字符流
	 * 		String comments：注释，用于解释说明保存文件是干啥
	 * 		不能使用中文，一般用空字符串
	 */
	private static void show02() throws IOException {
		Properties prop = new Properties();
		prop.setProperty("赵丽颖", "168");
		prop.setProperty("佟丽娅", "165");
		prop.setProperty("古力娜扎", "166");
		prop.setProperty("迪丽热巴", "169");
		
		FileWriter fw = new FileWriter("F:\\a.txt");
		prop.store(fw, "sava data");
		fw.close();
		
		/*FileOutputStream fos = new FileOutputStream("F:\\a.txt");
		prop.store(fos, "fos-sava data");//发现一堆乱码，即说明不能写中文		
		fos.close();*/
	}
	
	/*
	 * load(InputStream inStream) 读取属性列表（键和元素对）。字节输入流
	 * load(Reader reader) 读取属性列表（键和元素对）。  字符输入流
	 * 
	 * 存储键值对的文件中，可以用#进行注释
	 * 键值对默认均为字符串，不用加引号
	 * 文本中的数据，必须是键值对形式，可以使用空格、等号、冒号等符号分隔。
	 */
	private static void show03() throws IOException{
		Properties prop = new Properties();
		
		prop.load(new FileInputStream("F:\\a.txt"));
		
		Set<String> set = prop.stringPropertyNames();
		
		for(String key:set) {
			String value = prop.getProperty(key);
			System.out.println(key+"="+value);//加入一个注释后，就不会读取了
		}
	}
}


