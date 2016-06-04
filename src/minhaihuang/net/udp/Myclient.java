package minhaihuang.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * UDP编程，非面向连接，不安全，效率高
 * 
 * 没有服务端也可发送数据，但是会丢失数据，所以说不安全
 * 创建一个客户端
 * @author 黄帅哥
 *
 */
public class Myclient {

	public static void main(String[] args) throws IOException {
		//1,创建客户端对象，DatagarmSocket
		DatagramSocket client=new DatagramSocket();
		
		//2，准备发送的数据，byte[]
		byte[] b="hello,udp".getBytes();
		
		//3，打包数据，加发送的地址及端口号
		DatagramPacket packet=new DatagramPacket(b,b.length,InetAddress.getLocalHost(),8888);
		
		//4，发送数据
		client.send(packet);
		
		//5,释放资源
		client.close();
	}
}
