package reflect01;

import java.lang.reflect.Constructor;

import domain.Person;

/*
 * 	* Constructor<?>[] getConstructors()  
	* Constructor<T> getConstructor(类<?>... parameterTypes)  
	* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)  
	* Constructor<?>[] getDeclaredConstructors()
 */
/*
 * * Constructor:构造方法
		* 创建对象：
			* T newInstance(Object... initargs)  

			* 如果使用空参数构造方法创建对象，操作可以简化：Class对象的newInstance方法
 */
public class reflectConstructor {
	public static void main(String[] args) throws Exception, Throwable {
		Class personClass = Person.class;
		
		Constructor construtor = personClass.getConstructor(String.class, int.class);
		System.out.println(construtor);
		
		Object person = construtor.newInstance("張三", 23);
		System.out.println(person);

		Constructor constructor1 = personClass.getConstructor();
		Object o = constructor1.newInstance();
		System.out.println(o);
		
		Constructor[] constructors = personClass.getConstructors();
		for(Constructor co : constructors)
			System.out.println(co);
	}
}
