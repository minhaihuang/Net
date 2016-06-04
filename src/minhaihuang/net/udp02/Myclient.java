package minhaihuang.net.udp02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * UDP编程升级版，模拟一个聊天的工具
 * 
 * 创建一个可以不断发送数据的客户端
 * 
 * 没有服务端也可发送数据，但是会丢失数据，所以说不安全
 * 创建一个客户端
 * @author 黄帅哥
 *
 */
public class Myclient {

	public static void main(String[] args) throws IOException {
		
		//1,创建客户端，DatagarmSocket
		DatagramSocket client=new DatagramSocket();
		
		//从键盘输入数据
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){//死循环，不断发送	
		//从键盘输入数据
		String str=sc.nextLine();
		
		//2，准备发送的数据，byte[]
		byte[] b=str.getBytes();
		
		//3，打包数据，加发送的地址及端口号
		DatagramPacket packet=new DatagramPacket(b,b.length,InetAddress.getLocalHost(),8888);
		
		//4，发送数据
		client.send(packet);
		
		}
		//5,释放资源
		//client.close();
	}
}
