package reflect01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import domain.Person;

/*
 * 案例：
 * 需求：写一个"框架"，不能改变该类的任何代码的前提下，可以帮我们创建任意类的对象，并且执行其中任意方法
	* 实现：
		1. 配置文件
		2. 反射
 */

/*
 * 步骤：
	1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
	2. 在程序中加载读取配置文件
	3. 使用反射技术来加载类文件进内存
	4. 创建对象
	5. 执行方法
 */
public class ReflectTest {
	public static void main(String[] args) throws Exception, Throwable{
		 
		//从pro.properties中获取类名称和方法名称
		File propertiesFile = new File("E:\\java_project\\junit\\src\\reflect01\\pro.properties");
		Properties proConfig = new Properties();
		proConfig.load(new FileInputStream(propertiesFile));
		String className = (String)proConfig.get("className");
		String methodName = (String) proConfig.get("methodName");
		
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




