package HeiMa;

/*
 * Thread(Runnable target) 分配一个新的 Thread对象。
 *  
 * 创建线程方式二
 * Runnable接口应由任何类实现，其实例将由线程执行。 该类必须定义一个无参数的方法，称为run 。
  1. 定义Runnable接口的实现类，并重写该接口的run()方法，该run()方法的方法体是为该线程设置任务。
  2. 创建Runnable接口实现类的实例，创建Thread对象,构造方法中传递Runnable接口实现类对象，该Thread对象才是真正的线程对象。
  3. 调用线程对象的start()方法来启动线程，开启新的run。
 */
public class Thread02 {
	public static void main(String[] args) {
		Runnable01 run = new Runnable01();
		Thread thread = new Thread(run);
		
		
		thread.start();
		
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + i);
		}
	}
}
