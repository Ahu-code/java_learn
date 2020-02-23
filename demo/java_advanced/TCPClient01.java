package HeiMa;

import java.io.IOException; 
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * TCP通信的客户端：向服务器发送连接请求，给服务器发送数据，读取服务器回写数据 
 * java.net.Socket
 *   这个类实现了客户端套接字（也被称为“套接字”）。套接字是两台机器之间的通信的一个端点。
 *   套接字:包含了Ip地址和端口号的网络单位
 *   
 *   构造方法：
 *   Socket(String host, int port) 创建一个流套接字，并将其与指定的主机上的指定端口号连接起来。 
 *   
 *   String host :服务器主机的名称/服务器的IP地址
 *   int port： 服务器的端口号
 *   
 *   成员方法：
 *   	OutputStream getOutputStream() 返回此套接字的输出流。 
 *   	InputStream getInputStream() 返回此套接字的输入流。 
 *   	void close() 关闭这个套接字   
 *   
 *   实现步骤：
 *   	1.创建一个客户端对象Socket，构造方法绑定服务器的IP地址和端口号
 *   	2.使用Socket对象中的getOutputStream() 获取网络字节输出流OutputStream对象 。
 *   	3.使用网络字节输出流OutputStream对象中的write方法，给服务器发送数据
 *   	4.使用Socket对象中的 getInputStream() 获取网络字节输入流InputStream对象 。 
 *   	5.使用网络字节输入流InputStream对象中的read方法，读取服务器中回写的数据
 *   	6.关闭资源(Socket)
 *   注意：
 *   	1.客户端和服务器进行交互，必须使用Socket中提供的网络流，不得使用自己创建的对象
 *   	2.当我们创建客户端对象Socket的时候，就会去请求服务器和服务器经过3次握手建立连接通路，
 *   		这时，如果服务器还未启动，就会抛出异常
 */

/*
 * 1.文件名称写死的问题
服务端，保存文件的名称如果写死，那么最终导致服务器硬盘，只会保留一个文件，建议使用系统时间优化，保证文件名称唯一，代码如下：
FileOutputStream fis = new FileOutputStream(System.currentTimeMillis()+".jpg") // 文件名称
BufferedOutputStream bos = new BufferedOutputStream(fis);
2. 循环接收的问题
服务端，指保存一个文件就关闭了，之后的用户无法再上传，这是不符合实际的，使用循环改进，可以不断的接收不同用户的文件，代码如下：
// 每次接收新的连接,创建一个Socket---->搞个死循环
while（true）{
Socket accept = serverSocket.accept();
......
}
3. 效率问题
服务端，在接收大文件时，可能耗费几秒钟的时间，此时不能接收其他用户上传，所以，使用多线程技术优化，代码如下：
// 每次接收新的连接,创建一个Socket
while（true）{
Socket accept = serverSocket.accept();
......
}
while（true）{
Socket accept = serverSocket.accept();
// accept 交给子线程处理.
new Thread(() ‐> {
......
InputStream bis = accept.getInputStream();
......
}).start();
}
 */


public class TCPClient01 {
	public static void main(String[] args) throws IOException {
		//1.创建一个客户端对象Socket，构造方法绑定服务器的IP地址和端口号
		Socket socket = new Socket("127.0.0.1",8888);
		//2.使用Socket对象中的getOutputStream() 获取网络字节输出流OutputStream对象 。
		OutputStream os = socket.getOutputStream();
		//3.使用网络字节输出流OutputStream对象中的write方法，给服务器发送数据
		os.write("你好服务器".getBytes());
		
		//4.使用Socket对象中的 getInputStream() 获取网络字节输入流InputStream对象 。 
		InputStream is = socket.getInputStream();
		
		//5.使用网络字节输入流InputStream对象中的read方法，读取服务器中回写的数据
		byte[] bytes = new byte[1024];
		int len = is.read(bytes);
		System.out.println(new String(bytes, 0, len));
		
		//6.关闭资源(Socket)
		socket.close();	//现若直接关闭，会报错 ConnectException: Connection refused: connect
		//因为还未建立服务器
		
	}
}
