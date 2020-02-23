package HeiMa;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * 1. 【客户端】输入流，从硬盘读取文件数据到程序中。 
 * 2. 【客户端】输出流，写出文件数据到服务端。
 * 3. 【服务端】输入流，读取文件数据到服务端程序。
 * 4. 【服务端】输出流，写出文件数据到服务器硬盘中。
 */
/*
 * 实现步骤：
 * 		1.创建一个本地字节输入流FileInputStream，构造方法中绑定要读取的数据
 * 		2.创建一个客户端Socket对象，构造方法绑定服务器的的IP地址和端口号
 * 		3.使用Socket中的方法getOutputStream，获取网络字节输出流OutputStream对象 。
 * 		4.使用本地字节输入流FileinputStream对象中的read方法，读取本地文件
 * 		5.使用网络字节输出流OutputStream中的write方法，将读取的文件上传到服务器
 * 		6.使用Socket中的getInputStream方法，获取网络字节输入流InputStream对象
 * 		7.使用网络字节输入流InputStream对象中的read方法读取服务器回写的数据
 * 		8.释放资源(FileInputStream，socket)
 */
public class TCPUploadFileClient {
	public static void main(String[] args) throws IOException {
		//1.创建一个本地字节输入流FileInputStream，构造方法中绑定要读取的数据
		FileInputStream fis = new FileInputStream("F:\\a.jpg");
		//2.创建一个客户端Socket对象，构造方法绑定服务器的的IP地址和端口号
		Socket socket = new Socket("127.0.0.1",8800);
		//3.使用Socket中的方法getOutputStream，获取网络字节输出流OutputStream对象 。
		OutputStream os = socket.getOutputStream();
		
		//4.使用本地字节输入流FileinputStream对象中的read方法，读取本地文件
		int len = 0;
		byte[] bytes = new byte[1024];
		while( (len=fis.read(bytes) ) != -1 ) {
			//5.使用网络字节输出流OutputStream中的write方法，将读取的文件上传到服务器
			os.write(bytes, 0, len);
		}
		socket.shutdownOutput();
//		System.out.println("333333333333333333333333333333333");
		
		//6.使用Socket中的getInputStream方法，获取网络字节输入流InputStream对象
		InputStream is = socket.getInputStream();

		//7.使用网络字节输入流InputStream对象中的read方法读取服务器回写的数据
		while( (len=is.read(bytes) ) != -1 )
			System.out.println(new String(bytes, 0, len));
		//socket.shutdownOutput();
		
	//	System.out.println("--------------------------------------while");
		fis.close();
		socket.close();
	}
}



