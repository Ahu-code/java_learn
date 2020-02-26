package Lambda01;

/*
 * Lambda省去面向对象的条条框框，格式由3个部分组成：
一些参数
一个箭头
一段代码
Lambda表达式的标准格式为：
(参数类型 参数名称) ‐> { 代码语句 }
() ‐> System.out.println("多线程任务执行！")
--------
格式说明：
小括号内的语法与传统方法参数列表一致：无参数则留空；多个参数则用逗号分隔。
-> 是新引入的语法格式，代表指向动作。

(参数类型 参数名称) ‐> { 代码语句 }

 */
public class lambda01 {
	public static void main(String[] args) {
		//调用invokeCook方法，参数是Cook接口，传递Cook接口的匿名内部类
		invokeCook(new Cook(){
			@Override
			public void makeFood() {
				// TODO Auto-generated method stub
				System.out.println("吃饭了");
			}
		});
		
		invokeCook(()->System.out.println("吃饭了lambda"));
	}
	
	//定义一个方法，参数传递Cook接口，方法内部调用Cook接口中的方法makeFood
	public static void invokeCook(Cook cook) {
		cook.makeFood();
	}
	
	
}
