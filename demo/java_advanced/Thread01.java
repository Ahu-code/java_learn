package HeiMa;

/*
 * java.lang.Thread
 * 创建多线程程序（必须继承Thread
 * 方式一：
   1.创建一个Thread子类
   2.在Thread子类中重写Thread类中的run方法，设置线程作用(干什么?)
   3.创建Thread类子类的对象
   4.调用Thread类中的start方法，开启新的线程，执行run方法
	void start()使该线程开始执行（开辟新的栈空间）
	 结果是两个线程同时运行：当前线程（从调用返回到start方法）和另一个线程（执行其run方法）。
	不止一次启动线程是不合法的。 特别地，一旦线程完成执行就可能不会重新启动。
	java属于抢占式调度，若等级一样，那便随机
 */
public class Thread01 {
	public static void main(String[] args) {
		MyThread01 mt = new MyThread01();
		
		mt.start();
		System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < 20; i++) {
			System.out.println("main"+i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
}
