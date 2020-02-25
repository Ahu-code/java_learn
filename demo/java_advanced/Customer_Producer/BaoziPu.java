package Customer_Producer;

/*
 * 包子铺线程生产包子，吃货线程消费包子。当包子没有时（包子状态为false），吃货线程等待，包子铺线程生产包子
 * （即包子状态为true），并通知吃货线程（解除吃货的等待状态）,因为已经有包子了，那么包子铺线程进入等待状态。
 * 接下来，吃货线程能否进一步执行则取决于锁的获取情况。如果吃货获取到锁，那么就执行吃包子动作，
 * 包子吃完（包子状态为false），并通知包子铺线程（解除包子铺的等待状态）,吃货线程进入等待。
 * 包子铺线程能否进一步执行则取决于锁的获取情况。
 * 
 * 注意：
 * 	包子铺与顾客线程关系——>通信(互斥)
 * 	必须通过同步表示只有一个在工作中
 */

public class BaoziPu extends Thread{
	private BaoZi baozi;
	
	public BaoziPu (BaoZi baozi) {
		this.baozi = baozi;
	}
	
	public void run() {
		int count = 0;//来对生产包子种类进行判断

		while(true) {
			synchronized (baozi) {
				
				if(baozi.flag) {
					//有包子则让顾客去吃
					try {
						baozi.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//被唤醒之后执行，包子铺生产包子
				//交替生产两种包子
				if(count%2 == 0) {
					baozi.pi = "薄皮";
					baozi.xian = "牛肉馅";
				}else {
					baozi.pi = "冰皮";
					baozi.xian = "猪肉馅";
				}
				
				count++;
				System.out.println("包子铺正在生产"+baozi.pi+baozi.xian+"的包子");
				//生产需要3秒
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				baozi.flag = true;
				
				//唤醒顾客线程
				baozi.notify();
				System.out.println("包子铺已经产好了"+baozi.pi+baozi.xian+"的包子");
			}
		}
	}
		
}
