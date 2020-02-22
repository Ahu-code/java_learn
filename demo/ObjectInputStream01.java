package HeiMa;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
 * ObjectInputStream反序列化流，将之前使用ObjectOutputStream序列化的原始数据恢复为对象。
 * 构造方法
 * public ObjectInputStream(InputStream in) ： 创建一个指定InputStream的ObjectInputStream。
 * 反序列化操作1
 * 如果能找到一个对象的class文件，我们可以进行反序列化操作，调用ObjectInputStream 读取对象的方法：
 * public final Object readObject () : 读取一个对象。
 * 
 * 实例化举例：
  		FileInputStream fis = new FileInputStream("F:\\a.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
 */
public class ObjectInputStream01 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("F:\\a.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object o = ois.readObject();
		
		System.out.println(o);
		Person p = (Person)o;
		System.out.println(p.getName()+p.getAge());
		
		ois.close();
	}
}
