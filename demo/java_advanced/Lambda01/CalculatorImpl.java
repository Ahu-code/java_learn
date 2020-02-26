package Lambda01;

//使用Lambda标准格式（有参有返回）

public class CalculatorImpl {
	public static void main(String[] args) {
		invokeCal(10, 20, new Calculator01() {
			
			@Override
			public int cal(int a, int b) {
				return a+b;
			}
		});
		
		//使用匿名内部类
		invokeCal(10, 20, (a,b)->(a+b) );
	}
	
	/*
	 * 定义一个方法，传递两个int类型整数
	 * 参数传递Calculator接口
	 */
	public static void invokeCal(int a, int b ,Calculator01 cal) {
		int sum = cal.cal(a, b);
		System.out.println(sum);
	}
}
