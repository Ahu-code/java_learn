package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
	* 元注解：用于描述注解的注解
		* @Target：描述注解能够作用的位置
			* ElementType取值：
				* TYPE：可以作用于类上
				* METHOD：可以作用于方法上
				* FIELD：可以作用于成员变量上
		* @Retention：描述注解被保留的阶段//java有三个阶段
			--> @Retention(RetentionPolicy.RUNTIME)：当前被描述的注解，会保留到class字节码文件中，并被JVM读取到
		* @Documented：描述注解是否被抽取到api文档中
		* @Inherited：描述注解是否被子类继承
 */

/* 
ElementType.TYPE：能修饰类、接口或枚举类型
ElementType.FIELD：能修饰成员变量
ElementType.METHOD：能修饰方法
ElementType.PARAMETER：能修饰参数
ElementType.CONSTRUCTOR：能修饰构造器
ElementType.LOCAL_VARIABLE：能修饰局部变量
ElementType.ANNOTATION_TYPE：能修饰注解
ElementType.PACKAGE：能修饰包 
 */
//@Target(value= {ElementType.TYPE})
@Target(ElementType.TYPE)//与上一个相同，原因在于只有一个value值
@Retention(RetentionPolicy.RUNTIME)//一般都用这个：当前被描述的注解，会保留到class字节码文件中，并被JVM读取到
@Documented
public @interface MyAnno3 {

}
