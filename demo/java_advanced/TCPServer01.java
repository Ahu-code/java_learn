package HeiMa;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * TCP通信的服务器端，接收客户端的请求，读取客户端发送的数据，给客户端回写数据
 * 表示服务器的类：
 * 		java.net.ServerSocket
 * 
 *  构造方法：
 *  ServerSocket(int port) 创建一个服务器套接字，绑定到指定的端口。
 *  服务器必须明确是哪个客户端请求的服务器，
	因此可以使用accept方法，来获取客户端对象Socket
 *  Socket accept() 监听要对这个套接字作出的连接并接受它。  
 *  
 *  服务器实现步骤：
 *  	1.创建服务器ServerSocket对象和系统要指定的端口号
 *  	2.使用serverSocket对象中的方法accept，获取客户端对象Socket
 *   	3.使用Socket对象中的 getInputStream() 获取网络字节输入流InputStream对象 。 
 *   	4.使用网络字节输入流InputStream对象中的read方法，读取客户器中发送的数据
 *   	5.使用Socket对象中的getOutputStream() 获取网络字节输出流OutputStream对象 。
 *   	6.使用网络字节输出流OutputStream对象中的write方法，给客户端回写数据
 *   	7.释放资源（Socket， ServerSocket）
 */
public class TCPServer01 {
	public static void main(String[] args) throws IOException {
		//1.创建服务器ServerSocket对象和系统要指定的端口号
		ServerSocket server = new ServerSocket(8888);
		//2.使用serverSocket对象中的方法accept，获取客户端对象Socket
		Socket socket = server.accept();
		//3.使用Socket对象中的 getInputStream() 获取网络字节输入流InputStream对象 。
		InputStream is = socket.getInputStream();
		//4.使用网络字节输入流InputStream对象中的read方法，读取客户器中发送的数据
		byte[] bytes = new byte[1024];
		int len = is.read(bytes);
		System.out.println(new String(bytes, 0, len));
		//5.使用Socket对象中的getOutputStream() 获取网络字节输出流OutputStream对象 。
		OutputStream os = socket.getOutputStream();
		
		//6.使用网络字节输出流OutputStream对象中的write方法，给客户端回写数据
		os.write("收到谢谢".getBytes());
		
		//7.释放资源（Socket， ServerSocket）
		socket.close();
		server.close();
	}
}
