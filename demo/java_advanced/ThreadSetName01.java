package HeiMa;

/* 设置线程名称：
 * 1.void setName(String name) 改变该线程的名称等于参数 name。  
 * 2.创建一个带参构造方法，参数传递线程的名称，调用父类的带参构造方法，
 * 	把名称传递给父类，让父类(Thread)给子线程取个名字
 * 	Thread(String name) 分配一个新的 Thread对象。
 */
public class ThreadSetName01 {
	public static void main(String[] args) {
		MyThread01 mt = new MyThread01();
		mt.setName("小乔");
		mt.start();
		
		//开启多线程
		new MyThread01("旺财").start();
	}
}
