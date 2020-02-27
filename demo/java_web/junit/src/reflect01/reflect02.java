package reflect01;


import java.lang.reflect.Field;

import domain.Person;

/*
 * Class对象功能：
		* 获取功能：
			1. 获取成员变量们
				* Field[] getFields() ：获取所有public修饰的成员变量
				* Field getField(String name)   获取指定名称的 public修饰的成员变量

				* Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
				* Field getDeclaredField(String name)  
			2. 获取构造方法们
				* Constructor<?>[] getConstructors()  
				* Constructor<T> getConstructor(类<?>... parameterTypes)  

				* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)  
				* Constructor<?>[] getDeclaredConstructors()  
			3. 获取成员方法们：
				* Method[] getMethods()  
				* Method getMethod(String name, 类<?>... parameterTypes)  

				* Method[] getDeclaredMethods()  
				* Method getDeclaredMethod(String name, 类<?>... parameterTypes)  

			4. 获取全类名	
				* String getName()  
 */
public class reflect02 {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class personClass = Person.class;
		
		Field[] fields = personClass.getFields();
		for(Field filed:fields) {
			System.out.println(filed);
		}
		System.out.println("-----------------------------");
		Field field1 = personClass.getField("a");//獲取指定名稱
		
		//獲取成員變量a
		Person p = new Person();
		Object value = field1.get(p);
		System.out.println(value);
		field1.set(p, 1000);
		System.out.println(p);
		//------------------
		Field[] declareFields = personClass.getDeclaredFields();
		for(Field declareField : declareFields)
			System.out.println(declareField);
		System.out.println("-----------------------------");
		Field c = personClass.getDeclaredField("c");
		/*Object value2 = c.get(p);
		System.out.println(value2);*///IllegalAccessException--->由於這是private，需要忽略修飾符檢查
		c.setAccessible(true);//暴力反射
		Object value3 = c.get(p);
		System.out.println(value3);
	}
}



