package HeiMa;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class BSTCPServer {
	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(8080);
		//浏览器工作原理是遇到图片会开启一个线程进行单独的访问,因此在服务器端加入线程技术。
		//请求一次就开一个线程
		
		while(true) {
			
			Socket socket = server.accept();
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						InputStream is = socket.getInputStream();
						
						/*int len = 0;
						byte[] bytes = new byte[1024];
						while( (len=is.read(bytes)) != -1 ) {
							System.out.println(new String(bytes, 0, len));
						}*/
						
						//把is网络字节输入流对象，转化为字符缓冲输入流--->需要用readline方法
						BufferedReader br = new BufferedReader(new InputStreamReader(is));
						//把客户端请求信息第一行读取出来
						String line = br.readLine();
						System.out.println(line);
						
						
						String[] arr = line.split(" ");
						String htmlpath = arr[1].substring(2);
						
						//创建一个本地字节输入流，构造方法绑定html路径
						FileInputStream fis = new FileInputStream(htmlpath);
						//使用Socket方法中的getoutputstream
						OutputStream os = socket.getOutputStream();
						
						//写入协议响应头，固定写法
						os.write("HTTP/1.1 200 OK\r\n".getBytes());
						os.write("Content‐Type:text/html\r\n".getBytes());
						os.write("\r\n".getBytes());
						
						//一读一写
						int len = 0;
						byte[] bytes = new byte[1024];
						while( (len=fis.read(bytes)) != -1 ) {
							os.write(bytes, 0, len);
						}
						
						//释放资源
						fis.close();
						socket.close();
					}
					catch(IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
		//server.close();
	}
}
