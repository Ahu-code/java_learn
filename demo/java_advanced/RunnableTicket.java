package HeiMa;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 为了保证每个线程都能正常执行原子操作,Java引入了线程同步机制。
 * 1. 同步代码块。
 * synchronized(同步锁){
 * 需要同步操作的代码
 * }
 * 同步锁:
 * 对象的同步锁只是一个概念,可以想象为在对象上标记了一个锁.
 * 1. 锁对象 可以是任意类型。
 * 2. 多个线程对象 要使用同一把锁.
 * 注意:在任何时候,最多允许一个线程拥有同步锁,谁拿到锁就进入代码块,其他的线程只能在外等着
 * (BLOCKED)。
 * 
 * 2. 同步方法。
 * public synchronized void method(){
 * 可能会产生线程安全问题的代码
 * }
 * 同步锁是谁?
 * 对于非static方法,同步锁就是this。
 * 	即可用
 * public synchronized void payTicket() {
 * 		synchronized(this){
 * 		.....}
 * }
 * 对于static方法,我们使用当前方法所在类的字节码对象(类名.class)。
 * 
 * 
 * 3. 锁机制。
 class X {
   private final ReentrantLock lock = new ReentrantLock();
   // ...

   public void m() {
     lock.lock();  // block until condition holds
     try {
       // ... method body
     } finally {
       lock.unlock()
     }
   }
 }
 * 
 */




public class RunnableTicket extends Thread{
	//定义多个线程共享的票源
	private static int ticket = 100;
	
	//创建一个锁对象
	//Object obj = new Object();
	
				
	/*@Override
	public void run() {
		//让卖票操作死循环
		while(true) {
			synchronized(obj) {
				if(ticket>0){//有票 可以卖
					//出票操作
					//使用sleep模拟一下出票时间
					try {
					Thread.sleep(50);
					} catch (InterruptedException e) {
					// TODO Auto‐generated catch block
					e.printStackTrace();
					}
					//获取当前线程对象的名字
					String name = Thread.currentThread().getName();
					System.out.println(name+"正在卖:"+ticket--);
					}
			}
		}
	}*/
	
	/*	@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
				payTicket();
		}*/
	
	/*public synchronized void payTicket() {
		if(ticket>0){//有票 可以卖
			//出票操作
			//使用sleep模拟一下出票时间
			try {
			Thread.sleep(50);
			} catch (InterruptedException e) {
			// TODO Auto‐generated catch block
			e.printStackTrace();
			}
			//获取当前线程对象的名字
			String name = Thread.currentThread().getName();
			System.out.println(name+"正在卖:"+ticket--);
		}
	}*/
	
	/*public void payTicket() {
		synchronized(this) {
			if(ticket>0){//有票 可以卖
				//出票操作
				//使用sleep模拟一下出票时间
				try {
				Thread.sleep(50);
				} catch (InterruptedException e) {
				// TODO Auto‐generated catch block
				e.printStackTrace();
				}
				//获取当前线程对象的名字
				String name = Thread.currentThread().getName();
				System.out.println(name+"正在卖:"+ticket--);
			}
		}
	}*/
	
	/*public static synchronized void payTicket() {
		synchronized(RunnableTicket.class) {
			if(ticket>0){//有票 可以卖
				//出票操作
				//使用sleep模拟一下出票时间
				try {
				Thread.sleep(50);
				} catch (InterruptedException e) {
				// TODO Auto‐generated catch block
				e.printStackTrace();
				}
				//获取当前线程对象的名字
				String name = Thread.currentThread().getName();
				System.out.println(name+"正在卖:"+ticket--);
			}
		}
	}*/
	
	Lock lock = new ReentrantLock();
	
	/*	@Override
		public void run() {
			while(true) {
				lock.lock();
				
				if(ticket>0){//有票 可以卖
					//出票操作
					//使用sleep模拟一下出票时间
					try {
					Thread.sleep(50);
					} catch (InterruptedException e) {
					// TODO Auto‐generated catch block
					e.printStackTrace();
					}
					//获取当前线程对象的名字
					String name = Thread.currentThread().getName();
					System.out.println(name+"正在卖:"+ticket--);
				}
				lock.unlock();
			}
		}*/
	
	@Override
	public void run() {
		while(true) {
			lock.lock();
			
			if(ticket>0){//有票 可以卖
				//出票操作
				//使用sleep模拟一下出票时间
				try {
					Thread.sleep(50);
					//获取当前线程对象的名字
					String name = Thread.currentThread().getName();
					System.out.println(name+"正在卖:"+ticket--);
				} catch (InterruptedException e) {
					// TODO Auto‐generated catch block
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		}
	}
}


