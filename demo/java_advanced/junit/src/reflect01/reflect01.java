package reflect01;

import domain.Person;

/*
 * 获取Class对象的方式：（对应java中的三个阶段）
1.第一个阶段：通过Class.forName("全类名")将字节码文件加载进内存。
2.第二个阶段：通过类名的属性class获取。
3.三： 对象.getClass()  Object类中方法 getClass() 返回该Object运行时类。
 */
public class reflect01 {
	public static void main(String[] args) throws ClassNotFoundException {
		//1.Class.forName("类名")
		Class cls1 = Class.forName("domain.Person");;
		System.out.println(cls1);
		//2.类名.Class
		Class cls2 = Person.class;
		System.out.println(cls2);
		//3. 对象.getClass() 
		Person p = new Person();
		Class cls3 = p.getClass();
		System.out.println(cls3);
		
		System.out.println(cls1 == cls2);
		System.out.println(cls1 == cls3);
		//* 结论：
		//同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，不论通过哪一种方式获取的Class对象都是同一个。
	}
}
