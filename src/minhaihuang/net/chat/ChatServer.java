package minhaihuang.net.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建一个智能聊天机器人的服务器端，要求能够不断接收到客户端发送的信息，并且回馈相应的信息
 * @author 黄帅哥
 *
 */
public class ChatServer {

	//需要一个map来事先存储数据
	static Map<String,String> map=new HashMap<String, String>();
	
	
	//当创建服务端的对象时就初始化map容器
	public ChatServer(){
		map.put("hello", "hi");
		map.put("i love you","i love you too");
		map.put("name", "hhm");
		map.put("wife", "lyx");
		map.put("123", "456");
	}
	
	//启动服务的方法
	public static void startUp() throws IOException{
		//创建连接
		ServerSocket server=new ServerSocket(10000);
		
		//获取到客户端的对象
		Socket client=server.accept();
		
		//利用获取到的客户端对象来分析客户端传过来的数据
		//输入流，接收客户端传过来的数据
		InputStream in=client.getInputStream();
		//输出流，向客户端反馈数据
		OutputStream out=client.getOutputStream();
		
		//开始分析数据以及回馈数据
		int len=0;
		byte[] b=new byte[1024];
		String s=new String();
		//读数据
		while((len=in.read(b))!=-1){
			s=new String(b,0,len);
			//分析数据，如果有key返回value，否则返回“呵呵”。
			if(map.containsKey(s)){
				String str=map.get(s);
				out.write(str.getBytes());
				System.out.println(str);
			}else{
				System.out.println("呵呵");
			}
		}
		//释放资源
		client.close();
		server.close();
	}
	
	public static void main(String[] args) throws IOException {
		ChatServer server=new ChatServer();
		server.startUp();
	}
}
