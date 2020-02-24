package HeiMa;

/*
 * public String getName() :获取当前线程名称。
 * public void start() :导致此线程开始执行; Java虚拟机调用此线程的run方法。
 * public void run() :此线程要执行的任务在此处定义代码。
 * public static void sleep(long millis) :使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）。
 * public static Thread currentThread() :返回对当前正在执行的线程对象的引用。
 */

/* 设置线程名称：
 * 1.void setName(String name) 改变该线程的名称等于参数 name。  
 * 2.创建一个带参构造方法，参数传递线程的名称，调用父类的带参构造方法，
 * 	把名称传递给父类，让父类(Thread)给子线程取个名字
 * 	Thread(String name) 分配一个新的 Thread对象。
 */
public class MyThread01 extends Thread{
	public MyThread01() {
	}
	
	public MyThread01(String name) {
		super(name);
	}
	
	@Override
	public void run() {
/*		for (int i = 0; i < 20; i++) {
			System.out.println(i);
			}*/
		
		/*	String name = getName();
			System.out.println(name);*/
		
		/*Thread t = Thread.currentThread();
		System.out.println(t);*/
		
		//获取线程名称
		System.out.println(Thread.currentThread().getName());
	}
}	


