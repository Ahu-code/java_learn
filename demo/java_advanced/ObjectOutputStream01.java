package HeiMa;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * 
 * 3.2 ObjectOutputStream类
 * java.io.ObjectOutputStream 类，将Java对象的原始数据类型写出到文件,实现对象的持久存储。
 * 构造方法：
 * protected  ObjectOutputStream() 
 * 为完全重新实现ObjectOutputStream的子类提供一种方法，不必分配刚刚被ObjectOutputStream实现使用的私有数据。  
 * ObjectOutputStream(OutputStream out) 
 * 创建一个写入指定的OutputStream的ObjectOutputStream。  
 * 构造举例，代码如下：
		FileOutputStream fos = new FileOutputStream("F:\\a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new Person("小美女",18));
 * 
 * 
 * 序列化操作
 * 一个对象要想序列化，必须满足两个条件:
 * 1.  该类必须实现java.io.Serializable 接口， Serializable 是一个标记接口，(源码中啥都没有
 *   不实现此接口的类将不会使任何状态序列化或反序列化，会抛出NotSerializableException 。
 * 2.  该类的所有属性必须是可序列化的。如果有一个属性不需要可序列化的，则该属性必须注明是瞬态的，使用transient 关键字修饰。
 * 	(静态变量不能被序列化，因为其不为对象，而transient 关键字修饰为非静态，
 */

public class ObjectOutputStream01 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("F:\\a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new Person("小美女",18));
		
		oos.flush();
		oos.close();
		
	}
}
