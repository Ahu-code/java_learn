package reflect01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import domain.Person;

/*
* 3. 获取成员方法们：
		* Method[] getMethods()  
		* Method getMethod(String name, 类<?>... parameterTypes)  
		* Method[] getDeclaredMethods()  
		* Method getDeclaredMethod(String name, 类<?>... parameterTypes) 
 */
/*
 * * Method：方法对象
	--->执行方法：
		* Object invoke(Object obj, Object... args)  
	--->获取方法名称：
		* String getName:获取方法名
 */
public class reflectMethod {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class personClass = Person.class;
		
		Method eat_method = personClass.getMethod("eat");
		
		Person p = new Person();
		eat_method.invoke(p);
		
		Method eatFood_method = personClass.getMethod("eat", String.class);
		eatFood_method.invoke(p,"饭");
		
		/*System.out.println("..............");
		Method[] methods = personClass.getMethods();
		for(Method m : methods)
			System.out.println(m);*/
		
		System.out.println("--------------------------");
		Method[] methods = personClass.getMethods();
		for(Method m : methods)
			System.out.println(m.getName());
		
		//获取类名
		System.out.println("--------------------------");
		String className = personClass.getName();
		System.out.println(className);
	}
}



