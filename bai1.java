package bai1;

import java.net.InetAddress;
import java.net.UnknownHostException;
public class bai1 {

	
	public static void main(String[] args)
	{
	try{
	InetAddress host = InetAddress.getByName(null);
	String hostName = host.getHostName();
	System.out.println("Host name:"+hostName);
	System.out.println("Dia chi IP:"+host.getHostAddress());
	}
	catch(UnknownHostException e)
	{
	System.out.println("Khong tim thay dia chi");

	
	}
	}

}
