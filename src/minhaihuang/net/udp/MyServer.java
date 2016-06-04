package minhaihuang.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 创建一个自己的服务端
 * @author 黄帅哥
 *
 */
public class MyServer {

	public static void main(String[] args) throws IOException {
		//1,创建服务端+端口号
		DatagramSocket server=new DatagramSocket(8888);
		
		//2,准备接受数据的容器byte[]
		byte[] b=new byte[1024];
		
		//3,将数据打包成包
		DatagramPacket packet=new DatagramPacket(b, b.length);
		
		//4，接收数据
		server.receive(packet);//该方法是一个阻塞线程的方法，等待客户端发来数据
		
		//5,分析数据
		b=packet.getData();
		System.out.println(new String(b));
		//6,释放资源
		server.close();
	}
}
