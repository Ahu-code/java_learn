package HeiMa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * 练习：序列化集合
 * 当我们想把多个对象存在文件中时，可以先将其存储到一个集合中，再进行序列化和反序列化
 * 1. 将存有多个自定义对象的集合序列化操作，保存到list.txt 文件中。
 * 2. 反序列化list.txt ，并遍历集合，打印对象信息。
 * 步骤：
 * 1. 把若干学生对象 ，保存到集合中。
 * 2. 把集合序列化。
 * 3. 反序列化读取时，只需要读取一次，转换为集合类型。
 * 4. 遍历集合，可以打印所有的学生信息
 */
public class SerialTest01 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person("张三",18));
		list.add(new Person("李四",19));
		list.add(new Person("王五",28));
		list.add(new Person("赵六",58));
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:\\a.txt"));
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\a.txt"));
		
		oos.writeObject(list);
		
		Object o = ois.readObject();
		ArrayList<Person> list2 = (ArrayList<Person>) o;
		for(Person p:list2)
			System.out.println(p);
		
		oos.flush();
		oos.close();
		ois.close();
	}
}
