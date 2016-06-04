package minhaihuang.net.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TCP协议，面向连接，保证了数据安全，但是效率相对较低
 * 
 * 若服务端不开启，客户端无法发送数据
 * @author 黄帅哥
 *
 */
public class MyClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//TCP创建客户端
		
		//1，创建客户端，指定主机名以及端口号
		Socket socket=new Socket(InetAddress.getLocalHost(),8080);
		
		//2,利用socket获取流对象，此处选择输出流
		OutputStream out=socket.getOutputStream();
		
		//3，准备数据
		byte[] b="hello,TCP".getBytes();
		
		//4,利用流操作数据
		out.write(b);
		
		//5,关闭流
		//out.close();//没必要关闭它，因为out是根据socket来获取的，当socket关闭时，out自然就会关闭
		socket.close();
	}
}
