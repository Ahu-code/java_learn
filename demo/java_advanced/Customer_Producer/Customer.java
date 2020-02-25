package Customer_Producer;

/*
 * 包子铺线程生产包子，吃货线程消费包子。当包子没有时（包子状态为false），吃货线程等待，包子铺线程生产包子
 * （即包子状态为true），并通知吃货线程（解除吃货的等待状态）,因为已经有包子了，那么包子铺线程进入等待状态。
 * 接下来，吃货线程能否进一步执行则取决于锁的获取情况。如果吃货获取到锁，那么就执行吃包子动作，
 * 包子吃完（包子状态为false），并通知包子铺线程（解除包子铺的等待状态）,吃货线程进入等待。
 * 包子铺线程能否进一步执行则取决于锁的获取情况。
 */

public class Customer extends Thread{
	private BaoZi baozi;
	
	public Customer(BaoZi baozi) {
		this.baozi = baozi;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (baozi) {
				if(baozi.flag == false) {
					try {
						baozi.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//若有包子，即被唤醒，那就吃包子
				System.out.println("吃货正在吃"+baozi.pi+baozi.xian+"的包子");
				//3秒吃完
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//吃完后
				//修改包子状态false
				baozi.flag = false;
				
				
				//吃货唤醒包子铺继续生产
				baozi.notify();
				System.out.println("吃货花3秒吃完"+baozi.pi+baozi.xian+"的包子");
			}
		}
	}
}
