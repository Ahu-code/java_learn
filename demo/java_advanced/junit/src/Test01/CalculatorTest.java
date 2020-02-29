package Test01;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import junit.Calculator;

/*
 * * Junit使用：白盒测试
		* 步骤：
			1. 定义一个测试类(测试用例)
				* 建议：
					* 测试类名：被测试的类名Test		CalculatorTest
					* 包名：xxx.xxx.xx.test		cn.itcast.test

			2. 定义测试方法：可以独立运行
				* 建议：
					* 方法名：test测试的方法名		testAdd()
					* 返回值：void
					* 参数列表：空参

			3. 给方法加@Test
			4. 导入junit依赖环境
 */

public class CalculatorTest {

	@Before
	public void init() {
		System.out.println("init...");
	}
	
	@After
	public void close() {
		System.out.println("close...");
	}
	
	@Test
	public void testAdd() {
		System.out.println("add...");
		Calculator a = new Calculator();
		int result = a.add(2, 3);
		//System.out.println(result);
		Assert.assertEquals(result, 8);
	}

}
