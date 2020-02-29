package annotation;

/*
 * 	1. 属性的返回值类型有下列取值
		* 基本数据类型
		* String
		* 枚举
		* 注解
		* 以上类型的数组
 */
public @interface MyAnno {
	int age();
	String name() default "张三";
//	String show2();
//		
//	Person per();
	MyAnno2 anno2();
		
//		String[] strs();
//	Work work();
}
