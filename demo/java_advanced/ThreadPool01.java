package HeiMa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * java.util.concurrent.Executors
 * static ExecutorService newFixedThreadPool(int nThreads) 
 * 	创建一个线程池，使用固定数量的线程操作了共享无界队列。    
 * 	int nThreads 线程数量
 * 返回一个ExecutorService 
 * 
 * java.util.concurrent.ExecutorService 线程池接口
 * Future<?> submit(Runnable task) 提交执行一个Runnable任务并返回一个表示该任务的未来 
 * void shutdown() 启动一个有序的关机，在以前提交的任务被执行，但没有新的任务将被接受。
 * 
 *   使用线程池中线程对象的步骤：
1. 创建线程池对象。（使用Executors工程类中的newFixedThreadPool方法 来创建线程池对象。）
2. 创建Runnable接口子类对象，重写run方法，设置线程任务。
3. 提交Runnable接口子类对象。（调用ExecutorService中的submit方法，传递线程任务，开启线程
4. 关闭线程池(一般不做)。---->调用shutdown方法，一般不用
 */
public class ThreadPool01 {
	public static void main(String[] args) {
		//（使用Executors工程类中的newFixedThreadPool方法 来创建线程池对象。）
		ExecutorService es = Executors.newFixedThreadPool(2);
		//创建Runnable接口子类对象，重写run方法，设置线程任务
		ThreadPoolRunnableImpl ri = new ThreadPoolRunnableImpl();
		
		//调用ExecutorService中的submit方法，传递线程任务，开启线程
		//es.submit(ri);
		//线程池一直开启，使用完后，就归还该线程
		
		es.submit(new ThreadPoolRunnableImpl());
		es.submit(new ThreadPoolRunnableImpl());
		es.submit(new ThreadPoolRunnableImpl());
		es.submit(new ThreadPoolRunnableImpl());
		
		es.shutdown();
	}
}	



