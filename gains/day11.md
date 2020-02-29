---------------------------------------------------------
1.反射的作用初了解：
--1.非反射调用两个方法时，需要进行
-如：
public class Test {
    public static void main(String[] args) {
        new Student1().eat1();
    }
}
--->非反射调用两个方法时，需要进行修改代码+重新编译
public class Test {
    public static void main(String[] args) {
//      new Student1().eat1();
        new Student2().eat2();
    }
}
--2.而当用反射方式时，需要先准备一个配置文件就叫做spring.txt吧, 放在src目录下。 里面存放的是类的名称，和要调用的方法名。
'''
class=reflection.Student1
method=eat1
'''
在测试类Test中，首先取出类名称和方法名，然后通过反射去调用这个方法。
public class Test {
	public static void main(String[] args) throws Exception,Throwable{
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
--->因此，使用反射方法调用时，只需改变配置文件中的相关语句即可
------------------------------------------------------------
3.##注解：-->Alt+Shift+j
	* 概念：说明程序的。给计算机看的
	* 注释：用文字描述程序的。给程序员看的
	* 概念描述：
		* JDK1.5之后的新特性
		* 说明程序的
		* 使用注解：@注解名称
	* 作用分类：
		①编写文档：通过代码里标识的注解生成文档【生成文档doc文档】
	----->在shell中，进行javadoc + ’ ‘ + ****.java
		②代码分析：通过代码里标识的注解对代码进行分析【使用反射】
		③编译检查：通过代码里标识的注解让编译器能够实现基本的编译检查【Override】
-----------
	了解部分：
	* JDK中预定义的一些注解
		* @Override	：检测被该注解标注的方法是否是继承自父类(接口)的
		* @Deprecated：该注解标注的内容，表示已过时//强制使用不影响
		---->用的时候会划横线
		* @SuppressWarnings：压制警告--->让警告消息没有
			* 一般传递参数all  @SuppressWarnings("all")
--->* 自定义注解
		* 格式：
			元注解
			public @interface 注解名称{
				属性列表;
			}
		*注解的本质：----->是一个接口，默认继承Annotation接口--->所有注释类型扩展的通用接口。
		F:\a>javac MyAnno.java
		F:\a>javap MyAnno.class
		Compiled from "MyAnno.java"
		public interface MyAnno extends java.lang.annotation.Annotation {}

---
		* 属性：接口中的抽象方法
			* 要求：
				1. 属性的返回值类型有下列取值
					* 基本数据类型
					* String
					* 枚举
					* 注解
					* 以上类型的数组
---
				2. 定义了属性，在使用时需要给属性赋值
					1. 如果定义属性时，使用default关键字给属性默认初始化值，则使用注解时，可以不进行属性的赋值。
					2. 如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可。
				----->数组赋值时，值使用{}包裹。如果数组中只有一个值，则{}可以省略
				----->枚举类型赋值： *=Person.P1;
				----->注释类型赋值：*=@MyAnno2
				- 
		