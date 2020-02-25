package HeiMa;

public class ThreadPoolRunnableImpl implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + "创建了一个新的线程--->");
	}
}
