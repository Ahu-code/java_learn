package Customer_Producer;

public class Test {
	public static void main(String[] args) {
		BaoZi baozi = new BaoZi();
		
		//创建包子铺线程，开启生产包子
		new BaoziPu(baozi).start();
		
		new Customer(baozi).start();
	}
}
