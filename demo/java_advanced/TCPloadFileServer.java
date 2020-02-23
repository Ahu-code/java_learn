package HeiMa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*
 * 文件上传案例服务器：读取客户端上传文件，保存到服务器的硬盘，给客户端回写“上传成功！” 
 * 
 * 步骤：
 * 		1.创建一个服务器ServerSocket对象，和系统指定的端口号
 * 		2.使用ServerSocket对象的accept方法，获取到请求的Socket对象
 * 		3.使用Socket对象中的getInputStream，获取到网络字节输入流InputStream
 * 		4.判断是否存在路径，不存在则创建
 * 		5.创建一个本地字节输出流FileoutputStream，构造方法中绑定输出地
 * 		6.使用网络字节输入流InputStream中的read，读取上传文件
 * 		7.使用本地字节输出流FileOutputStream中的write，将读取文件写到硬盘上
 * 		8.使用Socket对象中的getOutputStream，获取到网络字节输出流OutputStream对象
 * 		9.使用网络字节输出流OutputStream的write方法，给客户端写上“上传成功！”
 * 	   10.释放资源（FileoutputStream, Socket， ServerSocket）
 */

/*
 * void shutdownOutput()   禁用此套接字的输出流。  
 * 对于一个TCP套接字，先前写入的数据将被发送后正常关闭TCP连接,后跟终止。
 */
public class TCPloadFileServer {
	public static void main(String[] args) throws IOException {
		//1.创建一个服务器ServerSocket对象，和系统指定的端口号
		ServerSocket server = new ServerSocket(8800);
		
		/*
		 * 让服务器一直处于监听状态，即搞个死循环
		 * 有一个客户端上传一个文件，就一直上传
		 */
		
		while(true) {
			/*
			 * 使用多线程，提高程序效率
			 * 有一个客户端上传文件，就开启一个线程
			 */
			new Thread(new Runnable() {
				//完成文件上传
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						//2.使用ServerSocket对象的accept方法，获取到请求的Socket对象
						Socket socket = server.accept();
						//3.使用Socket对象中的getInputStream，获取到网络字节输入流InputStream
						InputStream is = socket.getInputStream();
						//4.判断是否存在路径，不存在则创建
						File file = new File("F:\\upload");
						//5.创建一个本地字节输出流FileoutputStream，构造方法中绑定输出地
						if( !file.exists() ) {
							file.mkdirs();
						}
						String fileName = "itcast" + System.currentTimeMillis() + new Random().nextInt(999999) + ".jpg";
						FileOutputStream fos = new FileOutputStream(file+"\\"+fileName);
						//6.使用网络字节输入流InputStream中的read，读取上传文件
					//	System.out.println("1111111111111111111111111111111111111111");
						
						int len = 0;
						byte[] bytes = new byte[1024];
						while( (len=is.read(bytes)) != -1)
							//7.使用本地字节输出流FileOutputStream中的write，将读取文件写到硬盘上
							fos.write(bytes, 0, len);

						//socket.shutdownOutput();
						
						//System.out.println("--------------------------------------while");
						//while会发生死循环，因为第一次在客户端读入文件时，在-1结束，但不能把-1读入，
						//即上传服务器时，没有结束标志
						//read方法:如果 len不为零，该方法阻塞直到输入可用；否则，没有字节读取和 0返回。
						
						//8.使用Socket对象中的getOutputStream，获取到网络字节输出流OutputStream对象
						OutputStream os = socket.getOutputStream();
						
						//9.使用网络字节输出流OutputStream的write方法，给客户端写上“上传成功！”
						os.write("上传成功！".getBytes());
					
						//10.释放资源（FileoutputStream, Socket， ServerSocket）
						os.close();
						fos.close();
						socket.close();	
					}
					catch(IOException e) {
						System.out.println(e);
					}
				}
			}).start();
		}
	
		//server.close();
	}
}
