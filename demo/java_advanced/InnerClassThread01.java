package HeiMa;

/*
 * 匿名内部类：简化代码
 * 将子类继承父类，重写接口中的方法，创建子类对象合一步完成
 * 格式：
 * 	new 父类/接口(){
 * 		重复父类/接口中的方法
 * }.start;
 */
public class InnerClassThread01 {
	public static void main(String[] args) {
		
		//实现父类
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 20; i++) {
					System.out.println(Thread.currentThread().getName()+"---->thread"+i);
				}
			}
		}.start();
		
		//实现接口
		Runnable run = new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println(Thread.currentThread().getName()+"---->Runnable01 "+i);
				}
			};
		};
		Thread thread = new Thread(run);
		thread.start();
		
		//简化
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println(Thread.currentThread().getName()+"---->Runnable02 "+i);
				}
			}
		}).start();
	}
}
