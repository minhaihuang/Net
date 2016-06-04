package minhaihuang.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建TCP服务端
 * @author 黄帅哥
 *
 */
public class MyServer {

	public static void main(String[] args) throws IOException {
		//1,创建服务端对象 ServerSocket 对象
		ServerSocket server=new ServerSocket(8080);
		
		//2,获取客户端的对象
		Socket soc=server.accept();//这是一个阻塞线程的方法
		
		//3,通过获取到的客户端对象获取客户端的信息
		String ip=soc.getInetAddress().getHostAddress();
		InputStream in=soc.getInputStream();
		byte[] b=new byte[1024];
		
		int len=in.read(b);
		String message=new String(b,0,len);
		System.out.println(message);
		//4,关闭资源
		server.close();
	}
}
