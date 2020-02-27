
* Junit使用：白盒测试
* 步骤：
	1. 定义一个测试类(测试用例)
		* 建议：
		* 测试类名：被测试的类名Test	CalculatorTest
		* 包名：xxx.xxx.xx.test	cn.itcast.test
	2. 定义测试方法：可以独立运行
		* 建议：
		* 方法名：test测试的方法名		testAdd()
		* 返回值：void
		* 参数列表：空参
	3. 给方法加@Test
	4. 导入junit依赖环境
* 判定结果：
	* 红色：失败
	* 绿色：成功
	* 一般我们会使用断言操作来处理结果
	* Assert.assertEquals(期望的结果,运算的结果);
* 补充：
* @Before:* 修饰的方法会在测试方法之前被自动执行
* @After：* 修饰的方法会在测试方法执行之后自动被执行
-----------------------------------------------------------------
2.java三个阶段
--1.源代码阶段。Source
---->通过类加载器到内存中
--2.Class类对象：主要有成员变量（Field[] fields），构造方法（Constructor[] cons），成员方法（Method[] methods）
----->创建对象
--3.Runtime运行时阶段 new 类();
--------------------------------------------------------------------
3.反射机制：框架设计的灵魂
将类的各个组成部分封装为其他对象
       好处：
		1. 可以在程序运行过程中，操作这些对象。
   		2. 可以解耦，提高程序的可扩展性。
-----------------------------------------------------------
4.获取Class对象的方式：（对应2中的三个阶段）
1.第一个阶段：通过Class.forName("全类名")将字节码文件加载进内存。
-->多用于配置文件，，将类名定义在配置文件中。读取文件，加载类
2.第二个阶段：通过类名的属性class获取。
-->多用于参数的传递
3.三： 对象.getClass()  Object类中方法 getClass() 返回该Object运行时类。  
-->多用于对象的获取字节码的方式
**结论**
---->通过==来验证，
----->同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，不论通过哪一种方式获取的Class对象都是同一个。

------------------------------------------------------------
4. Class对象功能：
	* 获取功能：
		1. 获取成员变量们
				* Field[] getFields()
			--------->获取所有public修饰的成员变量
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
---------------------------------------------------
5.---对各成员变量进行操作---
* Field：成员变量
	* 操作：
		1. 设置值
			* void set(Object obj, Object value)  
		2. 获取值
			* get(Object obj) -->获取此类
		3. 忽略访问权限修饰符的安全检查
			* setAccessible(true):暴力反射
--->		
Field field1 = personClass.getField("a");//獲取指定名稱
		//獲取成員變量a
		Person p = new Person();
		Object value = field1.get(p);
		System.out.println(value);
		field1.set(p, 1000);
		System.out.println(p);
--------
* Constructor:构造方法
	--->创建对象：
		* T newInstance(Object... initargs)  
		* 如果使用空参数构造方法创建对象，操作可以简化：Class对象的newInstance方法
		r若构造时，为空参，则为初始值
---------
* Method：方法对象
	--->执行方法：
		* Object invoke(Object obj, Object... args)
			Obj是被调用的对象  
	--->获取方法名称：
		* String getName:获取方法名
	利用getMethods()，可以获得Object中一些隐藏的方法，譬如hashCode等