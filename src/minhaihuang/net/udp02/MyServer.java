package minhaihuang.net.udp02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP编程升级版，模拟一个聊天的工具
 * 创建一个自己的服务端，使服务端不停止，可不断接受数据
 * @author 黄帅哥
 *
 */
public class MyServer {

	public static void main(String[] args) throws IOException {
		
		//1,创建服务端+端口号，注意，创建服务端不能再while里面，否则将会出现端口被占用的异常
		DatagramSocket server=new DatagramSocket(8888);
		
		while(true){//死循环，不断接收
		//2,准备接受数据的容器byte[]
		byte[] b=new byte[1024];
		
		//3,将数据打包成包
		DatagramPacket packet=new DatagramPacket(b, b.length);
		
		//4，接收数据
		server.receive(packet);//该方法是一个阻塞线程的方法，等待客户端发来数据
		
		//5,分析数据
		b=packet.getData();
		System.out.println(new String(b));
		}
		//6,释放资源
		//server.close();
	}
}
