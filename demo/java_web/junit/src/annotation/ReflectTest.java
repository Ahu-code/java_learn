package annotation;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/*
 * 案例 ：
 * 需求：写一个"框架"，不能改变该类的任何代码的前提下，可以帮我们创建任意类的对象，并且执行其中任意方法
	* 实现：
		1. 配置文件
		2. 反射
 */

@Pro(className = "annotation.Demo1", methodName = "show1")
public class ReflectTest {
	public static void main(String[] args) throws Exception, Throwable{
		 
		//1.解析注解
		//1.1获取该类的字节码文件对象
		Class reflectTestClass = ReflectTest.class;
		//2.获取上边的注解对象
		//其实就是在内存中生成了一个该注解接口的子类实现对象
		/*
		 * public <A extends Annotation> A getAnnotation(类<A> annotationClass)
		 * annotationClass -对应的注释类型的类对象 
		 * 如果存在此注释，则返回此元素的指定类型的注释，否则为空。 
		 */
		
		Pro an = (Pro) reflectTestClass.getAnnotation(Pro.class);//获取Class对象
		//即an为注释所返回的类对象
		
		//3.调用注解对象中定义的抽象方法，获取返回值
		String className = an.className();
		String methodName = an.methodName();
		
		System.out.println(className);
		System.out.println(methodName);
		
		

		//根据类名称获取类对象
		Class cls = Class.forName(className);
		//根据方法名称，获取方法对象
		Method method = cls.getMethod(methodName);
		//获取构造器
		Constructor con = cls.getConstructor();

		//根据构造器，实例化出对象
		Object service = con.newInstance();

		//调用对象的指定方法
		method.invoke(service);
	}
}




