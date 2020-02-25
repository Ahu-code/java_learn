package HeiMa;

/*
 * 一个调用了某个对象的 Object.wait 方法的线程会等待另一个线程调用此对象的
 * Object.notify()方法 或 Object.notifyAll()方法。
 * 等待与唤醒机制
 * 		注意：
 * 			顾客和老板线程必须使用同步代码块包裹起来，以保证等待与唤醒只有一个在执行
 * 			同步使用的锁对象必须唯一
 * 			只有锁对象才能调用wait() 和 notify()
 */

/* 在Object类中
 * void wait() 使当前线程等待另一个线程调用此对象的方法或 notify() /notifyAll()方法。  
 * void notify() 唤醒一个在这个对象的监视器上等待的单个线程,执行wait之后的代码。
 * void notifyAll() 唤醒正在等待此对象监视器上的所有线程。 
 * void wait(long timeout) 使当前线程等待另一个线程调用此对象的方法或 notify() /notifyAll()方法。  
 *    没人唤醒，timeout毫秒醒来
 * void notify(long timeout) 唤醒一个在这个对象的监视器上等待的单个线程,执行wait之后的代码。
 * 
 */

public class WaitAndNotify01 {
	public static void main(String[] args) {
		//创建锁对象，保证唯一
		Object obj = new Object();
		//创建一个顾客线程
		new Thread() {
			public void run() {
				while(true) {
					synchronized (obj) {
						System.out.println("顾客1告诉老板包子种类和对象");
						try {
							obj.wait();
							System.out.println("顾客1取走包子");
						}catch (InterruptedException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}
			}
		}.start();
		
		//创建一个顾客线程
		new Thread() {
			public void run() {
				while(true) {
					synchronized (obj) {
						System.out.println("顾客2告诉老板包子种类和对象");
						try {
							obj.wait();
							System.out.println("顾客2取走包子");
						}catch (InterruptedException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}
			}
		}.start();
		
		//创建一个老板线程
		new Thread() {
			public void run() {
				while(true) {
					//先睡眠5秒
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//保证等待和唤醒的线程只能有一个执行，需要使用同步技术
					synchronized (obj) {
						System.out.println("老板做好包子了，告知顾客可以来吃了");
						//obj.notify();
						obj.notifyAll();
					}
				}
			}
		}.start();
	}
}




