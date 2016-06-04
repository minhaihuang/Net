package minhaihuang.net.chatImprove;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建一个智能聊天机器人的服务器端，升级版
 *1，能同时由多个客户端访问
 *2，要求能够不断接收到客户端发送的信息，并且回馈相应的信息
 *
 *思路：利用多线程来做，每一个客户端单独设置一个线程。
 * @author 黄帅哥
 *
 */
public class ChatServer implements Runnable {

	 Socket client;
	static InputStream in;
	static OutputStream out;
	
	//当创建服务端的对象时就初始化map容器
	public ChatServer(){
		map.put("hello", "hi");
		map.put("i love you","i love you too");
		map.put("name", "hhm");
		map.put("wife", "lyx");
		map.put("123", "456");
	}
	
	public ChatServer(Socket client){
		this();
		this.client=client;
	}
	@Override
		public void run() {
				startUp();	
		}

	//需要一个map来事先存储数据
	static Map<String,String> map=new HashMap<String, String>();
	
	
	//启动服务的方法
	public void startUp(){
		
		 try {
			
			//利用获取到的客户端对象来分析客户端传过来的数据

			//输入流，接收客户端传过来的数据!!
			 in=client.getInputStream();
			
			//输出流，向客户端反馈数据
			 out=client.getOutputStream();
			 
			//开始分析数据以及回馈数据
				int len=0;
				byte[] b=new byte[1024];
				//读数据
				while((len=in.read(b))!=-1){
					String s=new String(b,0,len);
					//分析数据，如果有key返回value，否则返回“呵呵”。
					if(map.containsKey(s)){
						String str=map.get(s);
						out.write(str.getBytes());
						System.out.println(str);
					}else{
						System.out.println("呵呵");
					}
				}
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		//创建连接
		ServerSocket server=new ServerSocket(10000);
		while(true){
		//获取到客户端的对象
		Socket client=server.accept();
		//每次获取到一个客户端就新开一个线程
		new Thread(new ChatServer(client)).start();
		}
	}
}
