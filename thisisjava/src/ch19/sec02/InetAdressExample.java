package ch19.sec02;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdressExample {

	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("my computer IP address: "+local.getHostAddress());
			
			InetAddress[] isArr = InetAddress.getAllByName("www.naver.com");
			for(InetAddress remote : isArr) {
				System.out.println("www.naver.com IP adress: "+remote.getHostAddress());
			}
			
			
		} catch(UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
