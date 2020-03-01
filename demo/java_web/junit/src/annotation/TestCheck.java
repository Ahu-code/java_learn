package annotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * 简单的测试框架
 * 当方法执行后，会自动被检测的方法是加了@Check注解了的方法
 */
public class TestCheck {
	public static void main(String[] args) throws IOException {
		//1，创建对象
		Calculator c = new Calculator();
		//2.获取字节码对象
		Class CalClass = c.getClass();
		//3.获取所有方法
		Method[] methods = CalClass.getMethods();
		
		//记录到文件中所需要的变量
		int number = 0;//出现异常次数
		BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
		
		
		//4.判断是否有@Check注解
		for(Method m:methods) {
			if(m.isAnnotationPresent(Check.class)) {
				//5.若有就执行
				try {
					m.invoke(c);
				} catch (Exception e) {
					//记录到文件中
					number++;
					
					bw.write(m.getName()+"方法出异常了");
					bw.newLine();
					bw.write("异常的名称是："+e.getCause().getClass().getSimpleName());
					bw.newLine();
					bw.write("异常的原因是："+e.getCause().getMessage());
					bw.newLine();
					bw.write("----------------------");
				
				}
			}
				
		}
		bw.write("本次测试一共出现"+number+"次异常");

		bw.flush();
		bw.close();
	}
}
