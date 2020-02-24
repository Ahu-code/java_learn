package HeiMa;

public class ThreadTicket {
	public static void main(String[] args) {
		RunnableTicket run = new RunnableTicket();
		
		//只创建一个Runnable实现类，来进行共享票源
		Thread thread01 = new Thread(run);
		Thread thread02 = new Thread(run);
		Thread thread03 = new Thread(run);
		
		thread03.start();
		thread02.start();
		thread01.start();

		
	}
}
