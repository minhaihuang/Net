package minhaihuang.net.chatImprove;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 创建一个智能聊天机器人的客户端
 * @author 黄帅哥
 *
 */
public class ChatClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client=new Socket(InetAddress.getLocalHost(),10000);
		
		//利用输出流往服务器发送数据
		OutputStream out=client.getOutputStream();
		//利用输入流接收服务器反馈回来的数据
		InputStream in=client.getInputStream();
		
		//从键盘输入数据，不断向服务器发送数据
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			//接收键盘输入的数据
			String mess=sc.nextLine();
			
			//当输入的语句为“exit”时，结束服务，停止服务器与客户端，结束聊天
			if(mess.equals("exit")){
				break;
			}
			
			//发送给服务器
			out.write(mess.getBytes());
			
			//接收服务器反馈的信息
			byte[] b=new byte[1024];
			int len=in.read(b);
			String str=new String(b,0,len);
			System.out.println(str);
		}
		
		//结束服务，释放资源
		client.close();
	}
}
