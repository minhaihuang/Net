package minhaihuang.net.elementary;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 尝试获取一个电脑的主机名以及ip地址
 * 
 * @author 黄帅哥
 *
 */
public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		
		//获取本电脑的主机名以及Ip地址
		InetAddress ia=InetAddress.getLocalHost();
		
		//获取本机的主机名
		String name=ia.getHostName();
		//获取本机的ip地址
		String ip=ia.getHostAddress();
		System.out.println(name);
		System.out.println(ip);
		
		
		//根据域名获取主机名以及主机的ip地址,获取百度的主机名以及ip地址
		InetAddress ia2=InetAddress.getByName("www.163.com");	
		//获取百度的主机名
		String name1=ia2.getHostName();
		//获取百度主机的ip地址
		String ip1=ia2.getHostAddress();
		System.out.println(name1);
		System.out.println(ip1);
	}
}
